package wangjian_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/5.
 */
public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenBrowser() throws MalformedURLException {

        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),dc);
        driver.get("http://mail.163.com");

    }
    @Test
    public void Loginsucess(){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("wj380018931");
        driver.findElement(By.name("password")).sendKeys("wj123456");
        driver.findElement(By.id("dologin")).click();
        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");

    }
    @Test
    public void loginerror() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("wj380018931");
        driver.findElement(By.name("password")).sendKeys("wj12345678");
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(5000);
        String error = driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误");


    }
    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }
}
