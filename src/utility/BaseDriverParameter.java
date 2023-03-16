package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public WebDriver driver;    // statici sildik ki paralel test icin bi taneligi bitti yani
                                // her class in kendi driver i olsun
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi) {


        Logger logger = Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        switch(browserTipi.toLowerCase())
        {
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "edge":
                driver=new EdgeDriver();
                break;

            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }

//        if (browserTipi.equalsIgnoreCase("firefox")) {
//            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
//            driver = new FirefoxDriver();
//            System.out.println("firefox started");
//        } else if (browserTipi.equalsIgnoreCase("safari")) {
//            driver = new SafariDriver();
//
//        } else {
//            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
//        }


        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginTest();

    }
        void loginTest ()
        {

            driver.get("https://opencart.abstracta.us/index.php?route=account/login");

            WebElement email = driver.findElement(By.id("input-email"));
            email.sendKeys("c.kabak@gmail.com");

            WebElement password = driver.findElement(By.id("input-password"));
            password.sendKeys("Cd08022018");

            WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
            loginButton.click();

            Assert.assertEquals(driver.getTitle(), "My Account");  // url den de olur

        }

        @AfterClass
        public void bitisIslemleri ()
        {
            Tools.Bekle(3);
            driver.quit();
        }
    }
