package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;



public class QuoteStepDefs {

    QuoteResult resultForm = new QuoteResult();
    QuoteForm form = new QuoteForm();


    @And("I fill out required fields for {string} opp")
    public void iFillOutRequiredFieldsFor(String role) throws InterruptedException {
        Map<String, String> user = getData(role);

        form.fillUserName(user.get("userName"));
        form.fillEmail(user.get("email"));
        form.fillPassword(user.get("password"));
        form.fillConfirmPassword(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.checkAgreePrivacyPolicy();

    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submitForm();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(resultForm.getEmail().equals(user.get("email"))).isTrue();
        assertThat(resultForm.getUsername()).isEqualTo(user.get("userName"));
        assertThat(resultForm.getFirstName()).isEqualTo(user.get("firstName"));
        assertThat(resultForm.getLastName()).isEqualTo(user.get("lastName"));
        assertThat(resultForm.getPassword()).isNotEqualTo(user.get("password"));
        assertThat(resultForm.getPassword()).isEqualTo("[entered]");
        assertThat(resultForm.isAgreeToPrivacyPolicy()).isTrue();

    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) throws InterruptedException {
        Map<String, String> user = getData(role);
        form.fillPhone(user.get("phone"));
        form.fillDateOfBirth(user.get("month"), user.get("date"), user.get("year"));
        form.fillContact(user.get("contactName"), user.get("contactPhone"));
        form.fillCountry(user.get("country"));
        form.fillGender(user.get("gender"));
        form.checkAllowedToContact();
        form.fillAddress(user.get("address"));
        form.fillCarMake(user.get("carMake"));
        form.agreedThirdParty();
    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(resultForm.getResult()).contains(user.get("contactName"));
        assertThat(resultForm.getResult()).contains(user.get("contactPhone"));
        assertThat(resultForm.getResult()).contains(user.get("country"));
        assertThat(resultForm.getResult()).contains(user.get("phone"));
        assertThat(resultForm.getResult()).contains(user.get("address"));
        assertThat(resultForm.getResult()).contains(user.get("carMake"));
        assertThat(resultForm.getResult()).contains(user.get("gender"));
        assertThat(resultForm.isAllowedToContact()).isTrue();

    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String errorField, String errorMessage) {

        String actualError = form.getErrorFiledText(errorField);
        assertThat(actualError).isEqualTo(errorMessage);

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorField) {

        assertThat(form.isFieldDisplayed(errorField)).isFalse();
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) throws InterruptedException {
        switch (field)
        {
            case "username":
                form.fillUserName(value);
                break;
            case "email":
                form.fillEmail(value);
                break;
            case "password":
                form.fillPassword(value);
                break;
            case "confirmPassword":
                form.fillConfirmPassword(value);
                break;

            default:
                throw new RuntimeException("Unknown field " + field);
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);

    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        switch (field)
        {
            case "name":
                assertThat(form.getValueName()).isEqualTo(value);
                break;

            default:
                throw new RuntimeException("Unknown field " + field);
        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }
}
