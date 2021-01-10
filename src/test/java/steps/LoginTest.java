package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;
import pages.Form1;

public class LoginTest extends TestRunner  {

    private Form1 form1;

    @Test(priority = 1)
    @Given("Open Page")
    public void openBrowser() {
        webDriver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        form1 = new Form1(webDriver);
    }

    @And("Enter Message")
    public void enterMessage() {
        form1.enterMessage();
    }

    @And("Close pop up")
    public void closePopUp() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        form1.closePopUp();
    }

    @And("Click on Show Message")
    public void clickOnShowMessage() {
        form1.clickButton();
    }

    @Then("Check Message Displayed")
    public void checkMessageDisplayed() {
        form1.getMessage();
    }
}
