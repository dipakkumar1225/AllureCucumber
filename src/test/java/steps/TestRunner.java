package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"classpath:Login.feature"},
        plugin = {"summary","pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm","utilities.CListener"},
        glue = {"steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public static WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("hello: inside teardown");
        }
    }
}
