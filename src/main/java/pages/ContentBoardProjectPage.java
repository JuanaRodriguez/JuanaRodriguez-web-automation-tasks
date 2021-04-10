package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentBoardProjectPage extends BasePage {

    @FindBy(css = "#editor > div.project_view.project_editor_instance.current_editor > div > div > div > form > input")
    @CacheLookup
    WebElement sectionField;

    @FindBy(css = ".section_head_menu")
    @CacheLookup
    WebElement expandMenuSection;

    @FindBy(css = "li.menu_item:nth-child(1) > div")
    @CacheLookup
    WebElement editMenuButton;

    @FindBy(css = "li.menu_item:nth-child(5) > div")
    @CacheLookup
    WebElement deleteMenuSection;

    @FindBy(css = ".icon_add > svg")
    @CacheLookup
    WebElement addTaskIcon;

    @FindBy(css = ".markdown_content")
    @CacheLookup
    WebElement expandMenuTask;

    @FindBy(css = "body > div.popper__overlay > div:nth-child(3) > div > ul > li:nth-child(1) > div.icon_menu_item__content")
    @CacheLookup
    WebElement editMenuTask;

    @FindBy(css = ".menu_list.item_menu_list > .menu_item.icon_menu_item.danger_menu")
    @CacheLookup
    WebElement deleteMenuTask;

    @FindBy(css = ".editable > span")
    @CacheLookup
    WebElement nameProject;

    Actions actions = new Actions(driver);

    @FindBy(css = "button.ist_button:nth-child(1)")
    @CacheLookup
    WebElement confirmationDeleteSection;

    public ContentBoardProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public AddSectionPage clickSectionField() {
        sectionField.click();
        return new AddSectionPage();
    }

    public DeleteSectionPage clickConfirmationDeleteSection() {
        confirmationDeleteSection.click();
        return new DeleteSectionPage();
    }

    public EditSectionPage expandMenuSection() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        expandMenuSection.click();
        return new EditSectionPage();
    }

    public DeleteSectionPage expandMenuSections() {
        expandMenuSection.click();
        return new DeleteSectionPage();
    }

    public EditSectionPage clickEditMenuSection() {
        editMenuButton.click();
        return new EditSectionPage();
    }

    public DeleteSectionPage clickDeleteMenuSection() {
        deleteMenuSection.click();
        return new DeleteSectionPage();
    }

    public AddTaskPage clickAddTaskIcon() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addTaskIcon.click();
        return new AddTaskPage();
    }

    public EditTaskPage expandMenuTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.contextClick(expandMenuTask).build().perform();
        return new EditTaskPage();
    }

    public EditTaskPage clickEditMenuTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        editMenuTask.click();
        return new EditTaskPage();
    }

    public DeleteTaskPage expandMenuTasks() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.contextClick(expandMenuTask).build().perform();
        return new DeleteTaskPage();
    }

    public DeleteTaskPage clickDeleteMenuTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteMenuTask.click();
        return new DeleteTaskPage();
    }

    public EditProjectPage clickNameProject() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nameProject.click();
        return new EditProjectPage();
    }
}
