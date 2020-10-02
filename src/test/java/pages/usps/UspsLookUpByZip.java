package pages.usps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class UspsLookUpByZip extends UspsHeader {


    @FindBy(xpath = "//p[@class='column-one-text']/following-sibling::a")
    private WebElement findByAddress;

    public void clickFindByAddress()
    {
        findByAddress.click();
    }
}
