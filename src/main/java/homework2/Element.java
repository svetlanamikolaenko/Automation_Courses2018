package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element {
    public static void main(String [] args) throws InterruptedException {
        System.out.println(isPresent());

    }

    public static boolean isPresent() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000 );
        WebElement element= driver.findElement(By.xpath("//*[@id='12']"));
        driver.quit();
        return true;
    }
}
