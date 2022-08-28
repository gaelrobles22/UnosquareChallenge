package com.microsoft.unosquarechallenge;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageEvents.AplicationsEvent;
import pageEvents.HomePageEvent;
import pageEvents.NonFreeAppEvent;


import java.util.concurrent.TimeUnit;


public class MainPageTest {
    public static WebDriver driver;
    private HomePageEvent mainHome;
    private AplicationsEvent mainAplications;
    private NonFreeAppEvent mainNonFree;



    @BeforeMethod
    public void setUp() {
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
        driver.quit();
    }

    @Test
    public void fullTestMethod() {
        mainHome.homePageInit();
        mainAplications.aplicationsEvent();
        mainNonFree.nonFreeApp();

    }
}
