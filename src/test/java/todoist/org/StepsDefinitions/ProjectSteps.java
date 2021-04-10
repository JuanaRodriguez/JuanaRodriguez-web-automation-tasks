package todoist.org.StepsDefinitions;

import entities.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddProjectPage;
import pages.EditProjectPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ProjectSteps {
    AddProjectPage addProjectPage;
    HomePage homePage;
    Project project;
    EditProjectPage editProjectPage;

    public ProjectSteps(HomePage homePage, Project project) {
        this.homePage = homePage;
        this.project = project;
    }

    @When("^I open add project popup$")
    public void iOpenAddProjectPopup() {
        addProjectPage = homePage.leftMenuPage.clickAddProjectButton();
    }

    @And("I set {string} name in project name field")
    public void iSetNameInProjectNameField(String projectName) {
        project.setName(projectName);
        addProjectPage.setProjectName(projectName);
        addProjectPage.clickBoardType();
        addProjectPage.clickProjectType();
    }

    @And("I click on Add button")
    public void iClickOnAddButton() {
        homePage = addProjectPage.clickAddProjectButton();
    }

    @When("I click on name project")
    public void iClickOnNameProject() {
        editProjectPage = homePage.contentBoardProjectPage.clickNameProject();
    }

    @And("I update {string} name in project name field")
    public void iUpdateNameInProjectNameField(String editProjectName) {
        project.setName(editProjectName);
        editProjectPage.setProjectName(editProjectName);
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        homePage = editProjectPage.clickSaveButton();
    }

    @Then("I expect the project is created")
    public void iExpectTheProjectIsCreated() {
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(project.getName()));
        assertTrue(homePage.contentAreaPage.getProjectName().contains("FirstProject"), "Incorrect Message");
    }

    @Then("I expect the project name is updated")
    public void iExpectTheProjectNameIsUpdated() {
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(project.getName()));
        assertTrue(homePage.contentAreaPage.getProjectName().contains("FirstProjectUpdated"), "Incorrect Message");
    }

    @When("I select delete project option")
    public void iSelectDeleteProjectOption() {
        homePage.leftMenuPage.clickSettingMenuProject();
        homePage.leftMenuPage.clickDeleteMenuProject();
    }

    @And("I click on Delete menu button")
    public void iClickOnDeleteMenuButton() {
        homePage.leftMenuPage.clickConfirmationDeleteProject();
    }

    @Then("I expect the Project is deleted")
    public void iExpectTheProjectIsDeleted() {
        assertTrue(homePage.leftMenuPage.isProjectDeleted(project.getName()));
    }
}
