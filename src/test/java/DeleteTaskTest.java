import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class DeleteTaskTest extends BaseTests {

    String taskName = "FirstTask";

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

        AddTaskPage addTaskPage = homePage.contentBoardProjectPage.clickAddTaskIcon();
        addTaskPage.setTaskName(taskName);
        homePage = addTaskPage.clickAddTaskButton();

    }

    @Test
    public void testDeleteTask() {
        DeleteTaskPage deleteTaskPage = homePage.contentBoardProjectPage.expandMenuTasks();
        homePage.contentBoardProjectPage.clickDeleteMenuTask();
        homePage = deleteTaskPage.clickConfirmationDeleteTask();

        assertTrue(homePage.contentAreaPage.isTaskDeleted(taskName));
        assertTrue(homePage.contentAreaPage.getCountTask().contains("0"), "Incorrect Message");
    }

    @AfterMethod
    public void deleteProject() {
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
