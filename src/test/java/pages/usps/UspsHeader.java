package pages.usps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import static support.TestContext.JSExecutor;

public class UspsHeader extends Page {

    @FindBy(id = "mail-ship-width")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']/a")
    private WebElement lookUpByZip;

    @FindBy(xpath="//li[@class='tool-calc']/a[contains(@href,'post')]")
    private WebElement calculatePrice;

    public void goToLookUpByZip()
    {
        mouseOver(mailAndShip);
        //lookUpByZip.click();
        click(lookUpByZip);
    }

    public void goToCalculatePrice() {
        mouseOver(mailAndShip);
        click(calculatePrice);
    }




}
