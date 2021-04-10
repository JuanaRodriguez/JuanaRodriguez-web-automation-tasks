package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftMenuPage extends BasePage {

    @FindBy(css = "#list_holder > div.sidebar_expansion_panel.expansion_panel.expansion_panel--expanded > div.expansion_panel__header > div > button > svg")
    @CacheLookup
    WebElement addButton;

    @FindBy(css = "#projects_list > li.clickable.menu_clickable.indent_1.current > table > tbody > tr > td.name > span")
    @CacheLookup
    WebElement menuProject;

    @FindBy(css = "#menu_delete_text")
    @CacheLookup
    WebElement deleteMenuProject;

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div[3]/div/form/footer/button[1]")
    @CacheLookup
    WebElement confirmationDeleteProject;

    private String archivedProjects = "#show_archived_link";
    String project = "//ul[@id='projects_list']//span[text()='%s']";

    public LeftMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectPage clickAddProjectButton() {
        addButton.click();
        return new AddProjectPage();
    }

    public DeleteProjectPage clickSettingMenuProject() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        actions.contextClick(menuProject).build().perform();
        return new DeleteProjectPage();
    }

    public DeleteProjectPage clickDeleteMenuProject() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteMenuProject.click();
        return new DeleteProjectPage();
    }

    public void clickConfirmationDeleteProject() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        confirmationDeleteProject.click();
    }

    public boolean archiveProjectsIsDisplayed(String archiveProjectsButton) {
        By archivedProject = By.cssSelector(String.format(archivedProjects, archiveProjectsButton));
        return driver.findElement(archivedProject).isDisplayed();
    }

    public String getArchiveProjects() {
        return driver.findElement(By.cssSelector(archivedProjects)).getText();
    }

    public boolean isProjectDeleted(String projectName) {
        By projectBy = By.xpath(String.format(project, projectName));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(projectBy));
        return driver.findElements(projectBy).size() == 0;
    }
}
