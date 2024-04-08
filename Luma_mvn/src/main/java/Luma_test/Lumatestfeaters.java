package Luma_test;

import Luma_pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lumatestfeaters {
    WebDriver driver;
    Home home;
    Login_page login;
    Accountpage accountpage;
    Productpage productpage;
    Compare_products compareProducts;
    Wishlist wishlist;
    Cartpage cartpage;
    Orderpage orderpage;
    @BeforeTest
    void Start(){
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(" https://magento.softwaretestingboard.com/");

    driver.manage().window().maximize();
    }
    @Test(priority = 0)
    void homeoperation(){
        home= new Home(driver);
        home.verify();
    }
    @Test(priority = 1)
    void Login(){
        home.login();
        login= new Login_page(driver);
        login.enterusername("tony.stark@hotmail.com");
        login.enterpassword("Abhi@2698");
        login.clickonsignin();

    }
    @Test(priority = 2)
    void Addressoperation(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e);
        }
        home.clickonmyaccount();
        accountpage = new Accountpage(driver);
        accountpage.clickonsaddressbook();
        if(accountpage.ispresent()) {
            accountpage.addfirstname("Tony");
            accountpage.addlastname("Starck");
            accountpage.addcomponyname("Stratindustries");
            accountpage.addtelephonnumber("7845784565");
            accountpage.addaddress("l block,B54 , stela Regidency", "Los Angeles,California,USA");
            accountpage.addcity("Los Angeles");
            accountpage.selectstate("California");
            accountpage.addzipcode("90002");
            accountpage.selectcountry("United States");
            accountpage.clickonsubmit();
        }
        else{
            accountpage.clickonaddaddress();
            accountpage.addfirstname("Tony");
            accountpage.addlastname("Starck");
            accountpage.addcomponyname("Stratindustries");
            accountpage.addtelephonnumber("7845784565");
            accountpage.addaddress("l block,B54 , stela Regidency", "Los Angeles,California,USA");
            accountpage.addcity("Los Angeles");
            accountpage.selectstate("California");
            accountpage.addzipcode("90002");
            accountpage.selectcountry("United States");
            accountpage.Checkeddefaultbillingaddress();
            accountpage.clickonsubmit();
        }
    }
    @Test(priority = 3)
    void Editaddress(){
       accountpage.clickonchangeaddress();
       accountpage.addcity("Acampo");
       accountpage.addzipcode("95220");
       accountpage.clickonsubmit();
    }
    @Test(priority = 4)
    void Wishlistoperations(){
        //home.clickonmenbtn();
        productpage = new Productpage(driver);
        home.clickonmenbtn();
        productpage.Clickonhas();
        productpage.clickonproduct1();
        productpage.clickonaddwishlist();
        productpage.navigate();
        productpage.clickonproduct2();
        productpage.clickonaddwishlist();
        productpage.navigate();
        productpage.clickonproduct3();
        productpage.clickonaddwishlist();
        wishlist= new Wishlist(driver);
        wishlist.deletfirstproduct();
        wishlist.Addlastaddedproducttocart();
        productpage.additemtocart();


    }
    @Test(priority = 5)
    void compareoperations(){

           home.clickonmenbtn();
           home.clickonmenbtn();
           productpage.Clickonhas();
           productpage.clickonproduct3();
           productpage.addproducttocompare();
           productpage.back();
           productpage.clickonproduct2();
           productpage.addproducttocompare();
           productpage.clickoncompareproducts();
           compareProducts = new Compare_products(driver);
           int a[]= compareProducts.Comparereviwes();
           if(a[0]>a[1]){
               compareProducts.clickon(".cell.product.info:nth-of-type(1)>.product-item-actions.hidden-print>.actions-primary");
           }
           else {
               compareProducts.clickon(".cell.product.info:nth-of-type(2)>.product-item-actions.hidden-print>.actions-primary");
           }
           productpage.additemtocart();
           productpage.clickoncompareproducts();
           compareProducts.clickdeletebtn1();
           compareProducts.clickondeletebtn2();

    }
    @Test(priority = 6)
    void cartoperation(){
        home.clickoncarticon();
        home.clickonviewandeditecart();
        System.out.println("Cart Count:"+home.countofcart());
        home.clickonmenbtn();
        productpage.Clickonhas();
        productpage.clickonproduct1();
        productpage.additemtocart();
        home.clickoncarticon();
        home.clickonviewandeditecart();
        System.out.println("Cart Count After Adding Product:"+home.countofcart());
        cartpage= new Cartpage(driver);
        home.clickoncarticon();
        System.out.println("Total Order Amount:"+cartpage.Orderamont());
        cartpage.clickonplaceorder();
        cartpage.checkfixedbtn();
        cartpage.clickshipherebtn();
        cartpage.clickonnextbtn();
        orderpage= new Orderpage(driver);
        orderpage.Checkaddress();
        orderpage.placeouder();
        System.out.println("Order Number:"+orderpage.Orderid());




    }


    @AfterTest
    void close(){
        driver.close();
    }

}
