package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookFindElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        WebElement element = driver.findElement(By.xpath("//*[contains(@class,'fb_logo')]"));
        System.out.println(element.isDisplayed());
        System.out.println(element.isEnabled());
        System.out.println(element.isSelected());// для чекбоксов
        driver.quit();


    }
}