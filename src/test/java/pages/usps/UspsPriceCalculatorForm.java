package pages.usps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;
import java.util.Map;

import static support.TestContext.getDriver;

public class UspsPriceCalculatorForm extends UspsHeader {

    @FindBy(id = "CountryID")
    private WebElement country;

    @FindBy(xpath = "//input[@placeholder='Quantity']")
    private WebElement quantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateBtn;

    @FindBy(id = "total")
    private WebElement totalPrice;


    public void selectCountry(String value)
    {
        new Select(country).selectByVisibleText(value);
    }



   private WebElement postShape(String shape)
   {
       Map<String, String> option = new LinkedHashMap<>();
       option.put("Postcard", "option_1");
       option.put("Envelope","option_2");
       option.put("Box", "option_3");
       option.put("Other", "option_4");
       return getDriver().findElement(By.xpath("//input[@id='" + option.get(shape) + "']"));
   }

   public void chosePostShape(String shape)
   {
       click(postShape(shape));
   }

    public void fillQuantity(String value)
    {
        quantity.sendKeys(value);
    }

    public void calculatePrice()
    {
        click(calculateBtn);
    }

    public String getTotalPrice()
    {
        return totalPrice.getText();
    }

}
