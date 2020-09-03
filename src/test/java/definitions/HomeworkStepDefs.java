package definitions;
import static java.lang.Math.abs;
import static support.TestContext.getDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
public class HomeworkStepDefs {
    @When("I click on {string}")
    public void iClickOn(String tab) {
        getDriver().findElement(By.xpath("//a[text()='" + tab + "']")).click();
    }

    @And("I set from {string} to {string}")
    public void iSetFromTo(String from, String to) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[text()='" + from + "']")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[text()='" + to + "']")).click();
    }

    @Then("I set {string} value and verify that result is {string}")
    public void iSetValueAndVerifyThatResultIs(String value, String result) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
        String actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        double eps = 1;
        assertThat(abs(Float.parseFloat(result) - Float.parseFloat(actualResult))<eps).isTrue();
//        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
//        String actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
//        assertThat(Float.parseFloat(actualResult)).isCloseTo(Float.parseFloat(result), Percentage.withPercentage(10));

    }

    @When("I navigate to {string}")
    public void iNavigateTo(String calcType) {
        getDriver().findElement(By.xpath("//a[text()='" + calcType + "']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorMsg) {
        assertThat(getDriver().findElement(By.xpath("//font[text()='" + errorMsg + "']")) != null);
    }

    @And("I enter {string} price, {string} months, {string} interest" +
            ", {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String amount, String term,
                                                                               String interest, String downPayment,
                                                                               String tradeIn, String state,
                                                                               String percentTax, String fee) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(amount);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(term);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downPayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//select[@name='cstate']//option[text()='" + state + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fee);

    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthlyPay) {
        String result = "Monthly Pay:   " + monthlyPay;
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText()).isEqualTo(result);
    }
}
