package amazon;

import javafx.scene.media.MediaPlayer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CheckProductByUrl {
    private FirefoxDriver driver;


    private int time = 60;

    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "lib\\logs.txt");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void testCheckProduct() throws InterruptedException, MalformedURLException, URISyntaxException {
        driver.get("http://www.amazon.co.uk/gp/product/B07GZCL9KP");
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        int counter = 0;
        for (; ; ) {
            counter++;
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
            WebElement statusOfProduct = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[6]/div[6]/div[13]/div[1]"));

            if (statusOfProduct.getText().contains("Currently unavailable.\nWe don't know when or if this item will be back in stock.")) {
                if (counter % 20 == 0) {
                    System.out.println(".");
                }
            } else {
                driver.manage().window().fullscreen();
                ((JavascriptExecutor) driver).executeScript("window.open()");

                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get("https://www.youtube.com/watch?v=ETxmCCsMoD0");
                driver.switchTo().window(tabs.get(0));

                System.out.println(new Date() + " Time to buy");
                System.out.println(new Date() + " Time to buy");
                System.out.println(new Date() + " Time to buy");
                System.out.println(new Date() + " Time to buy");
                System.out.println(new Date() + " Time to buy");

                driver.findElement(By.xpath("//*[@id=\"buy-now-button\"]")).click();
                wait.until((ExpectedCondition<Boolean>) wd ->
                        (wd.getTitle().equals("Amazon Sign In")));
                driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("Tarasdregalo@gmail.com");
                driver.findElement(By.id("ap_password")).sendKeys("amazonfiotVT18");
                driver.findElement(By.id("signInSubmit")).click();
                wait.until((ExpectedCondition<Boolean>) wd ->
                        (wd.getTitle().contains("Select a Payment Method -")));

                driver.findElement(By.id("continue-top")).click();

                wait.until((ExpectedCondition<Boolean>) wd ->
                        (wd.getTitle().contains("Place Your Order")));

                List<WebElement> buttonBuy = driver.findElements(By.xpath("/html/body/div[5]/div/div[2]/form/div/div/div/div[2]/div/div[1]/div/div[1]/div/span/span/input"));

                if (buttonBuy.size() > 0) {
                    buttonBuy.get(0).click();
                    System.out.println("Done");

                }
            }
            Thread.sleep(10000);
            driver.get("http://www.amazon.co.uk/gp/product/B07GZCL9KP");
        }

    }


    void playSound(String soundFile) {
        File file = new File(".\\" + soundFile);
        if (file.exists()) {
            Media hit = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
    }
}
