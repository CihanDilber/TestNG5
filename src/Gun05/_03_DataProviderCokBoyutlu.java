package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProviderCokBoyutlu {

    @Test(dataProvider = "UserData")
    void UsernameTest(String username, String password)
    {

        System.out.println("user = "+ username+" "+password);
    }

    @DataProvider
    public Object[][] UserData(){  // return data object olmak zorunda

        Object[][] data={
                {"Nurhayat","122333"},    // yanina ekleyerek 3 veya 4 de eklenebilir
                {"Alper","ererer"},
                {"Ugur","ererer3343"},
                {"Hakan","sdsdsd"}

        };

        return data;
    }
}
