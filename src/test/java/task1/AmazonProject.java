package task1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonProject {
    ChromeDriver driver;
    String url = "https://www.amazon.com/";

    @BeforeClass
    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(10));

        driver.get(url);
    }

    @Test
    public void verifyTitleOfHomePage() {

        String actualTitle = driver.getTitle();

        String expectedTitle = "Amazon.com. Spend less. Smile more.";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
