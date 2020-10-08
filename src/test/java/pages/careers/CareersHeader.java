package pages.careers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CareersHeader extends Page {

    @FindBy(xpath = "//a[@href = '/login']/button")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/recruit']/button")
    private WebElement recruitButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    public CareersLogin clickLogin()
    {

        //loginButton.click();
        click(loginButton);
        return new CareersLogin();
    }

    public CareersRecruit ClickRecruit()
    {
        click(recruitButton);
        return new CareersRecruit();
    }



    public String getLoggedUserName()
    {
        return loggedUserName.getText();
    }
}
