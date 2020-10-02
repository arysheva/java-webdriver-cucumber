package pages.careers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CareersLanding extends Page {

    public CareersLanding()
    {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//a[@href = '/login']/button")
    private WebElement loginButton;


    public void clickLogin()
    {
        loginButton.click();
    }
}
