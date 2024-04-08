package Amazon_pages;
import static org.testng.Assert.*;

import dev.failsafe.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Productpage {
    WebDriver driver;
    By Producttext= By.cssSelector("span#productTitle");
    By Coloratt = By.cssSelector("li#color_name_0>span>div.tooltip>span>span>span>button");
    By Add_to_cart= By.cssSelector("input[title='Add to Shopping Cart']");
    By Cart= By.cssSelector("form#attach-view-cart-button-form>span>span>input");
    String expectedtitle= "boAt Airdopes Atom 81 TWS Earbuds with Upto 50H Playtime, Quad Mics ENx™ Tech, 13MM Drivers,Super Low Latency(50ms), ASAP™ Charge, BT v5.3(Opal Black) : Amazon.in: Electronics";
    public Productpage(WebDriver driver) {

        this.driver = driver;
    }
    public void verifytile(String Productname ){

        assertEquals(driver.findElement(Producttext).getText(),Productname);
    }
    public void addtocart()
    {
        try{
            Thread.sleep(7000);
        }
        catch (Exception e){

        }
       driver.findElement(Add_to_cart).click();

    }
    public void cart(){

        driver.findElement(Cart).click();
    }
    public void selectcolor(){

        driver.findElement(Coloratt).click();
    }
    public  void issetcolor(){
     /*   try{
            Thread.sleep(2000);
        }
        catch (Exception e){

        }*/
         String name=driver.findElement(By.cssSelector("li#color_name_0>span>div.tooltip>span>span>span>button>div>div>img")).getAttribute("alt");
         String name2= driver.findElement(By.cssSelector("div#variation_color_name>div.a-row>span.selection")).getText();
        //assertTrue(driver.findElement(Coloratt).);
        assertEquals(name,name2);

    }
}
