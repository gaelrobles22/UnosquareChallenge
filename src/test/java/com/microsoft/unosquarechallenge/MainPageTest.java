package com.microsoft.unosquarechallenge;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageEvents.AplicationsEvent;
import pageEvents.HomePageEvent;
import pageEvents.NonFreeAppEvent;
import pageObjects.HomePageConstant;
import pageObjects.NonFreeAppElements;

import java.util.concurrent.TimeUnit;




public class MainPageTest {


    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static WebDriver driver;
    private HomePageEvent mainHome;
    private AplicationsEvent mainAplications;
    private NonFreeAppEvent mainNonFree;
    private NonFreeAppElements mainNonFreeElement;



    @BeforeMethod
    public void setUp() {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Myreport");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.microsoft.com/es-mx/");
        mainHome = new HomePageEvent(driver);
        mainAplications = new AplicationsEvent(driver);
        mainNonFree =  new NonFreeAppEvent(driver);
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void fullTestMethod() {
        ExtentTest test = extent.createTest("Verify the Microsoft Page").assignAuthor("Gael Gonzalez").
                assignCategory("QA automation").assignDevice("Windows");
        test.info("Test the Microsoft WebSite Aplications");
        mainHome.homePageInit();
        mainAplications.aplicationsEvent();
        mainNonFree.nonFreeApp();

        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(mainNonFreeElement.shopProduct));
            test.pass("The product is available to add in to cart");

        }catch (Exception e){
            System.out.println("No se encuentran los 3 puntos despegables para agregar al carrito");
            test.fail("The 3 points for add to cart is not displayed");
        }

    }
}
