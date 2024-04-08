package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Productpage {
    WebDriver driver;
    By xlSize= new By.ById("option-label-size-143-item-170");
    By addtocartbtn= new By.ByCssSelector("button[title=\"Add to Cart\"]");
    By color= new By.ByCssSelector("div[tabindex=\"0\"]>.swatch-option.color:nth-of-type(1)");
    By product1= new By.ByCssSelector(".products.list.items.product-items>.item.product.product-item:nth-of-type(1)>div>a");
    By product2= new By.ByCssSelector(".products.list.items.product-items>.item.product.product-item:nth-of-type(2)>div>a");
    By product3= new By.ByCssSelector(".products.list.items.product-items>.item.product.product-item:nth-of-type(3)>div>a");
    By wishlistbtn= new By.ByCssSelector(".product-addto-links>.action.towishlist");
//    @FindBy(css=".products.list.items.product-items>.item.product.product-item:nth-of-type(1)>div>a")
//    WebElement product1;
//    @FindBy(css=".products.list.items.product-items>.item.product.product-item:nth-of-type(2)>div>a")
//    WebElement product2;
//    @FindBy(css=".products.list.items.product-items>.item.product.product-item:nth-of-type(3)>div>a")
//    WebElement product3;
//    @FindBy(css = ".product-addto-links>.action.towishlist") WebElement wishlistbtn;
    By hoodiesAndSwetesherts= new By.ByCssSelector(".widget.block.block-static-block>div>.items:nth-of-type(1)>.item:nth-of-type(1)>a");
    By Comparebtn= new By.ByCssSelector(".product-addto-links>.action.tocompare");
    By productSecond= new By.ByCssSelector(".product-items.widget-product-grid>.product-item:nth-of-type(2)>div>div>div>div>div>a[title='Add to Compare']");
    By compareProductsbtn= new By.ByCssSelector("a[title=\"Compare Products\"]");

    public Productpage(WebDriver driver) {
        this.driver = driver;
    }
    public void addproducttocompare (){
        driver.findElement(Comparebtn).click();


    }

    public void clickoncompareproducts(){
        driver.findElement(compareProductsbtn).click();
    }
    public void Clickonhas(){
        driver.findElement(hoodiesAndSwetesherts).click();
    }
    public void clickonproduct1(){
        driver.findElement(product1).click();
    }
    public void clickonproduct2(){
        driver.findElement(product2).click();
    }
    public void clickonproduct3(){
        driver.findElement(product3).click();
    }
    public void clickonaddwishlist(){
        driver.findElement(wishlistbtn).click();
    }
    public void back(){
        driver.navigate().back();
    }
    public void navigate(){
        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
    }
    public void additemtocart(){
        driver.findElement(xlSize).click();
        driver.findElement(color).click();
        driver.findElement(addtocartbtn).click();
    }
}
