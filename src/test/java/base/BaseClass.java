package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Scanner;

public class BaseClass {

    protected static WebDriver driver;
    protected static WebDriverWait wdWait;
    protected static JavascriptExecutor js;

    // protected int i=0;


    @Before

    public void initialSetup () {

        WebDriverManager.chromedriver().setup();                           // Initial setup for chromedriver
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://google.com");

      //  factoryDriver(i);
    }
    /*

    private void factoryDriver (int i) {         /// Tried with factory patter to build drivers for different browsers
        switch (i) {
            case 0: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                js = (JavascriptExecutor) driver;
                wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://google.com");
            } break;
            case 1: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                js = (JavascriptExecutor) driver;
                wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://google.com");
            } break;
            case 2: {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                js = (JavascriptExecutor) driver;
                wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://google.com");
            } break;

        }
    }   */

    protected void clickOnElement (WebElement w) {    // general method for clicking on element
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
        w.click();
    }

    protected void fillTextElement (WebElement w, String text) { // general method for filling text field
        wdWait.until(ExpectedConditions.visibilityOf(w));
        w.clear();
        w.sendKeys(text);
    }

    protected boolean isElementDisplayed (WebElement w) {   // general method for checking visibility of element
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.isDisplayed();
    }

    protected String getTextFromElement (WebElement w) {   // general method for getting text from element
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.getText();
    }

    protected void dragAndDrop (WebElement source, WebElement destination) {  // general method for drag and drop
        Actions actions = new Actions(driver);
        wdWait.until(ExpectedConditions.visibilityOf(source));
        wdWait.until(ExpectedConditions.visibilityOf(destination));
        actions.dragAndDrop(source,destination).perform();
    }
    protected void hoverOverElement (WebElement w) {  // general method for hover over element
        Actions actions = new Actions(driver);
        wdWait.until(ExpectedConditions.visibilityOf(w));
        actions.moveToElement(w).click().perform();
    }


    @After
    public void tearDown() {   // To shutdown browsers after tests finished
        driver.quit();
        driver.close();
    }



}
