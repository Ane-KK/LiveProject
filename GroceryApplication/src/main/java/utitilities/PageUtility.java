package utitilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility 
{
	
	// Select dropdown by index
    public void selectDropdownByIndex(WebElement element, int index)
    {
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    // Select dropdown by visible text
    public void selectDropdownByVisibleText(WebElement element, String text)
    {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    // Select dropdown by value
    public void selectDropdownByValue(WebElement element, String value)
    {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    // Click element using JavaScript
    public void clickElementUsingJS(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Scroll to element
    public void scrollToElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Enter text using JavaScript
    public void enterTextUsingJS(WebDriver driver, WebElement element, String value)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    // Wait until element is visible
    public void waitForElementToBeVisible(WebDriver driver, WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until element is clickable
    public void waitForElementToBeClickable(WebDriver driver, WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Accept alert
    public void acceptAlert(WebDriver driver)
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Dismiss alert
    public void dismissAlert(WebDriver driver)
    {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Get alert text
    public String getAlertText(WebDriver driver)
    {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Send text to textbox
    public void enterText(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }

    // Click element
    public void clickOnElement(WebElement element)
    {
        element.click();
    }

    // Get element text
    public String getElementText(WebElement element)
    {
        return element.getText();
    }

    // Check element is displayed
    public boolean isElementDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }

    // Check element is enabled
    public boolean isElementEnabled(WebElement element)
    {
        return element.isEnabled();
    }
}
