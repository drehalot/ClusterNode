package www.autohero.com.de;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import www.autohero.com.de.additional.GeckoDriver;
import www.autohero.com.de.pageobjects.MainObject;

public class main {

    public WebDriver driver = null;
    public static final String URL = "https://www.autohero.com/de/search/";


    @BeforeTest
    public void init() {
        System.setProperty("webdriver.gecko.driver", GeckoDriver.getPathToGeckoService());
        driver = new FirefoxDriver();
    }

    @Test
    public void testOne() {

        MainObject mainObject = new MainObject(driver, URL);
        mainObject.get();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainObject.setActionErweiterteSuche().setRangeFrom2009Till2014();
        mainObject.setActionErgebnisse().setFilter("Höchster Preis");
//
//        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[1]/div"));
//        //*[@id="app"]/div/main/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[1]/div
//        System.out.println("First" + element1.getLocation().x + "__" + element1.getLocation().y);
//        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/m" +
//                "ain/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[2]/div"));
//        System.out.println("Другой" + element2.getLocation().x + "__" + element2.getLocation().y);
//        //*[@id="app"]/div/main/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/span[2]/div
//
//        Actions move = new Actions(driver);
//        move.moveToElement(element1, (element2.getLocation().x-element1.getLocation().x)/19*9, 0).click();  // move to a specific point on the dragpoint
//        move.build().perform();
//
//        move.moveToElement(element2, -(element2.getLocation().x-element1.getLocation().x)/19*8, 0).click();  // move to a specific point on the dragpoint
//        move.build().perform();
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    @AfterTest
    public void closeConnection() {
        //      driver.close();
    }

}
