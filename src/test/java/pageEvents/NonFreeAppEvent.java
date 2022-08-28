package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.NonFreeAppElements;

import static com.microsoft.unosquarechallenge.MainPageTest.driver;

public class NonFreeAppEvent {

    public void nonFreeApp(){


        NonFreeAppElements appPrice = new NonFreeAppElements(driver);

        //imprime los elementos que tengan precio
//        for(WebElement lista: mainPage.getAllElementsWithPrice){
//            String listAplicationsWithPrice = lista.getText();
//            System.out.println("-->" + listAplicationsWithPrice);
//        }

        //Localizamos el primer valor NO GRATUITO de la lista de Aplicaciones

        for (int i = 0; i < 1; i++) {
            WebElement lista = appPrice.getAllElementsWithPrice.get(i);
            String listAplicationsWithPrice = lista.getText();
            lista.click();
            Assert.assertEquals(listAplicationsWithPrice, appPrice.elementPriceComparison.getText());
            // System.out.println("---->"+listaAplicaciontsWithPrice);
        }

    }

    public NonFreeAppEvent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
