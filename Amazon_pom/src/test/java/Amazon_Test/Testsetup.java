package Amazon_Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Amazon_pages.*;

public class Testsetup {
    String driverPath = "/usr/bin/chromedriver";
    WebDriver driver;
    Homepage homepage;
    Searchproduct searchproduct;
    Productpage productpage;
    Cartpage cartpage;
    Loginpage loginpage;
    ChromeOptions options;


    @BeforeTest
    public void setup() {
      //  System.setProperty("webdriver.chrome.driver", driverPath);
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }
    @Test(priority = 0)
    void islaunch(){
        homepage= new Homepage(driver);
        homepage.verifytitle();

    }
    @Test(priority = 1)
    void searchheadphone(){
        homepage.addsearch("Boat Headphones");
        homepage.clicksearch();
        searchproduct= new Searchproduct(driver);
        searchproduct.selectprodust();
        productpage= new Productpage(driver);
        for(String window: driver.getWindowHandles()){
            driver.switchTo().window(window);
        }
        productpage.verifytile(searchproduct.productname);
    }

    @Test(priority = 2)
    void validcolor(){
        productpage.selectcolor();
        productpage.issetcolor();
    }
//    @Test(priority = 3)
//    void addedcart(){
//        productpage.addtocart();
//        productpage.cart();
//        cartpage= new Cartpage(driver);
//        cartpage.verifytitle();
//    }
//    @Test(priority = 4)
//    void proceedtopay(){
//        cartpage.proceedtobuy();
//        loginpage = new Loginpage(driver);
//        loginpage.verifytitle();
//    }
@AfterTest
    void close(){
        driver.quit();
}

}