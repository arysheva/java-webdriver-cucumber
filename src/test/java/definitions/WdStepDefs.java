package definitions;
import static support.TestContext.getDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static org.assertj.core.api.Assertions.assertThat;



public class WdStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {

        switch(page) {
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "bing":
                getDriver().get("https://www.bing.com/");
                break;
            default:
                throw new RuntimeException("Unsupported page! " + page);
        }


    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device) {
        if (device.equalsIgnoreCase("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
        }
        else if (device.equalsIgnoreCase("desktop"))
        {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        }
        else
        {
            getDriver().manage().window().maximize();
        }
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Anna");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("anna@aa.aa");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Anna");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Rostova");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        getDriver().findElement(By.xpath("//span[contains(text(), 'read and accept')]")).click();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("email");
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("anna@a");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("anna@a.ru");
        Thread.sleep(3000);

    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualToIgnoringCase("Anna Rostova");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualToIgnoringCase("anna@a.ru");
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() {
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("------------Logs Begin------------ ");
        for (LogEntry log: logs) {
            System.out.println(log);
            
        }

        System.out.println("------------Logs End------------ ");
    }
}
