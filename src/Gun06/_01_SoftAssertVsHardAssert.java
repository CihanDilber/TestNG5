package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert()
    {

         String s1="Merhaba";
        System.out.println("hart assert oncesi");
        Assert.assertEquals("Merhaba123",s1,"Olusan ile beklenen esit degil"); // test kiriliyor
        System.out.println("Hart assert sonrasi");

    }

    @Test
    void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();  // best practice olarak isimin onune _ konuluyor
        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage);  //true
        System.out.println("soft assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage);  // false
        System.out.println("soft assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount);  // false
        System.out.println("soft assert 3");

        _softAssert.assertAll();  //butun assert sonuclarini isleme koyuyor, burdan sonrasi calismiyor
        System.out.println("soft assertAll : aktiflik sonrasi");
        // bu bolum assertAll dan sonra oldugu ve oncesinde hata olustugu icin ekrana cikmayacak
    }


}
