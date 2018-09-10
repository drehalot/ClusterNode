package www.autohero.com.de.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.istack.internal.NotNull;
import www.autohero.com.de.pageobjects.MainObjectStaticValues;

public class Utils {

    private final WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method need fo clicking button using selenium.click
     * @param value By of webelement
     */
    public void pressButtonWithSelenium(By value) {
        waitForPageLoad();
        WebElement element = driver.findElement(value);
        Wait<WebDriver> wait = new WebDriverWait(driver, MainObjectStaticValues.TIME_LONG);
        wait.until(ExpectedConditions.elementToBeClickable(value));
        element.click();
    }


    /**
     * This method need fo clicking button using JavascriptExecutor
     * @param by By of webelement
     */
    @NotNull
    public void pressButtonByWithJS(final By by) {
        waitForPageLoad();
        Wait<WebDriver> wait = new WebDriverWait(driver, MainObjectStaticValues.TIME_LONG);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            List<WebElement> list = driver.findElements(by);
            return list.size() > 0;
        });
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * This method need for wait until page will be loaded.
     */
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, MainObjectStaticValues.TIME_SHORT);
        wait.until((ExpectedCondition<Boolean>) driver -> String.valueOf(((JavascriptExecutor) driver).
                executeScript("return document.readyState")).equals("complete"));
    }

    /**
     * Need for validate if webelement has text value.
     * @param xpath By of webelement
     * @param value text value.
     */
    @NotNull
    public void validateField(By xpath, String value) {
        WebElement element = driver.findElement(xpath);
        if (element.getText().equals(value)) {
            AutomationLogger.printPassed("Field has correct value " + element.getText());
        } else {
            AutomationLogger.printFailed(String.format("Field %s has value %s,but expected result is %s",
                    xpath.toString(), element.getText(), value));
        }
    }

    /**
     * Need for validate if webelement has text value.
     * @param element WebElement
     * @param value text value.
     */
    @NotNull
    public void validateField(WebElement element, String value) {
        if (element.getText().equals(value)) {
            AutomationLogger.printPassed("Field has correct value " + element.getText());
        } else {
            AutomationLogger.printFailed(String.format("Field has value %s,but expected result is %s"
                    , element.getText(), value));
        }
    }

    /**
     * This method need get number from String.
     *
     * @param value String value.
     *
     * @return  null if number was not found.
     *          String if number was found.
     */
    @NotNull
    public String getNumberFromString(String value) {
        Pattern lastIntPattern = Pattern.compile("(-?[0-9]+(?:[,.][0-9]+)?)");
        Matcher matcher = lastIntPattern.matcher(value);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * This method need for checking if price sorted or not.
     * @param listWithPriceOfCar list with prices.
     */
    @NotNull
    public void checkIfListWithPriceSorted(final ArrayList<Double> listWithPriceOfCar) {
        AutomationLogger.printInfo("Checking list with price sorted correct...");
        if (listWithPriceOfCar.size() > 0) {
            for (int i = 0; i < listWithPriceOfCar.size() - 1; i++) {
                if (listWithPriceOfCar.get(i) < listWithPriceOfCar.get(i)) {
                    AutomationLogger.printFailed(String.format("List are not sorted \n%s", listWithPriceOfCar));
                }
            }
            AutomationLogger.printPassed(String.format("List are sorted \n%s", listWithPriceOfCar));
            return;
        }
        AutomationLogger.printInfo("List are empty or null");
    }
}
