package Gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.util.List;

public class _04_Task extends BaseDriver {
    /*
     * Daha önceki derslerde yaptğımız Search fonksiyonunu
     * mac,ipod ve samsung için Dataprovider ile yapınız.
     * BaseDriver ile yapalim
     */

    @Test(dataProvider = "getData")
    void searchFunctionality(String text)
    {

        WebElement searchBox= driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.clear();      // tekrar yazmadan once search u temizliyoruz
        searchBox.sendKeys(text);

        WebElement searchButton= driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        searchButton.click();

        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for(WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(text.toLowerCase()));

    }

    @DataProvider
    Object[] getData()
    {
        Object[] data={"mac","ipod","samsung"};
        return data;
    }

}
