package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ Open Website
        driver.get("https://automationexercise.com/");

        // 2️⃣ Click on Products
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']"))).click();

        // 3️⃣ Close Ad if Present (Try-Catch Safe Handling)
        try {
            WebElement adClose = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("div.modal button.close"))
            );
            adClose.click();
        } catch (Exception e) {
            System.out.println("No ad popup appeared.");
        }

        // 4️⃣ Search for T-shirts
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")))
                .sendKeys("T-shirts");

        driver.findElement(By.id("submit_search")).click();

        // 5️⃣ Wait to view results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("productinfo")));

        System.out.println("Search Completed Successfully!");

        // Optional delay to see results
        try { Thread.sleep(9000); } catch (Exception ignored) {}

        driver.quit();
    }
}
