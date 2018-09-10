package www.autohero.com.de.additional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.istack.internal.NotNull;

public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    @NotNull
    public void inputTextInJSField(By by, String value) {
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        element.clear();
        element.sendKeys(value);
    }

    @NotNull
    public boolean isTitle(String title) {
        waitForPageLoad();
        return driver.getTitle().equals(title);
    }

    public void pressButtonBy(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                List<WebElement> list = driver.findElements(by);
                return list.size() > 0;
            }

        });
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

}
