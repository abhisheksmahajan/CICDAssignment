package Amazon_pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Loginpage {
    WebDriver driver;
    String expectedtitle="Amazon Sign In";
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifytitle(){
     try {
         Thread.sleep(2000);
     }catch(Exception e) {
     }

        assertEquals(driver.getTitle(),expectedtitle);
    }
}
