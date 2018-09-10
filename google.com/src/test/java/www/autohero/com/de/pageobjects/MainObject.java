package www.autohero.com.de.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;
import www.autohero.com.de.additional.AutomationLogger;
import www.autohero.com.de.additional.Utils;

import java.util.concurrent.TimeUnit;

/**
 * This class inheritance from LoadableComponent class.
 * <p>
 * This class implement PageObject pattern.
 */
public class MainObject extends LoadableComponent<MainObject> {

    private final WebDriver driver;

    private final Utils utils;
    private final String URL;

    public MainObject(WebDriver driver, String URL) {
        this.driver = driver;
        this.utils = new Utils(driver);
        this.URL = URL;
    }

    /**
     * This method need for click button ErweiterteSuche.
     *
     * @return MainObject
     */
    public MainObject setActionErweiterteSuche() {
        utils.waitForPageLoad();

        AutomationLogger.printInfo("Press button 'Ergebnisse'");
        utils.pressButtonByWithJS(MainObjectLocators.BUTTON_ERWEITERTE_SUCHE);

        return this;
    }

    /**
     * This method need for set range from 2009 till 2014.
     *
     * @return MainObject
     */
    public MainObject setRangeFrom2009Till2014() {
        utils.waitForPageLoad();

        AutomationLogger.printInfo("Set value on slider");
        WebElement firstElementOfSlider = driver.findElement(MainObjectLocators.SLIDER_FIRST_ELEMENT);
        WebElement secondElementOfSlider = driver.findElement(MainObjectLocators.SLIDER_SECOND_ELEMENT);

        AutomationLogger.printInfo("Set first value '2009' on slider");
        Actions move = new Actions(driver);
        move.moveToElement(firstElementOfSlider, (secondElementOfSlider.getLocation().x - firstElementOfSlider.getLocation().x) / 19 * 9,
                MainObjectStaticValues.ZERO).click();
        move.build().perform();

        AutomationLogger.printInfo("Set second value '2014' on slider");
        move.moveToElement(secondElementOfSlider, -(secondElementOfSlider.getLocation().x - firstElementOfSlider.getLocation().x) / 19 * 10,
                MainObjectStaticValues.ZERO).click();
        move.build().perform();
        return this;
    }

    /**
     * This method need for clicking button Ergebnisse.
     *
     * @return ResultObject
     */
    public ResultObject setActionErgebnisse() {
        utils.waitForPageLoad();

        AutomationLogger.printInfo("Press button 'Ergebnisse'");
        utils.pressButtonByWithJS(MainObjectLocators.BUTTON_ERGEBNISSE);

        return new ResultObject(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        if (driver.getCurrentUrl().equals(URL)) {
            driver.switchTo().window(driver.getWindowHandle());
            AutomationLogger.printPassed(String.format("Page %s with url was successfully loaded", driver.getCurrentUrl()));
        } else {
            AutomationLogger.printFailed("Page " + URL + " is not load");
        }

        utils.waitForPageLoad();

        // I know that use thread sleep is not very good practice, but I can not catch when page was loaded
        // that why I use Thread.sleep.
        try {
            Thread.sleep(MainObjectStaticValues.TIME_VERY_LONG);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void load() {
        driver.manage().timeouts().implicitlyWait(MainObjectStaticValues.TIME_SHORT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(MainObjectStaticValues.TIME_SHORT, TimeUnit.SECONDS);
        driver.get(URL);
    }
}
