package Gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _02_Ornek extends BaseDriver {

    @Test
    void loginTest()
    {
        System.out.println("login test");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement email= driver.findElement(By.id("input-email"));
        email.sendKeys("c.kabak@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("Cd08022018");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "My Account");  // url den de olur

    }
}
