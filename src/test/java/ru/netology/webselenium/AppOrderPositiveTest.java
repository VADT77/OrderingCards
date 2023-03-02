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

