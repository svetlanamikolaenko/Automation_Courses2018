package homework3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.stream.util.StreamReaderDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LiniaKino {
    public WebDriver driver;
    private StreamReaderDelegate elenemt;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void myHomeWork3() throws InterruptedException {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        // driver.findElement(By.xpath("//*[@id='closeButton']/b")).click();
        driver.findElement(By.xpath("//*[@class='showtimes-list']//*[@class='showtime-movie'][1]//*[contains(@class,'showtime-day')][1]//*[@class='showtime-item'][2]/a")).click();
        WebElement hallFrame = driver.findElement(By.xpath("//*[@class='arcticmodal-container_i']//iframe"));
        driver.switchTo().frame(hallFrame);
        Thread.sleep(3000);
        List<WebElement> seats = driver.findElements(By.xpath("//*[@id='hall-scheme-container']//*[contains(@id,'hseat')]"));
        for (WebElement element : seats) {
            String atrib = element.getAttribute("class");
        }
        int quantity = seats.size();
        System.out.println("Количество мест в зале: "+quantity);
        List<WebElement> seats_free = driver.findElements(By.xpath("//*[@class='seat seat-color1']"));
        int free = seats_free.size();
        System.out.println("Количество свободных мест: "+ free);

        List<WebElement> seats_occupied = driver.findElements(By.xpath("//*[@class='seat seat-occupied']"));
        int occupied = seats_occupied.size();
        System.out.println("Количество занятых мест: "+ occupied);

        float free_percent = (float) free/quantity *100;
        float occupied_percent = (float) occupied/quantity*100;
        System.out.println("Занятых мест от “всего мест в зале " + occupied_percent + "%");
        System.out.println("Свободных мест от “всего мест в зале " + free_percent + "%");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
}
}

