package JeP;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Administrator on 2017/5/17.
 */
public class roleTable {
    WebDriver driver;

    @BeforeMethod //登录剧易拍
    public void OpenChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\homework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://p.moonpool.com.cn:8080/toLoginPage");
        driver.manage().window().maximize();
        driver.findElement(By.id("userName")).sendKeys("15010685335");

        driver.findElement(By.id("password")).sendKeys("123456");

        driver.findElement(By.className("login_b")).click();

        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://p.moonpool.com.cn:8080/toIndexPage");
    }

    @Test  //空角色信息点击保存给出提示
    public void juesebiao() throws InterruptedException {
        // 点击拍摄管理
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位角色表，并点击
        driver.findElement(By.linkText("角色表")).click();
        Thread.sleep(2000);
         //点击创建角色
        driver.findElement(By.id("createRoleBtn")).click();
        Thread.sleep(1000);
         //点击保存角色
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(1000);
        // 获取提示信息，并做校验
        String text = driver.findElement(By.className("tips1")).getText();
        Assert.assertEquals(text,"角色名称不能为空","text；不是角色名称不能为空");
    }

    @Test  //创建角色
    public void addrole() throws InterruptedException {
        // 点击拍摄管理
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位角色表，并点击
        driver.findElement(By.linkText("角色表")).click();
        Thread.sleep(2000);
        //点击创建角色
        driver.findElement(By.id("createRoleBtn")).click();
        Thread.sleep(1000);
        // 输入角色名称
        driver.findElement(By.id("modifyViewRoleName")).sendKeys("诸葛亮");
        //定位类型下拉框
        WebElement element = driver.findElement(By.id("modifyViewRoleType"));
        //new 一个 select 对象
        Select select = new Select(element);
        //select.selectByIndex(1);
        select.selectByValue("1");
       // select.selectByVisibleText("特约演员");
        // 点击保存
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(1000);
        //获取新建的角色名称,并做校验
        String text = driver.findElement(By.linkText("诸葛亮")).getText();
        Assert.assertEquals(text,"诸葛亮");

    }

    @Test // 编辑角色-简称
    public void updaterole() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位角色表，并点击
        driver.findElement(By.linkText("角色表")).click();
        Thread.sleep(2000);
        //选择角色“诸葛亮”
        driver.findElement(By.linkText("诸葛亮")).click();
        Thread.sleep(2000);
        //输入角色简称
        driver.findElement(By.id("modifyShortName")).sendKeys("孔明");
        // 点击保存
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath(".//*[@id='viewRoleListGrid']/tr[1]/td[3]")).getText();
        Assert.assertEquals(text,"孔明","验证错误");
    }

    @Test // 编辑角色-演员姓名
    public void updaterole1() throws InterruptedException {
        // 拍摄管理
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位角色表，并点击
        driver.findElement(By.linkText("角色表")).click();
        Thread.sleep(2000);
        //选择角色“诸葛亮”
        driver.findElement(By.linkText("诸葛亮")).click();
        Thread.sleep(2000);
        //输入演员姓名
        driver.findElement(By.id("modifyActorName")).sendKeys("唐国强");
        // 点击保存
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath(".//*[@id='viewRoleListGrid']/tr[1]/td[5]")).getText();
        Assert.assertEquals(text,"唐国强","验证错误");

    }

    @Test // 编辑角色-入组/离组时间（报错）
    public void updeaterole2() throws InterruptedException {
        // 拍摄管理
        driver.findElement(By.xpath("//*[@id=\"tabMenuList\"]/ul/li[3]")).click();
        Thread.sleep(2000);
        // 定位角色表，并点击
        driver.findElement(By.linkText("角色表")).click();
        Thread.sleep(2000);
        //选择角色“诸葛亮”
        driver.findElement(By.linkText("诸葛亮")).click();
        Thread.sleep(2000);
        //定位进组时间
        driver.findElement(By.id("modifyEnterDate")).click();
        Thread.sleep(3000);
        //通过Webelement方式转交控制权
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='WdayTable']/tbody/tr[4]/td[1]")).click();

        //将控制权转交回去
        driver.switchTo().defaultContent();
        //输入离组时间
        driver.findElement(By.id("modifyLeaveDate")).click();
        Thread.sleep(3000);
        //通过Welement方式转交控制权
        WebElement iframe1 = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe1);

        driver.findElement(By.xpath("//*[@class='WdayTable']/tbody/tr[4]/td[7]")).click();
        Thread.sleep(1000);
        //将控制权转交回去
        driver.switchTo().defaultContent();
        // 点击保存
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(1000);
        String text1 = driver.findElement(By.xpath(".//*[@id='viewRoleListGrid']/tr[1]/td[10]")).getText();
        String text2 = driver.findElement(By.xpath(".//*[@id='viewRoleListGrid']/tr[1]/td[11]")).getText();
        Assert.assertEquals(text1,"2017-05-14","验证错误");
        Assert.assertEquals(text1,"2017-05-20","验证错误");

    }




    @AfterMethod // 关闭浏览器
    public void closedBrowser(){
        driver.quit();
    }
}
