import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Colorselection {
    WebDriver driver;
    @BeforeMethod
    void load(){
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    void selctcolor() {
        try {
            String ExpectedTitle = "boAt Airdopes Atom 81 TWS Earbuds with Upto 50H Playtime, Quad Mics ENx™ Tech, 13MM Drivers,Super Low Latency(50ms), ASAP™ Charge, BT v5.3(Opal Black) : Amazon.in: Electronics";
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Boat Headphones");
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

            Thread.sleep(2000);

            WebElement Click_2 = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]"));
            Click_2.click();
            Thread.sleep(2000);
            for(String Window : driver.getWindowHandles()) {
                driver.switchTo().window(Window);
            }
            driver.findElement(By.cssSelector("button#a-autoid-14-announce")).click();
            Thread.sleep(2000);
            boolean select=driver.findElement(By.cssSelector("button#a-autoid-14-announce")).isSelected();
            Assert.assertEquals(select,true);

        }catch(Exception e){
         System.out.println(e);
        }

    }
}
