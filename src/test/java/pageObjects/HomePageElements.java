package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.microsoft.com/es-mx/
public  class HomePageElements {

    @FindBy(xpath = "//*[@id='shellmenu_2']")
    public WebElement windowsElement;

    @FindBy(css = "#search")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@id='cli_shellHeaderSearchInput']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"R1MarketRedirect-close\"]")
    public WebElement buttonEspanol;

    @FindBy(name = "tab")
    public WebElement comprarElement;


    public HomePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



}
