package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSectionPage extends BasePage {
    @FindBy(css = "#editor > div.project_view.project_editor_instance.current_editor > div > div > div > form > input")
    @CacheLookup
    WebElement nameField;

    @FindBy(css = ".ist_button")
    @CacheLookup
    WebElement addSectionButton;


    public AddSectionPage() {
        PageFactory.initElements(driver, this);
    }

    public AddSectionPage setSectionName(String sectionName) {
        nameField.sendKeys(sectionName);
        return this;
    }

    public HomePage clickAddSectionButton() {
        addSectionButton.click();
        return new HomePage();
    }
}
