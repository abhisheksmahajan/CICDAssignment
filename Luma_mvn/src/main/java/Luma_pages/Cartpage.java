package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cartpage {
    WebDriver driver;
    By orderAmount= new By.ByCssSelector(".amount>strong>.price");
    By placeOrderbtn= new By.ByCssSelector(".item>.action.primary.checkout");
    By fixed= new By.ByCssSelector("input[name=\"ko_unique_2\"]");
    By next= new By.ByCssSelector(".button.action.continue.primary");
    By shipHere= new By.ByCssSelector(".shipping-address-item.not-selected-item:nth-of-type(2)>.action.action-select-shipping-item");


    public Cartpage(WebDriver driver) {
        this.driver = driver;
    }
    public String Orderamont(){
        return driver.findElement(orderAmount).getText();
    }
    public void  clickonplaceorder(){
        driver.findElement(placeOrderbtn).click();
    }
    public void  checkfixedbtn(){
        driver.findElement(fixed).click();
    }
    public void clickonnextbtn(){
        driver.findElement(next).click();
    }
    public void clickshipherebtn(){ try{
        Thread.sleep(3000);
        driver.findElement(shipHere).click();}catch (Exception e){}
    }
}
