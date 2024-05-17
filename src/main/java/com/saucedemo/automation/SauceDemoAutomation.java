package com.saucedemo.automation;

/**
 * Created by Ashwini Patil on May 16, 2024
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class SauceDemoAutomation {

   public static void main(String[] args) throws InterruptedException {
      // Setting up Safari WebDriver
      System.setProperty("webdriver.safari.driver", "/Applications/Safari.app");
      WebDriver driver = new SafariDriver();

      // Navigate to the website
      driver.manage().window().maximize();
      driver.get("https://www.saucedemo.com/");

      // Scenario 1: Standard User Journey
      standardUserJourney(driver);
      Thread.sleep(3000);

      // Scenario 2: Performance Glitch User Journey
      performanceGlitchUserJourney(driver);
      Thread.sleep(3000);

      // Closing the WebDriver session
      driver.quit();
   }

   private static void standardUserJourney(WebDriver driver) throws InterruptedException {
      // Login as Standard User
      login(driver, "standard_user", "secret_sauce");

      // Add 3 products to Cart and checkout
      addProductsToCart(driver, 3);

      // Add a product and remove it on the Cart page
      addAndRemoveProductOnCart(driver);

      // Logout as Standard User
      logout(driver);
   }

   private static void performanceGlitchUserJourney(WebDriver driver) throws InterruptedException {
      // Login as Performance Glitch User
      login(driver, "performance_glitch_user", "secret_sauce");

      // Add 3 products to Cart and checkout
      addProductsToCart(driver, 3);

      // Add a product and remove it on the Cart page
      addAndRemoveProductOnCart(driver);

      // Logout as Performance Glitch User
      logout(driver);
   }

   private static void login(WebDriver driver, String username, String password) throws InterruptedException {
      WebElement usernameField = driver.findElement(By.id("user-name"));
      WebElement passwordField = driver.findElement(By.id("password"));
      WebElement loginButton = driver.findElement(By.id("login-button"));

      usernameField.sendKeys(username);
      passwordField.sendKeys(password);

      Thread.sleep(3000);
      loginButton.click();
   }

   private static void logout(WebDriver driver) throws InterruptedException {
      Thread.sleep(3000);
      driver.findElement(By.id("react-burger-menu-btn")).click();
      Thread.sleep(3000);
      WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].click()", logoutButton);
   }

   private static void addProductsToCart(WebDriver driver, int numProducts) throws InterruptedException {
      for (int i = 0; i < numProducts; i++) {
         WebElement addButton = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]"));
         Thread.sleep(1000);
         addButton.click();
      }

      Thread.sleep(3000);
      WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
      cartButton.click();

      Thread.sleep(3000);
      WebElement checkoutButton = driver.findElement(By.id("checkout"));
      checkoutButton.click();

      Thread.sleep(3000);
      checkout(driver);
   }

   private static void checkout(WebDriver driver) throws InterruptedException {
      driver.findElement(By.id("first-name")).sendKeys("Ashwini");
      driver.findElement(By.id("last-name")).sendKeys("Patil");
      driver.findElement(By.id("postal-code")).sendKeys("560100");
      Thread.sleep(3000);
      driver.findElement(By.id("continue")).click();

      Thread.sleep(3000);
      driver.findElement(By.id("finish")).click();

      Thread.sleep(3000);
      driver.findElement(By.id("back-to-products")).click();
   }

   private static void addAndRemoveProductOnCart(WebDriver driver) throws InterruptedException {
      WebElement addButton = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]"));
      Thread.sleep(1000);
      addButton.click();

      Thread.sleep(3000);
      WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
      cartButton.click();

      Thread.sleep(3000);
      WebElement removeButton = driver.findElement(By.xpath("(//button[@class='btn btn_secondary btn_small cart_button'])[1]"));
      removeButton.click();

      Thread.sleep(3000);
      driver.findElement(By.id("continue-shopping")).click();
   }
}
