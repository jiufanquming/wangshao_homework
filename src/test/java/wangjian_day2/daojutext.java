package wangjian_day2;

import com.thoughtworks.selenium.webdriven.commands.GetText;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wangjian_day4.LoginTest;
import wangjian_day4.loginku;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class daojutext {
    WebDriver driver;

    /**
     * 打开浏览器
     * 打开剧易拍
     * 输入用户名
     * 输入密码
     * 登录
     * 效验是否登录成功
     * 关闭
     */

    @BeforeMethod
    public void openChrome() throws InterruptedException {

        LoginTest.login(driver,"15010685335","123456");
       /* System.setProperty("webdriver.chrome.driver", "D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://p.moonpool.com.cn:8080/toIndexPage");
        driver.manage().window().maximize();
        driver.findElement(loginku.phonenumber).sendKeys("15010685335");
        driver.findElement(loginku.password).sendKeys("123456");
        driver.findElement(loginku.logina).click();*/
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://p.moonpool.com.cn:8080/toIndexPage");
    }




   @Test //关闭按钮
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

    @Test //编辑信息(校验)
    public void update() throws InterruptedException {
        //选择 拍摄管理
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位并点击道具表
        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);
        //选择摩托车
        driver.findElement(By.linkText("摩托车")).click();
        Thread.sleep(2000);
        //输入库存数量
        driver.findElement(By.id("propStock")).sendKeys("20");
        //选择道具类型
        driver.findElement(By.id("propsType")).click();
        Thread.sleep(2000);
        // 修改道具类型为特殊道具
        driver.findElement(By.xpath("//*[@id=\"rightPopupSelect\"]/div[2]")).click();
        Thread.sleep(2000);
        // 点击确定
        driver.findElement(By.id("prop-save-btn")).click();
        Thread.sleep(2000);
        //获取修改后的类型,并验证是否修改成功
        String text = driver.findElement(By.xpath("//*[@id=\"propMainInfo\"]/tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals(text, "特殊道具", "text：不是特殊道具");

    }

    @Test //删除(未做验证）
    public void delete() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("电脑")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("prop-delete-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("mainCloseBtn")).click();

        driver.findElement(By.id("prop-delete-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("ok")).click();
        Thread.sleep(2000);
        List<WebElement> listext = driver.findElements(By.xpath("//*[@id=\"propMainInfo\"]/tbody/tr/td[2]/a"));
        for (int i = 0; i < listext.size(); i++) {
            String text = listext.get(i).getText();
            System.out.println(text);

        }

    }

    @Test // 搜索(名称）--(校验)
    public void search() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("prop-toolbar-search")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("searchPropName")).sendKeys("火车");
        Thread.sleep(2000);

        driver.findElement(By.id("propSubmitBtn")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.linkText("火车")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "火车", "text:不是火车");

    }

    @Test //搜索（类型）-(校验)
    public void type() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("prop-toolbar-search")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("searchPropType")).click();
        driver.findElement(By.xpath("//*[@id=\"searchPropTypeSelect\"]/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("propSubmitBtn")).click();
        Thread.sleep(2000);
        List<WebElement> listext = driver.findElements(By.xpath(".//*[@id='propMainInfo']/tbody/tr/td[3]"));


        for (int i = 0; i < listext.size(); i++) {

            String text = listext.get(i).getText();
            System.out.println(text);
            Assert.assertEquals(text, "特殊道具", "text:不是特殊道具");
        }


    }


    @Test //场数搜索
    public void nubsearch() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();

        driver.findElement(By.linkText("道具表")).click();

        driver.findElement(By.className("prop-toolbar-search")).click();

        driver.findElement(By.id("searchPropStart")).sendKeys("1");

        driver.findElement(By.id("searchPropEnd")).sendKeys("7");
        Thread.sleep(3000);
        driver.findElement(By.id("propSubmitBtn")).click();
        Thread.sleep(3000);


    }


    @Test    //合并  —— 报错，待解决
    public void combine() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkAllProp0")).click();
        driver.findElement(By.id("checkAllProp1")).click();
        driver.findElement(By.className("prop-toolbar-combine")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("combinePropName")).sendKeys("手枪");
        Thread.sleep(2000);
        driver.findElement(By.id("combinePropType")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"combinePropTypeSelect\"]/div[1]")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//*[@class=\"prop-search-button\"]/input[1]")).click();
        Thread.sleep(2000);

    }

    @Test // 设置道具类型 —校验
    public void checkall() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkAll")).click();
        driver.findElement(By.xpath(".//*[@class='prop-toolbar-wrap']/input[4]")).click();
        driver.findElement(By.id("specialProp")).click();
        Thread.sleep(2000);
        List<WebElement> listext = driver.findElements(By.xpath(".//*[@id='propMainInfo']/tbody/tr/td[3]"));
        for (int i=0;i< listext.size();i++){
            String text = listext.get(i).getText();
            Assert.assertEquals(text,"特殊道具","text：不是特殊道具");
        }



    }

    @Test  //直接点击删除按钮，弹出提示框
    public void Verifydelectebutton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("道具表")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("prop-toolbar-delete")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("/html/body/div[15]/p/p")).getText();
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(2000);
        Assert.assertEquals(text,"请选择需要删除的道具信息","验证失败");
    }


     @AfterMethod
        public void closedBrowser() {
        driver.quit();

    }
}



