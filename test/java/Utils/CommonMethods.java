package Utils;

import StepDefinitions.PageInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void OpenBrowser() {
        ConfigReader.ReadProperties();

        switch (ConfigReader.getProperties("BrowserType")) {

            case ("Chrome"):
                ChromeOptions cp = new ChromeOptions();
                cp.setHeadless(false);
                driver = new ChromeDriver(cp);
                break;
            case ("Firefox"):
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        initializeElements();

    }

    public static void sendText(WebElement element, String message) {
        element.clear();
        element.sendKeys(message);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait;
    }

    public static void waitforClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void doClick(WebElement element) {
        waitforClickability(element);
        element.click();
    }

    public static void closeBrowser() {
        driver.close();
    }


}
