package Luma_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {
    WebDriver driver;
    By UserName = new By.ById("email");
    By Password = new By.ByCssSelector("input[name=\"login[password]\"]");
    By Signin= new By.ByCssSelector(".action.login.primary");

    public Login_page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterusername(String username){
        driver.findElement(UserName).sendKeys(username);
    }
    public void enterpassword(String Pass){
        driver.findElement(Password).sendKeys(Pass);
    }
    public void clickonsignin(){
        driver.findElement(Signin).click();
    }

}
