package Gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.BaseDriverParameter;

import java.util.List;

/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

public class _01_SearchFunctionality extends BaseDriverParameter {

    @Test
    @Parameters("aranacakKelime")
    void searchFunctionality(String text)
    {

        WebElement searchBox= driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.sendKeys(text);

        WebElement searchButton= driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        searchButton.click();

        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for(WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(text.toLowerCase()));

    }
}
