package Gun05;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;

import java.util.List;

/*
 * Bir önceki task (data providerli)da yapılan testi PARAMETERDRIVER ile yapınız
 * sonrasında farklı tarayıcılar ile çalıştırınız. (crossbrowser)
 * sonrasında paralel çalıştırınız.(parallel)
 */

public class _05_Task_2 extends BaseDriverParameter {    // parametre base driver a lazim

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
