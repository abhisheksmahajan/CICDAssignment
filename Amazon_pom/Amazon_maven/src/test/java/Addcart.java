import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addcart {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    void load(){
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    void addcart(){

    }
}
