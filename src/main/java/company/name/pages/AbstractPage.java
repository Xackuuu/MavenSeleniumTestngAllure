package company.name.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import static io.qameta.allure.Allure.step;

public abstract class AbstractPage {

    private String testStand;

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        testStand = "https://test.uxcrowd.ru/";
    }

    public String getTestStand() {
        return testStand;
    }
    protected void screenShot(){
        File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String path = "A:\\Program Files\\Projects\\MavenSeleniumTestngAllure\\Screenshots\\" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void check(String nameStep, boolean check, String message) {
        step(nameStep, () -> {
            Assert.assertTrue(check, message);
        });
        screenShot();
    }
}
