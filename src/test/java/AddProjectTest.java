import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class AddProjectTest extends BaseTests {

    private HomePage homePage;

    @BeforeMethod
    public void login() {
        loginPage.setEmail("jfr.rodriguezz@gmail.com");
        loginPage.setPassword("P@ssw0rd");
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
}
