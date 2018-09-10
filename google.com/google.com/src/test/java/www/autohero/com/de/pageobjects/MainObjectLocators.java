package www.autohero.com.de.pageobjects;

import org.openqa.selenium.By;

public class MainObjectLocators {
    public static final By BUTTON_ERWEITERTE_SUCHE = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[1]/div/div[1]/button");
    public static final By SLIDER_FIRST_ELEMENT = By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/" +
            "div[1]/div/span[1]/div");
    public static final By SLIDER_SECOND_ELEMENT = By.xpath("//*[@id=\"app\"]/div/m" +
            "ain/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[2]/div");
    public static final By SELECT_SORTIERT_NACH =By.xpath("//*[@id=\"react-select-10--value\"]/div[1]/span");

    public static By BUTTON_ERGEBNISSE=By.xpath("//*[@id=\"app\"]/div/main/div[5]/div/div/div/div/div/div/a");
}
