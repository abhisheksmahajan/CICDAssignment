package Luma_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class Compare_products {
    WebDriver driver;

    By deleteFirstprodust= new By.ByCssSelector(".cell.remove.product.hidden-print:nth-of-type(1)>a");
    By deleteSecondprodust= new By.ByCssSelector(".cell.remove.product.hidden-print:nth-of-type(2)>a");

    public Compare_products(WebDriver driver) {
        this.driver = driver;
    }
    public void clickdeletebtn1(){

        driver.findElement(deleteFirstprodust).click();
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@class=\"action-primary action-accept\" and @type=\"button\"]")).click();
//      //  wait.until(ExpectedConditions.alertIsPresent());

        }catch (Exception e){ }
//        driver.switchTo().alert().accept();
    }
    public void clickondeletebtn2() {

        driver.findElement(deleteFirstprodust).click();
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@class=\"action-primary action-accept\" and @type=\"button\"]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }
    public int[] Comparereviwes(){
        int numRev1;
        int numRev2;
        try{
        String r1= driver.findElement(By.cssSelector(".cell.product.info:nth-of-type(1)>div>.reviews-actions>a")).getText();
        numRev1 = Integer.parseInt(String.valueOf(r1.charAt(0)));}catch (Exception e){ numRev1= 0; }
        try {
        String r2= driver.findElement(By.cssSelector(".cell.product.info:nth-of-type(2)>div>.reviews-actions>a")).getText();
        numRev2 = Integer.parseInt(String.valueOf(r2.charAt(0)));}catch (Exception e){ numRev2= 0; }

        int a[]={numRev1,numRev2};
        return a;
    }
      public void  clickon(String css){
        driver.findElement(By.cssSelector(css)).click();
    }
}
