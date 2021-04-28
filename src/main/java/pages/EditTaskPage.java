package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTaskPage extends BasePage {

    @FindBy(css = "#editor > div.project_view.project_editor_instance.current_editor > div > div > section > div > div > form > div.task_editor__editing_area > div.task_editor__input_fields > div > div > div > div > div > div > div > div")
    @CacheLookup
    WebElement editTaskField;

    @FindBy(css = ".ist_button")
    @CacheLookup
    WebElement saveTaskButton;

    public EditTaskPage() {
        PageFactory.initElements(driver, this);
    }

    public EditTaskPage editTaskName(String editTaskName) {
        editTaskField.sendKeys(editTaskName);
        return this;
    }

    public HomePage clickSaveTaskButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveTaskButton.click();
        return new HomePage();
    }
}
