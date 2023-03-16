package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemleri()
    {


        Logger logger= Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        loginTest();


    }


    void loginTest()
    {

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement email= driver.findElement(By.id("input-email"));
        email.sendKeys("c.kabak@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("Cd08022018");

        WebElement loginButton= driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "My Account");  // url den de olur

    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(3);
        driver.quit();
    }
}
