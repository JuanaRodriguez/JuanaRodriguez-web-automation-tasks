package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProjectPage extends BasePage{
    @FindBy(id = "edit_project_modal_field_name")
    @CacheLookup
    WebElement nameField;

    @FindBy(css = "button[type='submit']")
    @CacheLookup
    WebElement addButton;

    public AddProjectPage() {

        PageFactory.initElements(driver, this);
    }

    public AddProjectPage setProjectName(String projectName){
        nameField.sendKeys(projectName);
        return this;
    }

    public HomePage clickAddProjectButton(){
        addButton.click();
        return new HomePage();
    }

}
