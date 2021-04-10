import org.testng.annotations.Test;
import pages.DeleteProjectPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DeleteProjectTest extends BaseTests{

    @Test(groups = {"projects", "createProject"})
    public void testDeleteProject(){
        String projectName = "FirstProject";
        String archiveProjectsButton = "Archived projects";
        DeleteProjectPage deleteProjectPage = homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
        homePage = deleteProjectPage.clickConfirmationDeleteProject();

        assertTrue(homePage.leftMenuPage.archiveProjectsIsDisplayed(archiveProjectsButton));
        assertTrue(homePage.leftMenuPage.getArchiveProjects().contains("Archived projects"), "Incorrect Message");
        assertFalse(homePage.leftMenuPage.getArchiveProjects().contains("FirstProject"), "Incorrect Message");
        assertTrue(homePage.leftMenuPage.isProjectDeleted(projectName));

    }
}
