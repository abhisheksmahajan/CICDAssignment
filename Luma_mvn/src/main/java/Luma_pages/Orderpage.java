package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Orderpage {
    WebDriver driver;
    By placeOrder= new By.ByCssSelector(".action.primary.checkout");
    By checkaddress= new By.ByCssSelector("input[name='billing-address-same-as-shipping']");
    By orderId= new By.ByCssSelector(".order-number");

    public Orderpage(WebDriver driver) {
        this.driver = driver;
    }
    public void placeouder(){
        try{
            Thread.sleep(3000);
        driver.findElement(placeOrder).click();}catch (Exception e){}
    }
    public void Checkaddress(){
        try{
            Thread.sleep(3000);
            driver.findElement(checkaddress).click();
        }catch(Exception e){}
    }
    public String Orderid(){
        return  driver.findElement(orderId).getText();
    }
}
