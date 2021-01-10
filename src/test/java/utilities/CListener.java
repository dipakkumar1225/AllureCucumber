package utilities;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.TestRunner;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class CListener extends TestRunner implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    private void stepFinished(TestStepFinished event) {
        PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
        String stepName = steps.getStep().getText();
        if (event.getResult().getStatus().toString().equalsIgnoreCase("PASSED")) {
            takeScreenshot(webDriver, event.getResult().getStatus().toString(), stepName);
        } else if (event.getResult().getStatus().toString().equalsIgnoreCase("FAILED")) {
            takeScreenshot(webDriver, event.getResult().getStatus().toString(), stepName);
        }
        Allure.addAttachment(stepName, new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

    private void takeScreenshot(WebDriver driver, String filePath, String screenName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("Screenshots\\" + filePath + "\\" + screenName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
