package pages.usps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getWait;

public class UspsByAddressResult extends UspsHeader {

    @FindBy(id = "zipByAddressDiv")
    private WebElement result;

    @FindBy(xpath = "//*[@class='zipcode-result-address']")
    private List<WebElement> resultElements;

    public String getResultText()
    {
        waitForContainText(result);
        return result.getText();
    }

    public boolean allResultElementsContain(String zip)
    {
        for(int i=0; i<resultElements.size(); i++)
        {
            if (!resultElements.get(i).getText().contains(zip))
            {
                return false;
            }
        }
    return true;
    }
}
