package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    protected WebDriver driver;
    WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickById(String elementId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId))).click();
    }

    public void clickByClassName(String elementId) {
        WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(By.className(elementId)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
    }

    public void clickByCSSSelector(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(text))).click();
    }

    public void sendKeyByClassName(String elementClassName, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.className(elementClassName))).sendKeys(value);
    }

    public void sendKeyByName(String elementName, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name(elementName))).sendKeys(value);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollUntilFindXPATH(String elementXpath) {
        WebElement Element = driver.findElement(By.xpath(elementXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public Select dropDownMenu(String elementId) {
        return
                new Select(driver.findElement(By.id(elementId)));
    }

    public String getElementTextByClassName(String element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element))).getText();
    }

    public List<WebElement> pickElementGroup(String element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getText();
        return driver.findElements(By.xpath(element));
    }
}

