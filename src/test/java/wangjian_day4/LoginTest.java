package wangjian_day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2017/6/16.
 */
public class LoginTest {


        public static WebDriver login(WebDriver driver,String username,String pwd){
            System.setProperty("webdriver.chrome.driver", "D:\\homework\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://p.moonpool.com.cn:8080/toIndexPage");
            driver.manage().window().maximize();
            driver.findElement(loginku.phonenumber).sendKeys(username);
            driver.findElement(loginku.password).sendKeys(pwd);
            driver.findElement(loginku.logina).click();
            return driver;
        }




}
