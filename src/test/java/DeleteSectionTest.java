import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddSectionPage;
import pages.DeleteProjectPage;
import pages.DeleteSectionPage;
import utils.GradleProperties;

import static org.testng.Assert.*;

public class DeleteSectionTest extends BaseTests {

    String sectionName = "FirstSection";

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

        AddSectionPage addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
        addSectionPage.setSectionName(sectionName);
        homePage = addSectionPage.clickAddSectionButton();
    }

    @Test
    public void testDeleteSection(){
        DeleteSectionPage deleteSectionPage = homePage.contentBoardProjectPage.expandMenuSections();
        homePage.contentBoardProjectPage.clickDeleteMenuSection();
        assertTrue(homePage.contentAreaPage.isSectionDeleted(sectionName));
        assertEquals(homePage.contentAreaPage.getAddEmptySection(), "");
        assertNotEquals(homePage.contentAreaPage.getAddEmptySection(), "FirstSection");
        assertTrue(homePage.contentAreaPage.cancelButtonIsDisplayed(sectionName));
    }

    @AfterMethod
    public void deleteProject(){
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
