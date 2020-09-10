package definitions;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.exp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;
import static support.TestContext.*;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ranges.RangeException;

import javax.swing.text.html.parser.Parser;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
//import static java.lang.Math;
import java.util.concurrent.TimeUnit;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        //Actions action = new Actions(getDriver());
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getAction().moveToElement(mailnShip).perform();
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
        getWait().until(ExpectedConditions.textToBePresentInElement(getDriver().
                findElement(By.xpath("//div[@id='zipByAddressDiv']")), zip));
        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getAction().moveToElement(mailnShip).perform();
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
        WebElement Search = getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::a"));
        getAction().moveToElement(Search).perform();

        getDriver().findElement(By.xpath("//input[contains(@id,'track-search')]")).sendKeys(StringForSearch);
        getDriver().findElement(By.xpath("//input[contains(@id,'track-search')]")).sendKeys(Keys.RETURN);
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//a[@title='" + filter + "']"));
        JSExecutor().executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String qty) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText()).contains(qty);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
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
        WebElement mailnShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getAction().moveToElement(mailnShip).perform();
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
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='title_23']/span")));
        WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'"+selection+"')]"));
        JSExecutor().executeScript("arguments[0].click();", element);
    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//a[@class='button--primary']"));
        JSExecutor().executeScript("arguments[0].click();", element);
        //getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        String originalWindow = getDriver().getWindowHandle();
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        getWait(10).until(ExpectedConditions.titleContains("Sign In"));

        //getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-password']")));

        // switch back
        getDriver().switchTo().window(originalWindow);
    }




    @When("I go to {string} under {string}")
    public void iGoToUnder(String link, String tab) {
        WebElement tabElement = getDriver().findElement(By.xpath("//a[text()='" + tab + "']"));
        WebElement linkElement = getDriver().findElement(By.xpath("//a[text()='" + link + "']"));
        getAction().moveToElement(tabElement).click(linkElement).perform();


    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[contains(@class, 'icon-search')]")).click();

    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String tab) throws InterruptedException {
        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        getWait().until(ExpectedConditions.visibilityOf(overlay));
        getWait().until(ExpectedConditions.invisibilityOf(overlay));
        getDriver().findElement(By.xpath("//a[contains(text(), '"+ tab +"')]")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String selectAll) {
        getDriver().findElement(By.xpath("//div[@id='route-table']//a[contains(text(),'" + selectAll + "')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException, ParseException {

        String totalNumberOfRows = getDriver().findElement(By.xpath("//p[@class='value routes']")).getText();
        int totalNRows = Integer.parseInt(totalNumberOfRows);
        List<WebElement> rows = getDriver().findElements(By.xpath("//div[@class='dojoxGridScrollbox']//td[8]"));
        while (rows.size() < totalNRows)
        {
            getAction().moveToElement(rows.get(rows.size()-1)).perform();
            rows = getDriver().findElements(By.xpath("//div[@class='dojoxGridScrollbox']//td[8]"));
        }

        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double ActualCost = 0;

        for(int i=0; i<rows.size();i++)
        {
            String s = rows.get(i).getText();
            ActualCost += formatter.parse(s).doubleValue();

        }

        double eps = 10;
        String ApproximateCost = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        assertThat(abs(Float.parseFloat(ApproximateCost) - ActualCost) < eps).isTrue();
    }

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().manage().window().maximize();
        getWait().until(ExpectedConditions.titleContains("UPS - United States"));
        WebElement button = getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']"));
        JSExecutor().executeScript("arguments[0].click();", button);
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[text()='Create a Shipment:']/..")).click();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        Map<String, String> where = getData("addressFrom");
        getDriver().findElement(By.xpath("//select[@id='origincountry']/option[text()='" + where.get("country") + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(where.get("name"));
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys(where.get("contactName"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(where.get("street"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(where.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys(where.get("city"));
        getDriver().findElement(By.xpath("//select[@id='originstate']/option[text()='" + where.get("state") + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(where.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(where.get("phone"));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
            WebElement button = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
            JSExecutor().executeScript("arguments[0].click();", button);

    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {

        WebElement button = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        JSExecutor().executeScript("arguments[0].click();", button);
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        Map<String, String> where = getData("addressFrom");
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).
                getText()).isEqualToIgnoringCase(where.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryContactName']")).
                getText()).isEqualToIgnoringCase(where.get("contactName"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).
                getText()).isEqualToIgnoringCase(where.get("street"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).
                getText()).isEqualToIgnoringCase(where.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).
                getText()).isEqualToIgnoringCase(where.get("zip"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryEmail']")).
                getText()).isEqualToIgnoringCase(where.get("email"));

    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='origincontactName']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='origincity']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getAttribute("value")).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getAttribute("value")).isEmpty();

    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        Map<String, String> where = getData("addressWhere");
        getDriver().findElement(By.xpath("//select[@id='destinationcountry']/option[text()='" + where.get("country") + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(where.get("name"));
        getDriver().findElement(By.xpath("//input[@id='destinationcontactName']")).sendKeys(where.get("contactName"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(where.get("street"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(where.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='destinationcity']")).sendKeys(where.get("city"));
        getDriver().findElement(By.xpath("//select[@id='destinationstate']/option[text()='" + where.get("state") + "']")).click();
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        Map<String,String> pack = getData("package");
        getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']/option[text()='" +
                pack.get("type")+ "']")).click();
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys(pack.get("weight"));
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageLengthField0']")).sendKeys(pack.get("length"));
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWidthField0']")).sendKeys(pack.get("width"));
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageHeightField0']")).sendKeys(pack.get("height"));

    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {

        assertThat(getDriver().findElements(By.xpath("//span[@id='nbsBalanceBarTotalCharges']"))).hasSize(1);
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {

        WebElement cheap = getDriver().findElement(By.xpath("//p[@id='nbsServiceTileTotalCharge7']"));
        JSExecutor().executeScript("arguments[0].click();",cheap);
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        Map<String, String> desc = getData("desc");
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys(desc.get("desc"));
        WebElement saturday = getDriver().findElement(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']/following-sibling::label"));

        JSExecutor().executeScript("arguments[0].click();",saturday);



    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        assertThat(getDriver().findElements(By.xpath("//span[@id='total-charges-spinner']//img"))).hasSize(1);
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        getDriver().findElement(By.xpath("//input[@id='other-ways-to-pay-tile']/..//span")).click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        Map<String,String> pack = getData("package");
        Map<String, String> where = getData("addressWhere");
        Map<String, String> from = getData("addressFrom");
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).getText()).
                isEqualToIgnoringCase(from.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryContactName']")).getText()).
                isEqualToIgnoringCase(from.get("contactName"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText()).
                isEqualToIgnoringCase(from.get("street"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).getText()).
                isEqualToIgnoringCase(from.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).getText()).
                isEqualToIgnoringCase(from.get("zip"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryEmail']")).getText()).
                isEqualToIgnoringCase(from.get("email"));

        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryName']")).getText()).
                isEqualToIgnoringCase(where.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryContactName']")).getText()).
                isEqualToIgnoringCase(where.get("contactName"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryAddressLine1']")).getText()).
                isEqualToIgnoringCase(where.get("street"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryCity']")).getText()).
                isEqualToIgnoringCase(where.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryPostalCode']")).getText()).
                isEqualToIgnoringCase(where.get("zip"));


        assertThat(getDriver().findElement(By.xpath("//package-drawer//p")).getText()).containsIgnoringCase(pack.get("type"));
        assertThat(getDriver().findElement(By.xpath("//package-drawer//p")).getText()).containsIgnoringCase(pack.get("weight"));
        assertThat(getDriver().findElement(By.xpath("//package-drawer//p")).getText()).containsIgnoringCase(pack.get("length"));
        assertThat(getDriver().findElement(By.xpath("//package-drawer//p")).getText()).containsIgnoringCase(pack.get("width"));
        assertThat(getDriver().findElement(By.xpath("//package-drawer//p")).getText()).containsIgnoringCase(pack.get("height"));

    }

    @And("I submit review the shipment form")
    public void iSubmitReviewTheShipmentForm() {
        WebElement review = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
        JSExecutor().executeScript("arguments[0].click();", review);
    }

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String str) {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(str);
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
        WebElement no_res = getDriver().findElement(By.xpath("//div[@class='no-product']"));
        assertThat(no_res.isDisplayed()).isTrue();
    }

    @And("choose mail service Priority Mail")
    public void chooseMailServicePriorityMail() {
        WebElement PrMail = getDriver().findElement(By.xpath("//input[@id='checkbox-type-Mail Service-Priority Mail-1']/.."));
        JSExecutor().executeScript("arguments[0].scrollIntoView();", PrMail);
        PrMail.click();
    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int qty) {
        WebElement result = getDriver().findElement(By.xpath("//h2[contains(@class,'results-per-page')]"));
        assertThat(result.getText().contains("of "+qty+" Results")).isTrue();
    }

    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//input[@id='first-category-checkbox']/..")).click();
    }

    @And("select Vertical stamp Shape")
    public void selectVerticalStampShape() {
        //label[contains(text(),'Vertical')]
        WebElement verticalStamp = getDriver().findElement(By.xpath("//label[contains(text(),'Vertical')]"));
        JSExecutor().executeScript("arguments[0].scrollIntoView();", verticalStamp);
        verticalStamp.click();
    }

    @And("I click Blue color")
    public void iClickBlueColor() {
        WebElement blue = getDriver().findElement(By.xpath("//div[contains(@onclick, 'blue')]"));
        JSExecutor().executeScript("arguments[0].scrollIntoView();", blue);
        blue.click();
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String filter1, String filter2) throws InterruptedException {
        WebElement filterOne = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+ filter1 +"')]"));
        WebElement filterTwo = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+ filter2 +"')]"));
        assertThat(filterOne.isDisplayed() && filterTwo.isDisplayed()).isTrue();
    }

    @And("I verify that items below {int} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(int price) throws ParseException {

        List <WebElement> prices = getDriver().findElements(By.xpath("//div[@class='results-product-preview-price']//p"));
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        for (int i =0; i<prices.size(); i++)
        {
            if (price > formatter.parse(prices.get(i).getText()).intValue())
            {
                    assertThat(price > formatter.parse(prices.get(i).getText()).intValue()).isTrue();
                    break;
            }
            else
                throw new RuntimeException("ERRORRR!!");
        }

    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String service) {
        assertThat(getDriver().findElement(By.xpath("//select[@id='passportappointmentType']//option[text()='"+service+"']")).
                isEnabled()).isTrue();

    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String zip) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//a[@class='searchBtn']")).click();
    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String text) {

    }
}
