package www.autohero.com.de.pageobjects;

import org.openqa.selenium.By;

/**
 * This class need for store locators.
 */
class MainObjectLocators {

    public static final By BUTTON_ERWEITERTE_SUCHE = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[1]/div/div[1]/button");

    public static final By SLIDER_FIRST_ELEMENT = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/" +
            "div[1]/div/span[1]/div");

    public static final By SLIDER_SECOND_ELEMENT = By.xpath("//*[@id=\"app\"]/div/m" +
            "ain/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[2]/div");

    public static final By SELECT_SORTIERT_NACH = By.xpath("//*[@id=\"react-select-10--value\"]/div[1]/span");

    public static final By FILTER_ELEMENT = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[2]/div/div[1]/ul");

    public static final By EACH_FILTER_OF_ELEMENT = By.xpath("li/button");

    public static final By BUTTON_ERGEBNISSE = By.xpath("//*[@id=\"app\"]/div/main/div[5]/div/div/div/div/div/div/a");

    public static final By RESULT_TABLE = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[2]/div/div[3]/div[2]");

    public static final By ITEM_FROM_RESULT_TABLE = By.xpath("div/div/div/a");

    public static final By FIELD_WITH_YEAR = By.xpath("ul/li[1]");

    public static final By FIELD_WITH_NAME = By.xpath("div[1]/div/div[1]");

    public static final By FIELD_WITH_PRICE = By.xpath("div[3]/div[1]");
}
