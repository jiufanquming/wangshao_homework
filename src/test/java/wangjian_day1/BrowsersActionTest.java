package wangjian_day1;

import com.thoughtworks.selenium.webdriven.commands.GetText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/5/2.
 */
public class BrowsersActionTest {
    WebDriver driver;
    /* 打开浏览器
     *  打开剧易拍首页
     *  获取当前页面URL
     *  等待3s
     *  效验当前URL是不是剧易拍网址
     *  关闭浏览器
     */
    // 打开浏览器
    @BeforeMethod
    public void openBrowersChrome() throws InterruptedException {
                // 设置driver 路径
        System.setProperty("webdriver.chrome.driver", "D:\\homework\\drivers\\chromedriver.exe");
               // 实例化 driver
        driver = new ChromeDriver();
    }
    // 打开剧易拍，获取URL，并效验
       @Test
        public void openJuYiPai() throws InterruptedException {
                  //打开剧易拍
            driver.get("http://192.168.10.250:8080/toLoginPage");

                  // 等待3s
            Thread.sleep(3000);
                 // 获取当前页面URL
            String url = driver.getCurrentUrl();
                 // 输出URL
            System.out.println("获取到的URL是:" + url);
                 // 效验当前URL
            Assert.assertEquals(url, "http://192.168.10.250:8080/toLoginPage", "url=http://192.168.10.250:8080/toLoginPage");
        }

        // 刷新浏览器
        @Test
        public void BrowserRefresh(){
        driver.navigate().refresh();
        }

        // 设置浏览器大小
       @Test
       public void BrowserCk() throws InterruptedException {
         driver.manage().window().maximize();
         //等待3s
          Thread.sleep(3000);
       }
       // 关闭浏览器
     // @AfterMethod
       public void  closeBrowserchrome(){

          driver.quit();
      }

   }

