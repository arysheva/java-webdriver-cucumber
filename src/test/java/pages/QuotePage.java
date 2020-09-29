package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuotePage {
    protected String url;
    protected String title;

    public QuotePage() {
        PageFactory.initElements(getDriver(), this);

    }
    public void open()
    {
        getDriver().get(url);
    }
}
