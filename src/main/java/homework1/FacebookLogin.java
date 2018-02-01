package homework1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");//переход по ссылке
        Thread.sleep(2000 );
        driver.findElement(By.xpath("//*[@id='email']")).click();
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("svitlana.mykolaienko@gen.tech");
        driver.findElement(By.xpath("//*[@id= 'pass']")).click();
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Sveta131264");
        driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000 );
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
