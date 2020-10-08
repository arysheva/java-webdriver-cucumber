package definitions;

import cucumber.api.java.en.Given;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {
    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        Map<String, String> user = getData("admin");
        new RestClient().login(user);

    }
}
