package wangjian_day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/6/7.
 */
public class GridTest {

    @DataProvider(name = "data1")
    public Object[][]test1() {
        return new Object[][]{
                {"chrome"},
                {"firefox"},

        };
    }
    @Test(dataProvider = "data1")
    public void testGrid2(String Browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (Browser.contentEquals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if (Browser.equals("firefox")) {
            dc = DesiredCapabilities.firefox();
        }else {
            System.out.println();
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();

    }


  }
