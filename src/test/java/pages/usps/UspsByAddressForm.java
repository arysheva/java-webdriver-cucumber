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

    public UspsByAddressForm fillStreet(String streetValue)
    {

        street.sendKeys(streetValue);
        return this;
    }

    public UspsByAddressForm fillCity(String cityValue)
    {
        city.sendKeys(cityValue);
        return this;
    }

    public UspsByAddressResult clickFind()
    {

        find.click();
        return new UspsByAddressResult();
    }

    public UspsByAddressForm selectState(String stateValue)
    {
        new Select(state).selectByValue(stateValue);
        return this;

    }



}
