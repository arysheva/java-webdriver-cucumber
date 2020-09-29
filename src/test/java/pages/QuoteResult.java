package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult extends QuotePage{

    @FindBy(id = "quotePageResult")
    private WebElement result;

    @FindBy(name = "username")
    private WebElement resultUserName;

    @FindBy(name = "email")
    private WebElement resultEmail;

    @FindBy(name = "firstName")
    private WebElement resultFirstName;

    @FindBy(name = "lastName")
    private WebElement resultLastName;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement resultPass;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacy;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;

    public String getUsername()
    {
        return resultUserName.getText();
    }

    public String getEmail()
    {
        return resultEmail.getText();
    }

    public String getFirstName()
    {
        return resultFirstName.getText();
    }

    public String getLastName()
    {
        return resultLastName.getText();
    }

    public String getPassword()
    {
        return resultPass.getText();
    }

    public boolean isAgreeToPrivacyPolicy()
    {
        return Boolean.parseBoolean(privacy.getText()); //privacy.getText().equals("true");
    }

    public boolean isAllowedToContact()
    {
        return Boolean.parseBoolean(allowedToContact.getText());
    }
    public String getResult()
    {
        return result.getText();
    }
}