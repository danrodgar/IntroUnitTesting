package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SearchSteps {
    WebDriver driver;
    //Establish the init page from which the program will start making the scenario
    @Given("the user is located in the index page")
    public void userIsInIndexPage()
    {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://uah.es/es/");
    }

    //Search for an element related with studies and click it
    @When("the user enters studies section")
    public void userEnterStudySection()
    {
        driver.findElement(By.linkText("ESTUDIOS")).click();
    }

    //Search for an element related with degrees and click it
    @When("the user clicks in the degree section")
    public void userClickDegreesSection()
    {
        driver.findElement(By.linkText("Grados")).click();
    }

    //Verify if the final page correspond to what it is look for
    @Then("the page with the degrees is shown")
    public void degreePage()
    {
        String title = driver.findElement(By.linkText("Grados")).getText();
        Assert.assertEquals(title, "Grados");
    }

}