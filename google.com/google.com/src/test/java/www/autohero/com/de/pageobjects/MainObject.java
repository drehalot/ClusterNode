package www.autohero.com.de.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import www.autohero.com.de.additional.Utils;

import java.util.concurrent.TimeUnit;

/**
 * This class inheritance from LoadableComponent class.
 * <p>
 * This class implement PageObject pattern.
 */
public class MainObject extends LoadableComponent<MainObject> {

    private WebDriver driver;

    private Utils utils;
    private String URL;

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
        utils.pressButtonBy(MainObjectLocators.BUTTON_ERWEITERTE_SUCHE);

        return this;
    }

    /**
     * This method need for set range from 2009 till 2014.
     *
     * @return MainObject
     */
    public MainObject setRangeFrom2009Till2014() {

        utils.waitForPageLoad();

        WebElement firstElementOfSlider = driver.findElement(MainObjectLocators.SLIDER_FIRST_ELEMENT);
        WebElement secondElementOfSlider = driver.findElement(MainObjectLocators.SLIDER_SECOND_ELEMENT);

        Actions move = new Actions(driver);
        move.moveToElement(firstElementOfSlider, (secondElementOfSlider.getLocation().x - firstElementOfSlider.getLocation().x) / 19 * 9,
                0).click();  // move to a specific point on the dragpoint
        move.build().perform();

        move.moveToElement(secondElementOfSlider, -(secondElementOfSlider.getLocation().x - firstElementOfSlider.getLocation().x) / 19 * 8,
                0).click();  // move to a specific point on the dragpoint
        move.build().perform();
        return this;
    }

    public ResultObject setActionErgebnisse() {
        utils.waitForPageLoad();
        utils.pressButtonBy(MainObjectLocators.BUTTON_ERGEBNISSE);
        return new ResultObject(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        if (driver.getCurrentUrl().contains(URL)) {
            driver.switchTo().window(driver.getWindowHandle());
        } else {
            Assert.fail("Page " + URL + " is not load");
        }
    }

    @Override
    protected void load() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(URL);
        utils.waitForPageLoad();
    }
}
