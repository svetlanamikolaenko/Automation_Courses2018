package lesson5;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

public class FacebookPage {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){driver = new ChromeDriver();}

    @Test
    public void myAweSomeTest() {
        driver.get("https://facebook.com");
        WebElement firstname = driver.findElement(By.cssSelector("[name='firstname']"));
        WebElement lastbame = driver.findElement(By.cssSelector("[name='lastname']"));
        WebElement mobilePhone = driver.findElement(By.cssSelector("[name^='reg_ema']"));
        WebElement password = driver.findElement(By.cssSelector("[name*='pass']"));
        WebElement date;
        date = driver.findElement(By.cssSelector("#day"));
        WebElement month = driver.findElement(By.cssSelector("#month"));
        WebElement year = driver.findElement(By.cssSelector("#year"));
        WebElement sex = driver.findElement(By.cssSelector("[name='sex'][value='1']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[name = 'websubmit']"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}

