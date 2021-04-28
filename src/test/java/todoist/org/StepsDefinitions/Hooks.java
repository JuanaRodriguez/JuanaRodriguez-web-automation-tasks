package todoist.org.StepsDefinitions;

import entities.Project;
import entities.Section;
import entities.Task;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import selenium.DriverManager;
import utils.GradleProperties;

public class Hooks {
    Task task;
    Project project;
    Section section;
    HomePage homePage;
    LoginPage loginPage;
    AddTaskPage addTaskPage;
    AddProjectPage addProjectPage;
    AddSectionPage addSectionPage;

    public Hooks(HomePage homePage, Project project, Section section, Task task) {
        this.project = project;
        this.homePage = homePage;
        this.section = section;
        this.task = task;
    }

    @Before(value = "@Login")
    public void login() {
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @Before(value = "@createProject")
    public void addProject() {
        login();
        project.setName("FirstProject");
        addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(project.getName());
        addProjectPage.clickBoardType();
        addProjectPage.clickProjectType();
        homePage = addProjectPage.clickAddProjectButton();
    }

    @Before(value = "@createSection")
    public void addSection() {
        login();
        addProject();
        section.setName("FirstSection");
        addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
        addSectionPage.setSectionName(section.getName());
        homePage = addSectionPage.clickAddSectionButton();
    }

    @Before(value = "@createTask")
    public void addTask() {
        login();
        addProject();
        addSection();
        task.setName("FirstTask");
        addTaskPage = homePage.contentBoardProjectPage.clickAddTaskIcon();
        addTaskPage.setTaskName(task.getName());
        homePage = addTaskPage.clickAddTaskButton();
    }

    @After(value = "@deleteProject", order = 51)
    public void deleteProject() {
        homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage.leftMenuPage.clickConfirmationDeleteProject();
    }

    @After(order = 50)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "SCREENSHOT-NAME");
        }
        DriverManager.getInstance().quitDriver();
    }
}
