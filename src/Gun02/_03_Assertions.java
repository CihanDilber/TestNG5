package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void equalsOrnek()
    {
        String s1="Merhaba";
        String s2="Merhaba";

        // Actual (olusan), Expected(beklenen), Mesaj(opsiyonel)    // a e m harf sirasina gore akilda kalabilir
        Assert.assertEquals(s1,s2, "actual ile expected esit degil");
    }

    @Test
    void notEqualsOrnek()
    {
        String s1="Merhaba";
        String s2="Merhaba1";

        Assert.assertNotEquals(s1,s2, "actual ile expected esit ");  // biz zaten esit olmadigini bekliyoruz
                                                                     // mesaj s1 s2 ye esitse cikar
    }

    @Test
    void trueOrnek()
    {
        int s1=55;
        int s2=66;

        Assert.assertTrue(s1==s2, "actual ile expected esit degil");  // mesaja hata oldugunda olani yaziyoruz
                                                                      // else gibi dusun

    }

    @Test
    void nullOrnek()
    {
        String s1=null;


        Assert.assertNull(s1, "Actual null olmadi");  // mesaja hata oldugunda olani yaziyoruz

    }

    @Test
    void direkFail()
    {
        int a=55;

        if(a==55)
            Assert.fail();  // Assert.fail("hata olustu")  // mesajda yazilabilir buna

    }




}
