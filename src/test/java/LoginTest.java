import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTests {

    @Test
    public void testLogin() {
        loginPage.setEmail("jfr.rodriguezz@gmail.com");
        loginPage.setPassword("P@ssw0rd");
        HomePage homePage = loginPage.clickLoginButton();

        assertTrue(homePage.getTitleText().contains("Today"), "Incorrect Message");

    }
}
