package wangjian_day4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/16.
 */
public class data_test {
    WebDriver driver;

    @DataProvider(name = "loginuser")
    public Object[][] test() {
        return new Object[][]{
                {"15010685335", "123456"},
                {"15295542857", "111111"}
        };

    }

    @Test(dataProvider = "loginuser")
    public void logintest(String name,String pwd ) throws InterruptedException {

      System.setProperty("webdriver.chrome.driver", "D:\\homework\\drivers\\chromedriver.exe");
       driver = new ChromeDriver();
        driver.get("http://p.moonpool.com.cn:8080/toIndexPage");
       driver.findElement(By.id("userName")).sendKeys(name);
       driver.findElement(By.id("password")).sendKeys(pwd);

      WebElement login = driver.findElement(By.className("login_b"));

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }


}