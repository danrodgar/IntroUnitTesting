package uah;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessExample {


  @Test
  void headlessChromeTest1() {
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");

    WebDriver driver = new ChromeDriver(options);
    driver.get("https://escuelapolitecnica.uah.es/");

    System.out.println("Title of the page:" + driver.getTitle());
    System.out.println("URL of the page:" + driver.getCurrentUrl());
  }

  /*
  @Test
  @Ignore
  public void headlessChromeTest() {

    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");

    WebDriver driver = new ChromeDriver(options);
    driver.get("http://www.google.com");

    // Form (searchbox) as we know its name "q"
    WebElement element = driver.findElement(By.name("q"));

    // Enter a search query
    element.sendKeys("UAH");

    // Submit the search query
    element.submit();

    // Page title
    System.out.println("Title of the page: " + driver.getTitle());

    driver.quit();
  }

   */

  @Test
  void headlessFirefoxTest() {
    System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");

    // set Firefox as Headless
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);

    WebDriver driver=new FirefoxDriver(options);  //Instantiate Firefox Driver
    driver.get("https://escuelapolitecnica.uah.es/");
    
    System.out.println("Title of the page:" + driver.getTitle());
    System.out.println("URL of the page:" + driver.getCurrentUrl());
  }

  @Test
  void HTMLUnitDriver() {
    // create instance for the HtmlUnitWebDriver
    HtmlUnitDriver driver = new HtmlUnitDriver();

    driver.get("https://escuelapolitecnica.uah.es/");

    System.out.println("Title of the page: " + driver.getTitle());
    System.out.println("URL of the page: " + driver.getCurrentUrl());
    driver.quit();
  }

}

