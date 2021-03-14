import org.testng.annotations.Test;
import pages.HomePage;
import utils.GradleProperties;

import static org.testng.Assert.*;

public class LoginTest extends BaseTests {

    @Test
    public void testLogin() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        HomePage homePage = loginPage.clickLoginButton();

        assertTrue(homePage.headerPage.isSettingDisplayed(), "Settings is not displayed");

    }
}
