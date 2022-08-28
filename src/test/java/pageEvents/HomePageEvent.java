package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePageConstant;
import pageObjects.HomePageElements;

import static com.microsoft.unosquarechallenge.MainPageTest.driver;


public class HomePageEvent {

    public void homePageInit() {

        HomePageElements homePageElements = new HomePageElements(driver);
        homePageElements.windowsElement.click();
        homePageElements.searchIcon.click();
        homePageElements.searchInput.sendKeys(HomePageConstant.item);
        homePageElements.searchIcon.click();


        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(homePageElements.buttonEspanol));
            homePageElements.buttonEspanol.click();
        }catch (Exception e){

            System.out.println(HomePageConstant.popUpMessage);
        }
        homePageElements.comprarElement.click();



    }
     public HomePageEvent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
