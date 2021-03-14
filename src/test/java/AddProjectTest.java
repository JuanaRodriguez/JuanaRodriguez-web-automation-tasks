import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class AddProjectTest extends BaseTests {

    @BeforeMethod
    public void login() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @Test
    public void testAddProject() {
        String projectName = "FirstProject";
        AddProjectPage addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(projectName);
        homePage = addProjectPage.clickAddProjectButton();

        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
        assertTrue(homePage.contentAreaPage.getProjectName().contains("FirstProject"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
    }

    @AfterMethod
    public void deleteProject(){

    }
}
