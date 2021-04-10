/*
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import utils.GradleProperties;
* */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddSectionPage;
import pages.DeleteProjectPage;
import utils.GradleProperties;

import static org.testng.Assert.*;

public class AddSectionTest extends BaseTests {
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
    }

    @Test
    public void testAddSection(){
        String sectionName = "FirstSection";
        AddSectionPage addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
        addSectionPage.setSectionName(sectionName);
        homePage = addSectionPage.clickAddSectionButton();

        assertTrue(homePage.contentAreaPage.sectionIsDisplayed(sectionName));
        assertTrue(homePage.contentAreaPage.getSectionName().contains("FirstSection"), "Incorrect Message");
        assertFalse(homePage.contentAreaPage.getSectionName().contains("Other Section"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");

    }

    @AfterMethod
    public void deleteProject(){
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();
    }
}
