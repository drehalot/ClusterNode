package www.autohero.com.de.pageobjects;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import www.autohero.com.de.additional.Utils;

public class ResultObject {
    private WebDriver driver;

    private Utils utils;
    private String URL;

    public ResultObject(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        this.URL = URL;
    }

    public ResultObject validateOFSearch() {
        return this;
    }

    @NotNull
    public ResultObject setFilter(String value) {
        //Click on field
        utils.waitForPageLoad();
        WebElement element = driver.findElement(MainObjectLocators.SELECT_SORTIERT_NACH);
        element.click();

        // Find menu item and click
        driver.findElement(By.xpath("//*[text()='" + value + "']")).click();
        return this;
    }
}
