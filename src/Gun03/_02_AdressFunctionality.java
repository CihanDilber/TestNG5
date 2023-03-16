package Gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

public class _02_AdressFunctionality extends BaseDriver {



    @Test
    void addAddress(){
        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAdress= driver.findElement(By.linkText("New Address"));
        newAdress.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Cihan");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Kabak");

        WebElement company= driver.findElement(By.id("input-company"));
        company.sendKeys("BSB");

        WebElement address1= driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Baslerstrasse 10");

        WebElement address2= driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Riehen");

        WebElement city= driver.findElement(By.id("input-city"));
        city.sendKeys("Basel");

        WebElement postCode= driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("4103");

        // ülke seçimi tamam
        WebElement webCountry= driver.findElement(By.id("input-country"));
        Select country=new Select(webCountry);
        country.selectByVisibleText("Turkey");

        //2.Seçenek
       wait.until(ExpectedConditions.elementToBeClickable(webCountry));


        // 1.Seçenek
//        WebElement options=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
//        wait.until(ExpectedConditions.stalenessOf(options));

        WebElement webState= driver.findElement(By.id("input-zone"));
        Select state=new Select(webState);
        //state.selectByVisibleText("Ankara");
        //state.selectByValue("3321");
        state.selectByIndex(7);
        // stale element hatası : tez buldum erken kaybettim

        //selectByVisibleText, selectByValue : findElement gibi çalıştığından
        //                                     implictly wait i kullanır.
        // selectByIndex : implicitlyWait ie çalışMIYOR. ancak ExplicitWait ile çalışır


        WebElement defaddress = driver.findElement(By.xpath("//input[@value='1']"));
        defaddress.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }


    @Test(dependsOnMethods = {"addAddress"})
    void editAddress(){
        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Edit"));
        WebElement sonEdit= editAll.get( editAll.size()-1 ); // son edit
        sonEdit.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Cihan1");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Kabak1");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        //Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){

        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Delete"));
        WebElement silinebilirAdres= editAll.get( editAll.size()-2 ); // silinebilir 2.cisi
        silinebilirAdres.click();

        Tools.successMessageValidation();
    }

}
