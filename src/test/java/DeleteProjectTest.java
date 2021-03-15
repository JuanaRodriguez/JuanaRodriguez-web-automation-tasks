import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DeleteProjectPage;
import utils.GradleProperties;

public class DeleteProjectTest extends BaseTests {
    @BeforeMethod
    public void createProject() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();

        String projectName = "FirstProject";
        AddProjectPage addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(projectName);
        homePage = addProjectPage.clickAddProjectButton();
    }

    @Test
    public void testDeleteProject() {
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickDeleteMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProjectTwo();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
