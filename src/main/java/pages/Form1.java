package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Form1 {

    public Form1(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(how = How.CSS, using = "input#user-message")
    private WebElement elementUserMessage;

    @FindBy(how = How.CSS, using = "#get-input > button")
    private WebElement elementBtnShowMessage;

    @FindBy(how = How.CSS, using = "#display")
    private WebElement elementmessage;

    @FindBy(how = How.CSS, using = "a#at-cv-lightbox-close")
    private WebElement elementClosePopup;


    public void enterMessage(){
        elementUserMessage.sendKeys("Hello World. This is the entered message");
    }

    public void clickButton(){
        elementBtnShowMessage.click();
    }

    public void getMessage(){
        System.out.println(elementmessage.getText());
    }

    public void closePopUp(){
        if (elementClosePopup.isDisplayed()) {
            elementClosePopup.click();
        }
    }
}
