package wangjian_day1;

import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/26.
 */
public class testNGdemo2 {
    @Test
    public  void  assertEqual(){
        int a = 1;
        int b = 1;
        Assert.assertEquals(a,b,"a不等于b");
    }
    @Test
    public void assertNotEquals(){
        String usename = "15010685335";
        String password = "123456";
        Assert.assertNotEquals(usename,password);
    }
    @Test
    public void assertNull(){
        String A = null;
        Assert.assertNull(A);
    }
    @Test
    public void assertNotNull(){
        String a = "几天周三";
        Assert.assertNotNull(a);


    }
}
