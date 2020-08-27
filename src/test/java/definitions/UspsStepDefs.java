package definitions;

import static java.lang.StrictMath.abs;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.parser.Parser;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import static java.lang.Math;
import java.util.concurrent.TimeUnit;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        action.moveToElement(mailnShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(text(),'ZIP Code')]")).click();
        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        String stateXpath = "//select[@id='tState']//option[@value='" + state + "']";
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath(stateXpath)).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")), zip));
        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        Actions action = new Actions(getDriver());
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        action.moveToElement(mailnShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']//a[contains(@href,'postcalc')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) throws InterruptedException {
        Map<String, String> option = new LinkedHashMap<>();
        option.put("Postcard", "option_1");
        option.put("Envelope","option_2");
        option.put("Box", "option_3");
        option.put("Other", "option_4");
        getDriver().findElement(By.xpath("//select[@id='CountryID']//option[(text()='"+ country +"')]")).click();
        getDriver().findElement(By.xpath("//input[@id='" + option.get(shape) + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String qty) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(qty);

    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//div[@id='continue-section']/input")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualToIgnoringCase(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String StringForSearch) throws InterruptedException {
        getDriver().manage().window().maximize();

        Actions action = new Actions(getDriver());
        WebElement Search = getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::a"));
        action.moveToElement(Search).perform();

        getDriver().findElement(By.xpath("//input[contains(@id,'track-search')]")).sendKeys(StringForSearch);
        getDriver().findElement(By.xpath("//input[contains(@id,'track-search')]")).sendKeys(Keys.RETURN);
        //getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[contains(@href, 'keyword=Free')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//a[@title='" + filter + "']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
        //Thread.sleep(3000);
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String qty) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText()).contains(qty);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        //a[@id='navhelp']/following-sibling::a
        getDriver().findElement(By.xpath("//a[text()='"+ tab +"']")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[@class='search-field-group']//input")).sendKeys("\"" + search + "\"");
        getDriver().findElement(By.xpath("//button[contains(@class,'search-button')]")).click();

    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String search) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'noResultsTitle')]")).isDisplayed()).isTrue();
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        Actions action = new Actions(getDriver());
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        action.moveToElement(mailnShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-find']//a")).click();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String Services, String availableServices) {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[@data-value='po']")).click();

        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//a[@data-value='pickup']")).click();

        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[@data-value='accountable']")).click();


    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);

        String XpathState = "//select[@id='servicesStateSelect']//option[@value ='" + state + "']";
        getDriver().findElement(By.xpath(XpathState)).click();
        getDriver().findElement(By.xpath("//div[contains(@class,'goto-results-btn')]/a")).click();

    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phone) {
        getDriver().findElement(By.xpath("//div[@id='resultBox']/div[1]")).click();
        assertThat(getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText()).contains(phone);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String selection) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='title_23']/span")));

        WebElement element = getDriver().findElement(By.xpath("//span[@id='title_23']/span"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//a[@class='button--primary']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        assertThat(getDriver().getTitle()).contains("Sign In");
    }

    @When("I do something")
    public void iDoSomething() {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        WebElement result = getDriver().findElement(By.xpath(""));
        wait.until(ExpectedConditions.textToBePresentInElement(result, "hello"));
        wait.until(driver -> result.getText().contains("hello"));
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String link, String tab) {
        Actions action = new Actions(getDriver());
        WebElement tabElement = getDriver().findElement(By.xpath("//a[text()='" + tab + "']"));
        WebElement linkElement = getDriver().findElement(By.xpath("//a[text()='" + link + "']"));
        action.moveToElement(tabElement).click(linkElement).perform();


    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[contains(@class, 'icon-search')]")).click();

    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String tab) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);

        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress'][not(@hidden)]"));
        wait.until(ExpectedConditions.attributeToBe(overlay, "class", "hide"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        // From Ozzy  (still unstable)
        //=======================================
        WebElement table = getDriver().findElement(By.xpath("//div[@id='route-table']"));
        wait.until(ExpectedConditions.visibilityOf(table));
        //========================================

        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//a[@class='route-table-toggle']")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String selectAll) {
        getDriver().findElement(By.xpath("//a[@class='totalsArea']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException {
        //====Tried to scroll down
            //getDriver().findElement(By.xpath("//div[@class='dojoxGridContent']"))
            //getDriver().manage().window().maximize();
            //WebElement element = getDriver().findElement(By.xpath("//div[@class='dojoxGridContent']"));
            //div[@class='dojoxGridContent']
            //div[@class='dojoxGridContent']/div[2]
            //((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", element);
            //Thread.sleep(3000);
        //==================================
        List<WebElement> rows = getDriver().findElements(By.xpath("//div[@class='dojoxGridScrollbox']//td[8]"));
        double ActualCost = 0;

        for(int i=0; i<rows.size();i++)
        {
            String s = rows.get(i).getText();
            ActualCost += Double.parseDouble(s.substring(s.lastIndexOf("$")+1));
        }

        double eps = 10;
        String ApproximateCost = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        assertThat(abs(Float.parseFloat(ApproximateCost) - ActualCost) < eps).isTrue();
    }
}
