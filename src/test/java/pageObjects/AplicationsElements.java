package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AplicationsElements {

    @FindBy(xpath = "//span[text()='Aplicaciones']")
    public WebElement aplicacionesElement;

    @FindAll({
            @FindBy(how = How.TAG_NAME, using = "h3")
    })
    public List<WebElement> getAllElements;

    @FindBy (xpath = "//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/ul/li[7]/a/span")
    public WebElement spanNext;

    @FindBy (xpath = "//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/p[1]")
    public WebElement assertText;




    public AplicationsElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
