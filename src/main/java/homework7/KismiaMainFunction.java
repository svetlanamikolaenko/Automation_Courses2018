package homework7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class KismiaMainFunction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://kismia.com/");
        Thread.sleep(5000);
        //driver.findElement(By.cssSelector("#user-email")).click();
        driver.findElement(By.cssSelector("#user-email")).sendKeys("svetlana.mikolaenko@gmail.com");
        driver.findElement(By.cssSelector("#user-password")).click();
        driver.findElement(By.cssSelector("#user-password")).sendKeys("qweewq");
        driver.findElement(By.cssSelector("#user-password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

//        String titleActual = driver.getTitle();
//        String titleExpected = "Kismia";
//        System.out.println(titleActual);
//        Assert.assertEquals(titleActual, titleExpected);
        driver.quit();
    }

}
