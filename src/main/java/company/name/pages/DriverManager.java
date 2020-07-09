package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver != null) {
            return driver;
        }
        String driverPath = "A:\\bin\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test.uxcrowd.ru/app-new-tester-home/welcome");
        return driver;
    }
    public static void quit(){
        driver.quit();
    }
}
