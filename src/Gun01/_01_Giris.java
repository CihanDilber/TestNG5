package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

    //    public static void main(String[] args) {
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

//    @Test JUnit
//    public void Test1(){
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

    // eger herhangi bir siralama verilmezse method isimlerinin alfabetik sirasina gore calisiyor

    @Test(priority = 1)    // bu sekilde siralama verebiliyoruz
    public void webSitesiniAc()
    {
        System.out.println("driver tanimlandi ve web sitesi acildi");
    }

    @Test(priority = 2)
    public void loginIsleminiYap()
    {
        System.out.println("login test islemi yapildi");
    }

    @Test(priority = 3)
    public void driveriKapat()
    {
        System.out.println("driver kapatildi");
    }



}
