package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

import static java.time.Duration.ofSeconds;

public class helpers {
    WebDriver driver;
    HashMap<String, String> loginElements = new HashMap<String, String>();
    HashMap<String, String> navbarElements = new HashMap<String, String>();
    String headerText;
    String footerLinkText;
    String footerCopyrightText;
    public void waitUntilElementIsVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean checkElementDisplay(By element) {
        if(driver.findElement(element).isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }
    public void goToLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/chromeWebdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://hotel.testplanisphere.dev/ja/login.html");
        driver.manage().window().maximize();
    }

    public void enterTextToInputField(By inputField, String textToSend) {
        waitUntilElementIsVisible(inputField);
        driver.findElement(inputField).sendKeys(textToSend);
    }

    public String getElementText(By inputField) {
        return driver.findElement(inputField).getAttribute("innerHTML");
    }

    public void clickElement(By elementToClick) {
        waitUntilElementIsVisible(elementToClick);
        driver.findElement(elementToClick).click();
    }
}
