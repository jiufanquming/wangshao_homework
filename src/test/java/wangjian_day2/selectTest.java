package wangjian_day2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;

/**
 * Created by Administrator on 2017/5/10.
 */
public class selectTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
     //打开测试界面
    // 选择iphone
    //
    @Test
    public void openselect() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.manage().window().maximize();
        WebElement selectEL = driver.findElement(By.id("moreSelect"));
        Select select = new Select(selectEL);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("oppe");
        Thread.sleep(3000);
        select.selectByVisibleText("huawei");
        Thread.sleep(3000);



    }



   // @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
