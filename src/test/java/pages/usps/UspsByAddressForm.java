package pages.usps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UspsByAddressForm extends UspsHeader{


    @FindBy(id = "tAddress")
    private WebElement street;

    @FindBy(id = "tCity")
    private WebElement city;

    @FindBy(id = "tState")
    private WebElement state;

    @FindBy(id = "zip-by-address")
    private WebElement find;

    public void fillStreet(String streetValue)
    {
        street.sendKeys(streetValue);
    }

    public void fillCity(String cityValue)
    {
        city.sendKeys(cityValue);
    }

    public void clickFind()
    {
        find.click();
    }

    public void selectState(String stateValue)
    {
        new Select(state).selectByValue(stateValue);

    }



}
