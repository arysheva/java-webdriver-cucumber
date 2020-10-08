package pages.careers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CareersLogin extends CareersHeader {

    @FindBy(xpath = "//label[@for='loginUsername']/following-sibling::input")
    private WebElement username;
    @FindBy(xpath = "//label[@for='loginPassword']/following-sibling::input")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginBtn;

    public CareersLanding login(String usernameValue, String passwordValue)
    {
        fillElement(username, usernameValue);
        fillElement(password, passwordValue);
        click(loginBtn);
        return new CareersLanding();
    }


}
