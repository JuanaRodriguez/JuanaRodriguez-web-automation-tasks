import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddSectionPage;
import pages.DeleteProjectPage;
import pages.EditSectionPage;
import utils.GradleProperties;

import static org.testng.Assert.*;

public class EditSectionTest extends BaseTests {

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

        String sectionName = "FirstSection";
        AddSectionPage addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
        addSectionPage.setSectionName(sectionName);
        homePage = addSectionPage.clickAddSectionButton();
    }

    @Test
    public void testEditSection() {
        String ExpectSectionName = "FirstSectionUpdated";
        EditSectionPage editSectionPage = homePage.contentBoardProjectPage.expandMenuSection();
        homePage.contentBoardProjectPage.clickEditMenuSection();
        editSectionPage.editSectionName(ExpectSectionName);
        homePage = editSectionPage.clickSaveSectionButton();
        String ActualSectionName = homePage.contentAreaPage.getSectionName();
        assertEquals(ActualSectionName, ExpectSectionName);
        assertNotEquals(ActualSectionName, "FirstSection");
        assertTrue(homePage.contentAreaPage.getSectionName().contains("FirstSectionUpdated"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddSectionText().contains("Add section"), "Incorrect Message");
    }

    @AfterMethod
    public void deleteProject() {
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
