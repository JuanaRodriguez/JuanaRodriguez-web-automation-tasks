package pages;

import org.openqa.selenium.By;

public class ContentAreaPage extends BasePage{

    private String projectName = "#editor > div.project_view.project_editor_instance.current_editor > header > div > h1 > span";
    private String addTask = ".plus_add_button";

    public String getProjectName() {
        return driver.findElement(By.cssSelector(projectName)).getText();
    }

    public String getAddTaskText() {
        return driver.findElement(By.cssSelector(addTask)).getText();
    }
    public boolean isProjectNameDisplayed(String name){
        By project = By.cssSelector(String.format(projectName, name));
        return driver.findElement(project).isDisplayed();
    }


}
