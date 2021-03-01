import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AddProjectPage;
import pages.LoginPage;
import pages.ProjectPage;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected ProjectPage projectPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todoist.com/users/showlogin");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectPage = new ProjectPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
