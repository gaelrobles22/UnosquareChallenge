package pageEvents;

import com.microsoft.unosquarechallenge.MainPageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AplicationsElements;
import pageObjects.HomePageConstant;

import static com.microsoft.unosquarechallenge.MainPageTest.driver;

public class AplicationsEvent {

    public void aplicationsEvent() {

        AplicationsElements aplications = new AplicationsElements(driver);
        aplications.aplicacionesElement.click();

        // Declaramos un Assert para assegurarnos que la lista no se encuentra vacia

        int acount = 0;
        for (int i = 0; i < 3; i++) {
            Assert.assertNotEquals(aplications.getAllElements.size(), 0);
            acount = aplications.getAllElements.size() + acount;
            for (WebElement lista : aplications.getAllElements) {
                String listAplications = lista.getText();
                System.out.println("-->" + listAplications);
            }
            aplications.spanNext.click();
        }

        //imprimimos el total de aplicaciones que existen en las tres paginas
        System.out.println(HomePageConstant.totalApps + acount);

        //Hacemos una espera explicita para encontrar el elemento aplicaciones y nos aseguramos de volver a la pagina 1
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(aplications.aplicacionesElement));
        aplications.aplicacionesElement.click();

        //Try catch para obtener y asegurarnos que estamos en la pagina 1 comparando el texto
        try {
            wait.until(ExpectedConditions.visibilityOf(aplications.assertText));
            Assert.assertEquals(aplications.assertText.getText(), HomePageConstant.checkText);
        } catch (Exception e) {
            System.out.println(HomePageConstant.msgNotFound);
        }
        System.out.println("<------------------------------------------------------------------------------------------>");


    }
    public AplicationsEvent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
