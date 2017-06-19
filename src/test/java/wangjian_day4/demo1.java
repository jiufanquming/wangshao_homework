package wangjian_day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/16.
 */
public class demo1 {
       WebDriver driver;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
        driver = LoginTest.login(driver,"15010685335","123456");
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://p.moonpool.com.cn:8080/toIndexPage");
    }




    @Test //服化道关闭按钮
    public void closeadd() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("服化道表")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("prop-toolbar-add")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("prop-close-btn")).click();
        Thread.sleep(2000);

    }

    @Test
    public void kanjingtest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("勘景")).click();
        driver.findElement(By.id("addScenceBtn")).click();
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
