package wangjian_day2;

import jdk.internal.org.objectweb.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class windowSelectest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

























   // @Test
    public void wintest() {
        driver.get("http://192.168.10.250:8080/toLoginPage");
        WebElement loginButton = driver.findElement(By.linkText("注册账号"));
        Actions actions = new Actions(driver);
        //  actions.contextClick(loginButton).perform();
        // actions.doubleClick(loginButton).perform();
        actions.moveToElement(loginButton).perform();
    }

  //  @Test
    public void movedrop(){
        driver.get("file:///D:/selenium_html/dragAndDrop.html");
        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release().perform();


    }







}
