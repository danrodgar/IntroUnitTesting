package uah;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

  @Test
  public void testInitial() {
    System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");

    WebDriver driver = new FirefoxDriver();
    driver.get("https://escuelapolitecnica.uah.es/");
    driver.quit();
  }
}
