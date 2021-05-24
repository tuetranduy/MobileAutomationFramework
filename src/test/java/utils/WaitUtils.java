package utils;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitUtils {
    public final int explicitWaitDefault = PropertyUtils.getIntProperty("explicitWait", 10);

    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForButtonClickable(final WebElement element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeInvisible(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfElementLocated((locator)));
    }

    public void waitForElementPresent(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeVisibleBy(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(final WebElement element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible(final IOSElement element, final WebDriver driver, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeInvisible(final List<WebElement> elements, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitForElementToBeNotPresent(final By element, WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }

    public void waitUntilNestedElementPresent(WebElement element, By locator, WebDriver driver) {
        new WebDriverWait(driver, explicitWaitDefault)
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }
}
