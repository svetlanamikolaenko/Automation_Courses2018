package lesson7;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({MyTestListener.class})

public class AssertsExample {
    @Test
    public static void someAsserts(){
        Assert.assertEquals(5, 5);
        Assert.assertEquals("Jack", "Jack");
        //Assert.assertTrue(5>8, "Проверка 5>8");
        Assert.assertFalse(6>10);
    }
}
