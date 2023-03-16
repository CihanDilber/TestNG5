package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    // arabanin hareketi : start, drive, park, stop  hareket sirasi
    // priority vermezsek alfabetik calisir
    // priority verirsek o siraya gore calisir
    // ancak kosula gore dersek o calistiginda digeri calissin anlaminda

    @Test
    void startCar(){
        System.out.println("startcar");
        //Assert.fail();   // hata verdirmek icin
    }
    @Test(dependsOnMethods = {"startcar"})  // bu testin calismasi startCar in hatasiz calismasina bagimli
    void driveCar(){
        System.out.println("drivecar");
    }
    @Test(dependsOnMethods = {"startCar","driveCar"})   // birden fazla method basarili olsun da denilebilir
    void parkCar(){
        System.out.println("parkcar");
    }
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)   // bagimliliklari var ama bir problem olsa da calis diyoruz burada
    void stopCar(){
        System.out.println("stopcar");
    }

    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.
}
