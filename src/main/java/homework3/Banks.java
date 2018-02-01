package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.stream.util.StreamReaderDelegate;
import java.util.List;

public class Banks {
    public WebDriver driver;
    private StreamReaderDelegate elenemt;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(2000);
    }

    @Test
    public void myHomeWork3() throws InterruptedException {

//        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
//        WebElement natBank = driver.findElement(By.cssSelector("tr:nth-child(9) > td.cell_c:nth-child(5))"));
//        String NBU = natBank.getCssValue("td.cell_c");
//        double dollarNBU = Double.parseDouble(NBU);
//        System.out.println("Курс доллара НБУ: " + dollarNBU);

        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        driver.get("https://www.aval.ua/ru/personal/everyday/exchange/exchange/");
        driver.get("https://www.privat24.ua");
        driver.navigate().back();
        driver.navigate().back();

        WebElement dollarBUkrSib = driver.findElement(By.cssSelector(".currency__wrapper > table > tbody tr:nth-child(1) > td:nth-child(2)"));
        String dollarBuyUkrSib = dollarBUkrSib.getText();
        WebElement dollarSUkkrSib = driver.findElement(By.cssSelector(".currency__wrapper > table > tbody tr:nth-child(1) > td:nth-child(3)"));
        String dollarSellUkrSib = dollarSUkkrSib.getText();

        double dollarBuyUkrSibBank = Double.parseDouble(dollarBuyUkrSib);
        double dollarSellUkrSibBank = Double.parseDouble(dollarSellUkrSib);
        System.out.println("Курс покупки доллара в Авале: " + dollarBuyUkrSibBank);
        System.out.println("Курс продажи доллара в Авале: " + dollarSellUkrSibBank);



       driver.navigate().forward();
        WebElement dollarBAval = driver.findElement(By.xpath("//*[@id='bar-center']/div[1]/div/div[1]/table/tbody/tr[2]/td[2]"));
        String dollarBuyAval = dollarBAval.getText();
        WebElement dollarSAval = driver.findElement(By.cssSelector( "div.right-currency-block-rba > table > tbody > tr:nth-child(2) > td:nth-child(3)"));
        String dollarSellAval = dollarSAval.getText();
        //float dollarBuyAvalBank = Float.parseFloat(dollarBuyAval);
//        double dollarSellAvalBank = Double.parseDouble(dollarSellAval);
        System.out.printf("Курс покупки доллара в Авале: %s%n", dollarBuyAval);
        System.out.println("Курс продажи доллара в Авале: " + dollarSellAval);


        driver.navigate().forward();
        WebElement privatD = driver.findElement(By.cssSelector("div:nth-child(1) > .section-content.rate"));


        String dollarPrivat = privatD.getText();
        String [] dollarBuySellPrivat = dollarPrivat.split("/");

        double dollarBuyPrivat = Double.parseDouble(dollarBuySellPrivat[0]) ;
        double dollarSellPrivat = Double.parseDouble(dollarBuySellPrivat[1]);

        System.out.println("Курс покупки доллара в ПриватБанке: " + dollarBuyPrivat);
        System.out.println("Курс продажи доллара в ПриватБанке: " + dollarSellPrivat);

//        driver.get("http://www.oschadbank.ua/ua/");



//




//
//
//
//
//        //driver.findElement(By.xpath("//*[@id='closeButton']/b")).click();
//        driver.findElement(By.xpath("//*[@id=\"content-inner\"]/div/ul/li[1]/div[2]/div[1]/div/ul/li/a")).click();
//        WebElement hallFrame = driver.findElement(By.xpath("//*[@class='arcticmodal-container_i']//iframe"));
//        driver.switchTo().frame(hallFrame);
//        Thread.sleep(3000);
//        List<WebElement> seats = driver.findElements(By.xpath("//*[@id='hall-scheme-container']//*[contains(@id,'hseat')]"));
//        for (WebElement element : seats) {
//            String atrib = element.getAttribute("class");
//        }
//        int quantity = seats.size();
//        System.out.println("Количество мест в зале: "+quantity);
//        List<WebElement> seats_free = driver.findElements(By.xpath("//*[@class='seat seat-color1']"));
//        int free = seats_free.size();
//        System.out.println("Количество свободных мест: "+ free);
//
//        List<WebElement> seats_occupied = driver.findElements(By.xpath("//*[@class='seat seat-occupied']"));
//        int occupied = seats_occupied.size();
//        System.out.println("Количество занятых мест: "+ occupied);
//
//        float free_percent = (float) free/quantity *100;
//        float occupied_percent = (float) occupied/quantity*100;
//        System.out.println("Занятых мест от “всего мест в зале " + occupied_percent + "%");
//        System.out.println("Свободных мест от “всего мест в зале " + free_percent + "%");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

