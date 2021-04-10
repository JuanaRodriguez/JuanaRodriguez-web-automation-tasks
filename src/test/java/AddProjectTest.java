import org.testng.annotations.Test;
import pages.AddProjectPage;

import static org.testng.Assert.assertTrue;

public class AddProjectTest extends BaseTests {

    @Test(groups = {"projects","deleteProject"})
    public void testAddProject() {
        String projectName = "FirstProject";
        AddProjectPage addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
        addProjectPage.setProjectName(projectName);
        homePage = addProjectPage.clickAddProjectButton();

        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
        assertTrue(homePage.contentAreaPage.getProjectName().contains("FirstProject"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
    }
}
