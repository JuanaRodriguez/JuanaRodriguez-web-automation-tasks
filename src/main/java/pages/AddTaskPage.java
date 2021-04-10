package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage extends BasePage {

    @FindBy(css = ".public-DraftStyleDefault-block")
    @CacheLookup
    WebElement nameField;

    @FindBy(css = ".ist_button")
    @CacheLookup
    WebElement addTaskButton;

    public AddTaskPage() {
        PageFactory.initElements(driver, this);
    }

    public AddTaskPage setTaskName(String taskName) {
        nameField.sendKeys(taskName);
        return this;
    }

    public HomePage clickAddTaskButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addTaskButton.click();
        return new HomePage();
    }
}
