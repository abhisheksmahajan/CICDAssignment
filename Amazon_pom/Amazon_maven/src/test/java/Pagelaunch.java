import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagelaunch {
    WebDriver driver;

    @BeforeMethod
    void load(){
    System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
    driver = new ChromeDriver();
    driver.get("https://www.amazon.in/");
    }
    @Test
    void isLaunch(){
        String ExpectedTitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String ActualTitle= driver.getTitle();
        System.out.println(ActualTitle);
        try {
        Assert.assertEquals(ActualTitle,ExpectedTitle);}
        catch(Exception e){
            System.out.println(e);
        }
    }
    @AfterMethod
    void Close() {
        driver.quit();
    }
}

