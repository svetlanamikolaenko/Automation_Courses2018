package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
//import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akinator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://ru.akinator.com/");
        driver.findElement(By.cssSelector("#bulle-inner > a")).click();
        Scanner scannerAge = new Scanner(System.in);
        System.out.println("Введите Ваш возраст: ");
        String age = scannerAge.nextLine();

        driver.findElement(By.cssSelector("#elokence_sitebundle_identification_age")).sendKeys(age);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#elokence_sitebundle_identification_age")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement questionNumber = driver.findElement(By.cssSelector("#questionNo"));
        while (questionNumber.isDisplayed()) {
                String number = questionNumber.getText();
                String questionName = driver.findElement(By.cssSelector("#bulle-inner")).getText();
                System.out.println(number);
                System.out.println("Вопрос: " + questionName);
                WebElement yes = driver.findElement(By.cssSelector(".reponse  #reponse1"));
                WebElement no = driver.findElement(By.cssSelector(".reponse  #reponse2"));
                WebElement doNotKnow = driver.findElement(By.cssSelector(".reponse  #reponse3"));
                WebElement maybe = driver.findElement(By.cssSelector(".reponse  #reponse4"));
                WebElement maybeNo = driver.findElement(By.cssSelector(".reponse  #reponse5"));

                System.out.println(yes.getText() + " - 1");
                System.out.println(no.getText() + " - 2");
                System.out.println(doNotKnow.getText() + " - 3");
                System.out.println(maybe.getText() + " - 4");
                System.out.println(maybeNo.getText() + " - 5");

                System.out.println("Выберите номер ответа из списка: ");
                Scanner scannerAnswer = new Scanner(System.in);
                Integer answer = scannerAnswer.nextInt();


                if (answer.equals(1)) {
                    System.out.println("Вы в консоль вводите ответ: " + answer);
                    yes.click();
                    Thread.sleep(4000);
                }
                if (answer.equals(2)) {

                    no.click();
                    Thread.sleep(4000);
                }
                if (answer.equals(3)) {
                    System.out.println("Вы в консоль вводите ответ: " + answer);

                    doNotKnow.click();
                    Thread.sleep(4000);

                }
                if (answer.equals(4))  {
                    System.out.println("Вы в консоль вводите ответ: " + answer);

                    maybe.click();
                    Thread.sleep(4000);
                }
                if (answer.equals(5))  {
                    System.out.println("Вы в консоль вводите ответ: " + answer);
                    maybeNo.click();
                    Thread.sleep(4000);

                } else {
                    System.out.println("Варианты ответа от 1 до 5");
                }
            }



        WebElement infosPerso = driver.findElement(By.cssSelector("#infos-perso-title  #perso"));
        if (infosPerso.isDisplayed()) {
            System.out.println(infosPerso.getText());
        }

                driver.quit();
    }


}






