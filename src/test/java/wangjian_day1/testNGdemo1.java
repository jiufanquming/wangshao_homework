package wangjian_day1;

import org.testng.annotations.*;

/**
 * Created by Administrator on 2017/4/25.
 */
public class testNGdemo1 {
    @Test
    public void  classCase1(){
    System.out.println("这是第1个测试用列");
    }
    @Test
    public  void  classCase2(){
    System.out.println("这是第2个测试用列");
    }
    @BeforeTest
    public  void  Beforetest(){
        System.out.println("打开浏览器");
    }
    @AfterTest
    public  void  AfterTest(){
        System.out.println("关闭浏览器");
    }
}
