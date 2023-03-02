package ru.netology.webselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppOrderPositiveTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){

        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @AfterEach
    void  tearDown(){
        driver.quit();
        driver=null;
    }

    @Test
    void test2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Пантелеймон Пантелеймонов");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+720020020");
        driver.findElement(By.cssSelector("input[class='checkbox__control']")).click();
        driver.findElement(By.cssSelector("button[role='button']")).click();
        String text= driver.findElement(By.cssSelector("p[data-test-id='order-success'] ")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}
    @Test
    void test2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Ivanov Ivan");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79012345678");
        driver.findElement(By.cssSelector("span[class='checkbox__box']")).click();
        driver.findElement(By.cssSelector("button[role='button']")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'] span[class='input__sub']")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }
    @Test
    void test3() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Пантелеймон Пантелеймонов");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79012345");
        driver.findElement(By.cssSelector("span[class='checkbox__box']")).click();
        driver.findElement(By.cssSelector("button[role='button']")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'] span[class='input__sub']")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }
    @Test
    void test4() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Пантелеймон Пантелеймонов");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79012345678");
//        driver.findElement(By.cssSelector("span[class='checkbox__box']")).click();
        driver.findElement(By.cssSelector("button[role='button']")).click();
        String text = driver.findElement(By.cssSelector(".input_invalid")).getText();
        assertEquals("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй", text.trim());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
}

