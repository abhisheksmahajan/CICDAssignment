package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Accountpage {
    WebDriver driver;
    By checkDefaultBillingaddress= new By.ByCssSelector("#primary_billing");
    By addressBook = new By.ByXPath("//a[text()='Address Book']");
    By firstName = new By.ById("firstname");
    By lastName = new By.ById("lastname");
    By compony = new By.ById("company");
    By number = new By.ById("telephone");
    By addressLine1 = new By.ByCssSelector("input[id='street_1']");
    By addressLine2 = new By.ByCssSelector("input[id='street_2']");
    By city = new By.ByCssSelector("#city");
    By changeadder= new By.ByXPath("//span[contains(text(),'Change Billing Address')]");
    By addAdressbtn= new By.ByCssSelector("button[role='add-address']");
//    Select state = new Select(driver.findElement(By.cssSelector("select[title='State/Province']")));
//    Select country = new Select(driver.findElement(By.cssSelector("select[title='Country']")));
    By zipCode= new By.ById("zip");
    By submitBtn = new By.ByCssSelector("button[title='Save Address']");

    public Accountpage(WebDriver driver) {
        this.driver = driver;
    }
    public void addfirstname(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }
    public void addlastname(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void addcomponyname(String cname){
        driver.findElement(compony).sendKeys(cname);
    }
    public void addtelephonnumber(String tnumber){
        driver.findElement(number).sendKeys(tnumber);
    }
    public void addaddress(String addr1,String addr2){
        driver.findElement(addressLine1).sendKeys(addr1);
        driver.findElement(addressLine2).sendKeys(addr2);
    }
    public void addcity(String City){
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(City);
    }
    public void selectstate(String State){
        Select state = new Select(driver.findElement(By.cssSelector("select[title='State/Province']")));
        state.selectByVisibleText(State);
    }
    public void addzipcode(String Zip){
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(Zip);
    }
    public void selectcountry(String Country){
        Select country = new Select(driver.findElement(By.cssSelector("select[title='Country']")));
        country.selectByVisibleText(Country);
    }
    public void clickonsubmit(){
        driver.findElement(submitBtn).click();
    }
    public void clickonsaddressbook(){
        driver.findElement(addressBook).click();
    }
    public void clickonchangeaddress(){
        driver.findElement(changeadder).click();
    }
    public void clickonaddaddress(){
        driver.findElement(addAdressbtn).click();
    }

    public boolean ispresent(){
        try{
         driver.findElement(firstName).isDisplayed();
         return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
    public void Checkeddefaultbillingaddress(){
        driver.findElement(checkDefaultBillingaddress).click();
    }






}