package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPage extends BasePage {

    @FindBy(css = "#list_holder > div.sidebar_expansion_panel.expansion_panel.expansion_panel--expanded > div.expansion_panel__header > div > button > svg")
    @CacheLookup
    WebElement addButton;

    @FindBy(css = "#projects_list > li:nth-child(2) > table > tbody > tr > td.menu")
    @CacheLookup
    WebElement deleteMenuProject;

    @FindBy(css = "tr.project_inbox_action:nth-child(13) > td:nth-child(1) > div")
    @CacheLookup
    WebElement deleteMenuProjectTwo;

    public LeftMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectPage clickAddProjectButton() {
        addButton.click();
        return new AddProjectPage();
    }

    public DeleteProjectPage clickDeleteMenuProject() {
        deleteMenuProject.click();
        return new DeleteProjectPage();
    }

    public DeleteProjectPage clickDeleteMenuProjectTwo() {
        deleteMenuProjectTwo.click();
        return new DeleteProjectPage();
    }
}
