package wangjian_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/5.
 */
public class regtest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }

    @Test
    public void regemail() {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.id("changepage")).click();
        //获得当前driver所在句柄只
        String handle1 = driver.getWindowHandle();

        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("nameIpt")).sendKeys("email"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("wj123456");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("wj123456");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainRegA")).click();

    }


    @AfterMethod
    public void closedbrowser(){
        driver.quit();
    }
}
