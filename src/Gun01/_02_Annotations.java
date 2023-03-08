package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */

    @BeforeClass   //
    public void beforeClass()
    {
        System.out.println("Before  class calisti");
    }

    @AfterClass   //
    public void afterClass()
    {
        System.out.println("after  class calisti");
    }


    @BeforeMethod   // her metoddan once calisir
    public void beforeMethod()
    {
        System.out.println("before method calisti");
    }

    @AfterMethod   // her metoddan sonra calisir
    public void AfterMethod()
    {
        System.out.println("AfterMethod calisti");
    }

    @Test
    public void Test1()
    {
        System.out.println("Test 1 calisti");

    }

    @Test
    public void Test2()
    {
        System.out.println("Test 2 calisti");

    }
}
