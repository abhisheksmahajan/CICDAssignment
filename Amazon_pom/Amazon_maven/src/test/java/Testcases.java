import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Testcases {

    public Testcases() {

    }

    void load(){
        System.out.println("Hii");
    }

    @Test(priority = 1)
    void test(){
        System.out.println("hello");
    }

    @Test(priority = 2)
    void close(){
        System.out.println("byy");
    }
}
