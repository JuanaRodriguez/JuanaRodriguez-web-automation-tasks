import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.GradleProperties;

public class EditTaskTest extends BaseTests {
    @BeforeMethod
    public void login() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();

        String projectName = "FirstProject";
        AddProjectPage addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(projectName);
        addProjectPage.clickBoardType();
        addProjectPage.clickProjectType();
        homePage = addProjectPage.clickAddProjectButton();

        String sectionName = "FirstSection";
        AddSectionPage addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
        addSectionPage.setSectionName(sectionName);
        homePage = addSectionPage.clickAddSectionButton();

        String taskName = "FirstTask";
        AddTaskPage addTaskPage = homePage.contentBoardProjectPage.clickAddTaskIcon();
        addTaskPage.setTaskName(taskName);
        homePage = addTaskPage.clickAddTaskButton();
    }

    @Test
    public void testEditTask() {
        String taskNameUpdated = "FirstTaskUpdated";
        EditTaskPage editTaskPage = homePage.contentBoardProjectPage.expandMenuTask();
        homePage.contentBoardProjectPage.clickEditMenuTask();
        editTaskPage.editTaskName(taskNameUpdated);
        homePage = editTaskPage.clickSaveTaskButton();
    }

    @AfterMethod
    public void deleteProject() {
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
