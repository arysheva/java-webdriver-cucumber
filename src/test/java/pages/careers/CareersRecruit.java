package pages.careers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getWait;

public class CareersRecruit extends CareersHeader {

    private WebElement closeIconForPosition(String title)
    {
        return getByXpath("//h4[(text()='"+ title +"')]/ancestor::div[contains(@class,'card')]//button");
    }

    private WebElement positionCard(String title)
    {
        return getByXpath("//h4[(text()='"+ title +"')]/ancestor::div[contains(@class,'card')]");
    }

    private List<WebElement> allPositionCards(String title) {
        return getAllByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    public boolean isPositionVisible(String title) {
//    List<WebElement> cards = allPositionCards(title);
//        if (cards.isEmpty()) {
//            return false;
//        } else {
//            return cards.get(0).isDisplayed();
//        }
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public CareersRecruit removePosition(String title)
    {
        WebElement card = positionCard(title);
        WebElement closeButton = closeIconForPosition(title);
        mouseOver(card);
        waitElementClickable(closeButton);
        //mouseOver(closeButton);
        click(closeButton);
        getWait().until(ExpectedConditions.invisibilityOf(card));
        return new CareersRecruit();
    }
}

