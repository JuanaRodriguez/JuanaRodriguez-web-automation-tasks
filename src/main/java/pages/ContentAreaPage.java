package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContentAreaPage extends BasePage {
    private String projectName = "#editor > div.project_view.project_editor_instance.current_editor > header > div > h1 > span";
    private String addTask = ".plus_add_button";
    private String sectionNames = ".board_section__title";
    private String addSectionButton = "#editor > div.project_view.project_editor_instance.current_editor > div > div > div > button > span";
    private String addEmptySection = "#editor > div.project_view.project_editor_instance.current_editor > div > div > div > form > input";
    private String cancelButton = ".cancel_link, .cancel";
    private String addTaskField = ".markdown_content";
    private String taskNames = ".DraftEditor-root";
    private String countTask = ".board_section__task_count";

    public ContentAreaPage() {
        PageFactory.initElements(driver, this);
    }

    public String getProjectName() {
        return driver.findElement(By.cssSelector(projectName)).getText();
    }

    public String getAddTaskText() {
        return driver.findElement(By.cssSelector(addTask)).getText();
    }

    public boolean isProjectNameDisplayed(String name) {
        By project = By.cssSelector(String.format(projectName, name));
        return driver.findElement(project).isDisplayed();
    }

    public boolean sectionIsDisplayed(String sectionName) {
        By sectionNameAdded = By.cssSelector(String.format(sectionNames, sectionName));
        return driver.findElement(sectionNameAdded).isDisplayed();
    }

    public String getSectionName() {
        System.out.println(driver.findElement(By.cssSelector(sectionNames)).getText());
        return driver.findElement(By.cssSelector(sectionNames)).getText();
    }

    public String getAddSectionText() {
        return driver.findElement(By.cssSelector(addSectionButton)).getText();
    }

    public boolean isSectionDeleted(String sectionName) {
        By sectionBy = By.cssSelector(String.format(sectionNames, sectionName));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(sectionBy));
        return driver.findElements(sectionBy).size() == 0;
    }

    public boolean cancelButtonIsDisplayed(String sectionName) {
        By cancelSectionButton = By.cssSelector(String.format(cancelButton, sectionName));
        return driver.findElement(cancelSectionButton).isDisplayed();
    }

    public String getAddEmptySection() {
        return driver.findElement(By.cssSelector(addEmptySection)).getText();
    }

    public String getAddTask() {
        return driver.findElement(By.cssSelector(addTaskField)).getText();
    }

    public boolean isTaskDeleted(String taskName) {
        By taskBy = By.cssSelector(String.format(taskNames, taskName));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(taskBy));
        return driver.findElements(taskBy).size() == 0;
    }

    public String getCountTask() {
        return driver.findElement(By.cssSelector(countTask)).getText();
    }
}
