package Gun02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Tools;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable{

    @Test
    void Test1()     // public burada zorunlu degil
    {
        System.out.println("test 1");
    }

    @Test(enabled = false)  // su an bunu devre disi biraktik
    void Test2()     // public burada zorunlu degil
    {
        System.out.println("test 2");
    }

    @Test
    void Test3()     // public burada zorunlu degil
    {
        System.out.println("test 3");
    }

    public static WebDriver driver;
    @BeforeClass
    void baslangicIslemleri()
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


    }

    @AfterClass
    void bitisIslemleri()
    {
        Tools.Bekle(3);
        driver.quit();
    }
}
