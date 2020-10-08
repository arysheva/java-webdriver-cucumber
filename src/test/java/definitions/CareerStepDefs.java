package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pages.careers.CareersLanding;
import pages.careers.CareersLogin;
import pages.careers.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareerStepDefs {

    CareersRecruit careersRecruit = new CareersRecruit();
    @And("I login as {string}")
    public void iLoginAs(String role) throws InterruptedException {
        Map<String, String> user = getData(role);
        new CareersLanding().clickLogin().login(user.get("username"), user.get("password"));
        Thread.sleep(3000);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {

        String expectedName = getData(role).get("name");
        String actualName = new CareersLanding().getLoggedUserName();
        assertThat(expectedName).isEqualTo(actualName);


    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) throws InterruptedException {
        new CareersLanding().ClickRecruit().removePosition(title);
        //Thread.sleep(2000);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) {
        new CareersRecruit().refresh();
        boolean isVisible = new CareersRecruit().isPositionVisible(title);
        boolean errorsPresent = new CareersRecruit().areErrorsPresent();
        assertThat(errorsPresent).isFalse();
        assertThat(isVisible).isFalse();
        //assertThat(careersRecruit.isPositionVisible(title)).isFalse();
    }
}
