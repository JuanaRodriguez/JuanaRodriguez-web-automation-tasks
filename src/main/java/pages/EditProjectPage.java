package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProjectPage extends BasePage{

    @FindBy(css = ".view_header__input")
    @CacheLookup
    WebElement editProjectField;

    @FindBy(css = ".view_header__input_actions > .ist_button.ist_button_red")
    @CacheLookup
    WebElement saveButton;

    public EditProjectPage(){
        PageFactory.initElements(driver, this);
    }

    public EditProjectPage setProjectName(String editProjectName){
        editProjectField.click();
        editProjectField.clear();
        editProjectField.sendKeys(editProjectName);
        return this;
    }

    public HomePage clickSaveButton(){
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveButton.click();
        return  new HomePage();
    }
}
