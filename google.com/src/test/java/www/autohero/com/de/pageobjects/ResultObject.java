package www.autohero.com.de.pageobjects;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import www.autohero.com.de.additional.AutomationLogger;
import www.autohero.com.de.additional.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class need for checking search result.
 * <p>
 * This class implement PageObject pattern.
 */
public class ResultObject {

    private final Utils utils;
    private final WebDriver driver;

    public ResultObject(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    /**
     * This method need for checking filter
     *
     * @param erstzulassungVon value from what year.
     * @param erstzulassungBis value till what year.
     * @return ResultObject
     */
    public ResultObject validateOFSearch(String erstzulassungVon, String erstzulassungBis) {
        utils.waitForPageLoad();

        AutomationLogger.printInfo("Validate filters");
        WebElement filterElement = driver.findElement(MainObjectLocators.FILTER_ELEMENT);
        List<WebElement> list = filterElement.findElements(MainObjectLocators.EACH_FILTER_OF_ELEMENT);

        AutomationLogger.printInfo("Validate filter 'erstzulassungVon'");
        utils.validateField(list.get(0), "Erstzulassung von: " + erstzulassungVon);

        AutomationLogger.printInfo("Validate filter 'erstzulassungBis'");
        utils.validateField(list.get(1), "Erstzulassung bis: " + erstzulassungBis);

        return this;
    }

    /**
     * This method need for set filter.
     * @param value name of field from select element.
     * @return ResultObject
     */
    @NotNull
    public ResultObject setFilter(String value) {
        //Click on field
        utils.waitForPageLoad();
        AutomationLogger.printInfo("Set filter 'Sortiert nach'");
        utils.pressButtonWithSelenium(MainObjectLocators.SELECT_SORTIERT_NACH);

        // Find menu item and click
        AutomationLogger.printInfo(String.format("Set value %s 'Sortiert nach' select", value));
        utils.pressButtonWithSelenium(By.xpath("//*[text()='" + value + "']"));

        AutomationLogger.printInfo("Checking value for select 'Sortiert nach'");
        utils.validateField(MainObjectLocators.SELECT_SORTIERT_NACH, value);
        return this;
    }

    /**
     * This method need for checking all items from search.
     *
     * Validate year of car.
     *
     * Validate if car sorted by price.
     *
     * @param first first year.
     * @param last last year.
     * @return ResultObject
     */
    public ResultObject validateResultOfSearch(int first, int last) {
        WebElement listWithResult = driver.findElement(MainObjectLocators.RESULT_TABLE);
        List<WebElement> listWithItem = listWithResult.findElements(MainObjectLocators.ITEM_FROM_RESULT_TABLE);
        ArrayList<Double> listWithPriceOfCar = new ArrayList<>();

        for (int i = 0; i < listWithItem.size(); i++) {
            WebElement element = listWithItem.get(i);
            String yearOfCar = element.findElement(MainObjectLocators.FIELD_WITH_YEAR).getText();
            String nameOfCar = element.findElement(MainObjectLocators.FIELD_WITH_NAME).getText();
            String priceOfCar = element.findElement(MainObjectLocators.FIELD_WITH_PRICE).getText();

            AutomationLogger.printInfo(i + ". " + nameOfCar + " " + utils.getNumberFromString(yearOfCar)
                    + "  " + utils.getNumberFromString(priceOfCar));
            AutomationLogger.printInfo("Checking year...");

            if (((Integer.valueOf(utils.getNumberFromString(yearOfCar)) >= first) &&
                    (Integer.valueOf(utils.getNumberFromString(yearOfCar)) <= last))) {
                AutomationLogger.printPassed(String.format("Car has year between %s and %s \n", first, last));
            } else {
                AutomationLogger.printFailed(String.format("Car %s from %s \n", nameOfCar, yearOfCar));
            }

            listWithPriceOfCar.add(Double.valueOf(utils.getNumberFromString(priceOfCar)));
        }

        utils.checkIfListWithPriceSorted(listWithPriceOfCar);
        return this;
    }
}
