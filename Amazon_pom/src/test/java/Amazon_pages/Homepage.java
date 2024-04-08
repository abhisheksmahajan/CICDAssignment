package Amazon_pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Homepage {
    WebDriver driver;
    By Searchbar=By.id("twotabsearchtextbox");
    By Searchbtn=By.xpath("//input[@id='nav-search-submit-button']");
    String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    public void addsearch(String product){
        driver.findElement(Searchbar).sendKeys(product);

    }
    public  void  clicksearch(){
        driver.findElement(Searchbtn).click();
    }
    public  void  verifytitle(){
        assertEquals(driver.getTitle(),expectedtitle);
    }
}
