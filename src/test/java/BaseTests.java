import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }


}
