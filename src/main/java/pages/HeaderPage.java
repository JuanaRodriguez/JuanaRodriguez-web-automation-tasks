package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {
    @FindBy(css = "button[aria-label='Settings']")
    @CacheLookup
    WebElement settings;

    public HeaderPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isSettingDisplayed(){
        return  settings.isDisplayed();
    }
}
