import org.testng.annotations.Test;
import pages.EditProjectPage;

import static org.testng.Assert.assertTrue;

public class EditProjectTest extends BaseTests {

    @Test(groups = {"projects", "createProject", "deleteProject"})
    public void testEditProject() {
        String editProjectName = "FirstProjectUpdated";
        EditProjectPage editProjectPage = homePage.contentBoardProjectPage.clickNameProject();
        editProjectPage.setProjectName(editProjectName);
        homePage = editProjectPage.clickSaveButton();

        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(editProjectName));
        assertTrue(homePage.contentAreaPage.getProjectName().contains("FirstProjectUpdated"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
    }
}
