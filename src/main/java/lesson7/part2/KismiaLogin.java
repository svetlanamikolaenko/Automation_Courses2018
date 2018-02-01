package lesson7.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class KismiaLogin extends BrowserFactory{

    @Test
    @Parameters({"email", "password"})
    public void login(@Optional ("svetlana.mikolaenko@gmail.com") String email, @Optional ("qweewq") String password) throws InterruptedException {
        System.out.println("Email" + email);
        System.out.println("Password "+password);
        driver.get("https://kismia.com/");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("return window.stop");//остановить загрузку страницы
        driver.findElement(By.cssSelector("#user-email")).sendKeys(email);
        driver.findElement(By.cssSelector("#user-password")).click();
        driver.findElement(By.cssSelector("#user-password")).sendKeys(password);
        driver.findElement(By.cssSelector("#user-password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("kismia.com/u"), "Wrong Page: " + driver.getCurrentUrl());

    }

}
