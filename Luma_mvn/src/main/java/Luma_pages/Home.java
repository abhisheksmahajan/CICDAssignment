package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    WebDriver driver;
    By cart = new By.ByCssSelector(".action.showcart");
    By profiledropdown = new By.ByCssSelector("div[class='panel header'] button[type='button']");
    By my_account= new By.ByCssSelector("div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)");
    By my_wish_list= new By.ByCssSelector(".customer-menu[aria-hidden=\"false\"]>.header.links>li>a[href=\"https://magento.softwaretestingboard.com/wishlist/\"]");
    By men= new By.ByCssSelector("#ui-id-5");
    By signin= new By.ByCssSelector("div[class='panel header'] li[data-label='or']>a");
    By homeLogo= new By.ByCssSelector(".logo");
    By Viewandeditecart= new By.ByCssSelector(".action.viewcart");
    By cartcount= new By.ByCssSelector(".items-total");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void verify(){
        System.out.println("Page Title:"+driver.getTitle());
    }
    void clickoncart(){
        driver.findElement(cart).click();

    }
    public void login (){
        driver.findElement(signin).click();
    }
    public void clickonmyaccount(){
       driver.findElement(profiledropdown).click();
        driver.findElement(my_account).click();
    }
    void clickonmywishlist(){
        driver.findElement(profiledropdown).click();
        driver.findElement(my_wish_list).click();
    }
    public void clickonmenbtn(){
        driver.findElement(men).click();
    }
    public void Clickonhomebtn(){
        driver.findElement(homeLogo).click();
    }
    public void clickoncarticon(){
        try{
            Thread.sleep(3000);
        driver.findElement(cart).click();}catch (Exception e){}
    }
    public void clickonviewandeditecart(){
        driver.findElement(Viewandeditecart).click();
    }
    public String countofcart(){
        try {
            Thread.sleep(3000);
            driver.findElement(cart).click();
        }catch (Exception e){ }
        return driver.findElement(cartcount).getText();
    }
}
