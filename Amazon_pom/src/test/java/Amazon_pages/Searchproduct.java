package Amazon_pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Searchproduct {
    WebDriver driver;

    By Productid=By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]");
    String expectedtitle="Amazon.in : boat headphones";
    public String productname;

    public Searchproduct(WebDriver driver) {
        this.driver = driver;
    }
    public  void verifytitle(){
        assertEquals(driver.getTitle(),expectedtitle);
    }
    public void selectprodust(){
        productname= driver.findElement(Productid).getText();
        driver.findElement(Productid).click();
    }

}
