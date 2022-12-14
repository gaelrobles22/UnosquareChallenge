package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NonFreeAppElements {

    //Selecciona todos los elementos con precio
    @FindAll({
            @FindBy(how = How.CSS, using = "span[itemprop='price'][aria-hidden]")
    })
    public List<WebElement> getAllElementsWithPrice;

    @FindBy(xpath = "//span[text()='MXN$89.00']")
    public WebElement elementPriceComparison;

    @FindBy(css = "div[aria-label='Get origin games manager and launcher in Store app']")
    public WebElement shopProduct;

    public NonFreeAppElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }




}
