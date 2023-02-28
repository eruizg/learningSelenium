package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FlipkartProject {

    ChromeDriver driver;
    String url = "https://www.flipkart.com/";

    @BeforeClass
    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(10));

        driver.get(url);


    }

    @Test
    public void mouseHover(){

        Actions action = new Actions(driver);

        WebElement electronicslink = driver.findElement(By.xpath("//div[text()='Electronics']"));

        action.moveToElement(electronicslink).build().perform();

        WebElement samsung = driver.findElement(By.xpath("//a[text()='Gaming']"));

        samsung.click();
    }

    @AfterClass
    public void closeBrowser() {

        driver.close();
    }

}
