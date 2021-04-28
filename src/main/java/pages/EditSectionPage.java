package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditSectionPage extends BasePage {

    public EditSectionPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.name")
    @CacheLookup
    WebElement editSectionField;

    @FindBy(css = ".ist_button")
    @CacheLookup
    WebElement saveSectionButton;

    public EditSectionPage editSectionName(String editSectionName) {
        editSectionField.clear();
        editSectionField.sendKeys(editSectionName);
        return this;
    }

    public HomePage clickSaveSectionButton() {
        saveSectionButton.click();
        return new HomePage();
    }
}
