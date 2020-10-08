package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Level;

import static support.TestContext.*;
import static support.TestContext.getWait;

public class Page {
    protected String url;
    protected String title;

    public Page() {
        PageFactory.initElements(getDriver(), this);

    }
    public void open()
    {
        getDriver().get(url);
    }

    protected void mouseOver(WebElement element)
    {

        getAction().moveToElement(element).perform();
    }


    protected void waitElementVisible(WebElement element)
    {

        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitElementClickable(WebElement element)
    {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitForContainText(WebElement element)
    {

        getWait().until(driver -> !element.getText().isEmpty());
    }

    protected void clickWithJS(WebElement element)
    {

        JSExecutor().executeScript("arguments[0].click();", element);
    }

    protected void fillElement(WebElement element, String value)
    {
        waitElementVisible(element);
        element.sendKeys(value);
    }

    protected void waitToBeSelected(WebElement element)
    {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void click(WebElement element)
    {
        waitElementClickable(element);
        //element.click();

        try{
            element.click();
        }catch(ElementClickInterceptedException e)
        {
            clickWithJS(element);
        }
    }

    protected WebElement getByXpath(String xpath)
    {
        return getDriver().findElement(By.xpath(xpath));
    }

    public void refresh()
    {
        getDriver().navigate().refresh();
    }

    public boolean areErrorsPresent()
    {
        LogEntries entries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry: entries)
        {
            if(entry.getLevel().equals(Level.SEVERE))
            {
                System.err.println(entry);
                return true;
            }
        }
        return false;
    }

    protected List<WebElement> getAllByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }
}
