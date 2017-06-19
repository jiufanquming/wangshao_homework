package wangjian_day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/4/27.
 */
public class openBrowsersTest {


    @Test
    public void openChrore() throws InterruptedException {
        // 设置driver 路径
        System.setProperty("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        //  实例化driver
        WebDriver driver = new ChromeDriver();
        //打开剧易拍
        driver.get("http://p.moonpool.com.cn:8080/toLoginPage");
        //后退
       driver.navigate().back();

        // 等待5s
        Thread.sleep(3000);
        // 关闭 浏览器
        driver.quit();
    }
}
