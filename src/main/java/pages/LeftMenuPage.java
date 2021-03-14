package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenuPage extends BasePage {

    private By addButton = By.cssSelector("#list_holder > div.sidebar_expansion_panel.expansion_panel.expansion_panel--expanded > div.expansion_panel__header > div > button > svg");

    public LeftMenuPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage clickAddProjectButton() {
        driver.findElement(addButton).click();
        return new AddProjectPage(driver);
    }
}
