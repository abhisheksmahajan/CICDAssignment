package Amazon_pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Cartpage {
    WebDriver driver;
    By Proceed_to_buy= By.cssSelector("input[name=\"proceedToRetailCheckout\"]");
    String expected="Amazon.in Shopping Cart";

    public Cartpage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifytitle(){
        assertEquals(driver.getTitle(),expected);
    }
    public void proceedtobuy(){
        driver.findElement(Proceed_to_buy).click();
    }

}
