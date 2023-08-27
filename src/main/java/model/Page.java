package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
        driver.manage().window().fullscreen();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public WebElement findElement(By locator){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void findElementAndInputData(By locator, String data) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public void findAndClickElement(By locator){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void findAndClickElementWithWaitingAfter(By locator) throws InterruptedException {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        Thread.sleep(3000);
    }
}
