import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AddProjectPage;
import pages.DeleteProjectPage;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;


public class BaseTests {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
    }

    @BeforeMethod(dependsOnGroups = {"projects"})
    public void login() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @BeforeMethod(dependsOnMethods = {"login"}, dependsOnGroups = {"createProject"})
    public void testAddProject() {
        String projectName = "FirstProject";
        AddProjectPage addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(projectName);
        homePage = addProjectPage.clickAddProjectButton();
    }

    @AfterMethod(onlyForGroups = {"deleteProject"})
    public void testDeleteProject(){
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
