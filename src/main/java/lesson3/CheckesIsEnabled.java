package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckesIsEnabled {
    public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.get("http://www.plus2net.com/javascript_tutorial/listbox-disabled-demo.php");
    WebElement yesSelect = driver.findElement(By.cssSelector("[name='choice'][value='yes']"));
        System.out.println("IS YES SELECTED: "+yesSelect.isSelected());
        yesSelect.click();
        System.out.println("IS YES SELECTED AFTER CLICK: "+yesSelect.isSelected());

        System.out.println("DROPDOWN IS ENABLED: "+driver.findElement(By.cssSelector("[name='Category']")).isEnabled());

    WebElement noSelect = driver.findElement(By.cssSelector("[name='choice'][value='no']"));
        noSelect.click();
        System.out.println("DROPDOWN IS ENABLED AFTER NO CLICK: "+driver.findElement(By.cssSelector("[name='Category']")).isEnabled());
        Thread.sleep(5000);
        driver.quit();
}
}