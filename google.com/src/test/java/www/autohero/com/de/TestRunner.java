package www.autohero.com.de;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import www.autohero.com.de.additional.AutomationLogger;
import www.autohero.com.de.additional.GeckoDriver;
import www.autohero.com.de.pageobjects.MainObject;

/**
 * This class need for run test.
 */
public class TestRunner {

    private WebDriver driver = null;

    private static final String URL = "https://www.autohero.com/de/search/";

    @BeforeTest
    public void init() {
        String pathToGecko = GeckoDriver.getPathToGeckoService();
        if (pathToGecko != null) {
            System.setProperty("webdriver.gecko.driver", pathToGecko);

            driver = new FirefoxDriver();
        } else {
            AutomationLogger.printFailed("Test can not be execute, because missed gecko service file");
        }

    }

    @Test
    public void test() {
        MainObject mainObject = new MainObject(driver, URL);
        mainObject.get().setActionErweiterteSuche().setRangeFrom2009Till2014().setActionErgebnisse().setFilter("Höchster Preis")
                .validateOFSearch("2009",
                        "2014").validateResultOfSearch(2009, 2014);
    }

    public static int getAddActions(int value1, int value2) {
        return value1 + value2;
    }


    @AfterTest
    public void closeConnection() {
        driver.close();
    }

}
