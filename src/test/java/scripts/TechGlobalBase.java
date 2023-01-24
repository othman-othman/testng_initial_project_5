package scripts;

import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginPage;

public class TechGlobalBase {

    WebDriver driver;

    TechGlobalLoginPage techGlobalLoginPage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean-ups
        Driver.quitDriver();
    }
}