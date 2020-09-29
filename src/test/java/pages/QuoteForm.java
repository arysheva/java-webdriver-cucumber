package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm extends QuotePage {

    public QuoteForm() {
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }


    ///////////////////////////
    //    Required fields    //
    ///////////////////////////

    @FindBy(xpath = "//input[@name = 'username']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacyPolicy;

    @FindBy(name = "formSubmit")
    private WebElement submit;

    @FindBy(id = "middleName")
    private WebElement middleName;

    ///////////////////////////
    //    Optional fields    //
    ///////////////////////////

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(id = "dateOfBirth")
    private WebElement dateBirth;

    @FindBy(xpath = "//input[@value='male']")
    private WebElement radioMale;

    @FindBy(xpath = "//input[@value='female']")
    private WebElement radioFemale;

    @FindBy(name = "allowedToContact")
    private WebElement allowedToContact;

    @FindBy(name = "address")
    private WebElement address;

    @FindBy(xpath = "//select[@name='carMake']/option[@value='Ford']")
    private WebElement fordElement;
    @FindBy(xpath = "//select[@name='carMake']/option[@value='Toyota']")
    private WebElement toyotaElement;
    @FindBy(xpath = "//select[@name='carMake']/option[@value='BMW']")
    private WebElement BMWElement;
    @FindBy(xpath = "//select[@name='carMake']/option[@value='Other']")
    private WebElement OtherCarElement;

    @FindBy(id = "thirdPartyButton")
    private WebElement thirdParty;

    /////////////////
    //    iform    //
    /////////////////

    @FindBy(id = "contactPersonName")
    private WebElement contactName;

    @FindBy(id = "contactPersonPhone")
    private WebElement contactPhone;

    @FindBy(name = "additionalInfo")
    private WebElement addInfoFrame;

    //////////////////////////
    //    dynamic fields    //
    //////////////////////////

    private WebElement errorElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName + "-error"));
    }

    private WebElement countryField(String country)
    {
        return getDriver().findElement(By.xpath("//option[text()='"+ country +"']"));
    }

    //Date of Birth
    private WebElement dayOfBirth(String dayValue)
    {
        return getDriver().findElement(By.xpath("//a[text()='"+ dayValue +"']"));
    }

    private WebElement monthOfBirth(String monthValue)
    {
        return getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']/option[text()='" + monthValue + "']"));
    }

    private WebElement yearOfBirth(String yearValue)
    {
        return getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='" + yearValue + "']"));
    }


    ///////////////////
    //    methods    //
    ///////////////////

    public void fillCountry(String country)
    {
        countryField(country).click();
    }

    public void fillCarMake(String carMakeValue)
    {
        switch(carMakeValue)
        {
            case "Ford":
                fordElement.click();
                break;
            case "Toyota":
                toyotaElement.click();
                break;
            case "BMW":
                BMWElement.click();
                break;
            case "Other":
                OtherCarElement.click();
                break;
            default:
                throw new RuntimeException("Unknown car make " + carMakeValue);


        }
    }



    public String getErrorFiledText(String fieldName)
    {
        return errorElement(fieldName).getText();
    }

    public boolean isFieldDisplayed(String filedName)
    {
        boolean isDisplayed = false;
        try {
            isDisplayed = errorElement(filedName).isDisplayed();
        }
        catch (NoSuchElementException e)
        {

        }

        return isDisplayed;
    }

    public void fillContact(String nameValue, String phoneValue)
    {
        getDriver().switchTo().frame(addInfoFrame);
        contactName.sendKeys(nameValue);
        contactPhone.sendKeys(phoneValue);
        //switch back
        getDriver().switchTo().defaultContent();
    }

    public void fillUserName (String value)
    {
        username.sendKeys(value);
    }

    public void fillGender(String gender)
    {
        if (gender.equalsIgnoreCase("male"))
        {
            radioMale.click();
        }
        else if (gender.equalsIgnoreCase("female"))
        {
            radioFemale.click();
        }
        else
        {
            throw new RuntimeException ("Unknown gender " + gender);
        }
    }

    public void fillEmail (String value)
    {
        email.clear();
        email.sendKeys(value);
    }

    public void fillPassword (String value)
    {
        password.clear();
        password.sendKeys(value);
    }
    public void fillConfirmPassword (String value)
    {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillAddress(String addressValue)
    {
        address.sendKeys(addressValue);
    }

    public void fillName(String firstNameValue, String lastNameValue)
    {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();
        String nameValue = name.getAttribute("value");
        //assertThat(nameValue).isEqualTo(firstNameValue + " " + lastNameValue);
        assertThat(nameValue).isEqualTo(String.format("%s %s", firstNameValue, lastNameValue));
    }

    public String getValueName()
    {
        return name.getAttribute("value");
    }

    public void fillName(String firstNameValue, String midNameValue, String lastNameValue)
    {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(midNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();

        String nameValue = name.getAttribute("value");
        //assertThat(nameValue).isEqualTo(firstNameValue + " " + midNameValue + " " + lastNameValue);
        assertThat(nameValue).isEqualTo(String.format("%s %s %s", firstNameValue, midNameValue ,lastNameValue));
    }

    public void checkAgreePrivacyPolicy()
    {
        if (!privacyPolicy.isSelected())
            privacyPolicy.click();
    }

    public void checkAllowedToContact()
    {
        if(!allowedToContact.isSelected())
            allowedToContact.click();
    }

    public void submitForm () { submit.click(); }

    public void fillPhone(String value)
    {
        phone.sendKeys(value);
    }

    public void agreedThirdParty()
    {
        thirdParty.click();
        getDriver().switchTo().alert().accept();
    }

    public void fillDateOfBirth(String monthValue, String dayValue,String yearValue)
    {
        dateBirth.click();
        monthOfBirth(monthValue).click();
        yearOfBirth(yearValue).click();
        dayOfBirth(dayValue).click();
    }



}
