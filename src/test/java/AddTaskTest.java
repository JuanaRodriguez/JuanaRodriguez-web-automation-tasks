import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddSectionPage;
import pages.AddTaskPage;
import pages.DeleteProjectPage;
import utils.GradleProperties;

import static org.testng.Assert.*;

public class AddTaskTest extends BaseTests{
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
    }

    @Test
    public void testAddTask(){
        String taskName = "FirstTask";
        AddTaskPage addTaskPage = homePage.contentBoardProjectPage.clickAddTaskIcon();
        addTaskPage.setTaskName(taskName);
        homePage = addTaskPage.clickAddTaskButton();

        assertTrue(homePage.contentAreaPage.getAddTask().contains("FirstTask"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getCountTask().contains("1"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.cancelButtonIsDisplayed(taskName));
    }

    @AfterMethod
    public void deleteProject(){
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
