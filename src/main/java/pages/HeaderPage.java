package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    private By settings = By.cssSelector("button[aria-label='Settings']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSettingDisplayed() {
        return driver.findElement(settings).isDisplayed();
    }
}
