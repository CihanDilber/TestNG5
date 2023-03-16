package Gun04;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _04_ContactUs extends BaseDriver {

    @Test
    @Parameters("mesaj") // xml de ki parametre adi ayni olmak zorunda
    void contactUs(String gelenMesaj)
    // String gelenMesaj: metod icin gerekli tanimlama ayni olmak zorunda degil
    {
        WebElement contactUs= driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement message= driver.findElement(By.id("input-enquiry"));
        message.sendKeys(gelenMesaj);

        WebElement submitButton= driver.findElement(By.cssSelector("[type='submit'"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));

    }


}
