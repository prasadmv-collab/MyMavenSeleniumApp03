package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {
    public static void main(String[] args) {

        // 🔥 Headless setup (MANDATORY for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open website
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Enter username
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                    .sendKeys("student");

            // Enter password
            driver.findElement(By.id("password")).sendKeys("Password123");

            // Click login
            driver.findElement(By.id("submit")).click();

            // Wait for logout button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")))
                    .click();

            System.out.println("✅ Login and logout successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
