package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wishlist {
    WebDriver driver;
    By deletFirstproduct= new By.ByCssSelector(".product-item:nth-of-type(3)>div>.product-item-details>.product-item-actions>.actions-secondary>.btn-remove.action.delete");
    By Addcartproduct= new By.ByCssSelector(".product-item:nth-of-type(1)>div>.product-item-details>.product-item-actions>.actions-primary>button");

    public Wishlist(WebDriver driver) {
        this.driver = driver;
    }
    public void deletfirstproduct(){
     try{
         Thread.sleep(3000);
     }catch (Exception e){

     }
        WebElement delete= driver.findElement(deletFirstproduct);
        delete.click();
    }
    public void Addlastaddedproducttocart(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }
        driver.findElement(Addcartproduct).click();
        //driver.findElement(By.cssSelector("button[title=\"Add to Cart\"]")).click();
    }
}
