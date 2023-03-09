package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {

    public static void Bekle(int sn)
    {
        try {
            Thread.sleep(1000*sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  static void successMessageValidation()
    {
        WebElement confirmation= BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(confirmation.getText().toLowerCase().contains("success"));
    }
}
