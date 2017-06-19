package wangjian_day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/5/16.
 */
public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
        alert.accept();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.switchTo().frame("aa");
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(2000);






    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
