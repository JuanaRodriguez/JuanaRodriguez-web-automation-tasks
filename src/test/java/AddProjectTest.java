import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        homePage.clickAddProjectLink();
        addProjectPage.setName("FirstProject");
        addProjectPage.clickAddProjectButton();

        assertTrue(projectPage.getTitleText().contains("FirstProject"), "Incorrect Message");
        assertTrue(projectPage.getAddTaskText().contains("Add task"), "Incorrect Message");
    }
}
