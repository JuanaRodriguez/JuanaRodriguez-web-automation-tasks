package todoist.org.StepsDefinitions;

import entities.Project;
import entities.Section;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddSectionPage;
import pages.EditSectionPage;
import pages.HomePage;

import static org.testng.Assert.*;

public class SectionSteps {
    HomePage homePage;
    Section section;
    AddSectionPage addSectionPage;
    Project project;
    EditSectionPage editSectionPage;

    public SectionSteps(HomePage homePage, Project project, Section section) {
        this.homePage = homePage;
        this.section = section;
        this.project = project;
    }

    @When("I click on add section option")
    public void iClickOnAddSectionOption() {
        addSectionPage = homePage.contentBoardProjectPage.clickSectionField();
    }

    @And("I set {string} name in section name field")
    public void iSetNameInSectionNameField(String sectionName) {
        section.setName(sectionName);
        addSectionPage.setSectionName(sectionName);
    }

    @And("I click on Add Section button")
    public void iClickOnAddSectionButton() {
        homePage = addSectionPage.clickAddSectionButton();
    }

    @Then("I expect the section is created")
    public void iExpectTheSectionIsCreated() {
        assertTrue(homePage.contentAreaPage.sectionIsDisplayed(section.getName()));
        assertTrue(homePage.contentAreaPage.getSectionName().contains("FirstSection"), "Incorrect Message");
        assertFalse(homePage.contentAreaPage.getSectionName().contains("Other Section"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
    }

    @When("I click on edit section option")
    public void iClickOnEditSectionOption() {
        homePage.contentBoardProjectPage.expandMenuSection();
        editSectionPage = homePage.contentBoardProjectPage.clickEditMenuSection();
        editSectionPage.editSectionName("FirstSectionUpdated");
    }

    @And("I set {string} name in edit section name field")
    public void iSetNameInEditSectionNameField(String editSectionName) {
        section.setName(editSectionName);
        editSectionPage.editSectionName(editSectionName);
    }

    @And("I click on Edit Section button")
    public void iClickOnEditSectionButton() {
        homePage = editSectionPage.clickSaveSectionButton();
    }

    @Then("I expect the section is updated")
    public void iExpectTheSectionIsUpdated() {
        String ActualSectionName = homePage.contentAreaPage.getSectionName();

        assertEquals(ActualSectionName, "FirstSectionUpdated");
        assertNotEquals(ActualSectionName, "FirstSection");
        assertTrue(homePage.contentAreaPage.getSectionName().contains("FirstSectionUpdated"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddTaskText().contains("Add task"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getAddSectionText().contains("Add section"), "Incorrect Message");
    }

    @When("I click on menu section")
    public void iClickOnMenuSection() {
        homePage.contentBoardProjectPage.expandMenuSections();
    }

    @And("I click on delete menu section")
    public void iClickOnDeleteMenuSection() {
        homePage.contentBoardProjectPage.clickDeleteMenuSection();
    }

    @And("I click on delete confirmation button")
    public void iClickOnDeleteConfirmationButton() {
        homePage.contentBoardProjectPage.clickConfirmationDeleteSection();
    }

    @Then("I expect the section is deleted")
    public void iExpectTheSectionIsDeleted() {
        assertTrue(homePage.contentAreaPage.isSectionDeleted(section.getName()));
        assertEquals(homePage.contentAreaPage.getAddEmptySection(), "");
        assertNotEquals(homePage.contentAreaPage.getAddEmptySection(), "FirstSection");
        assertTrue(homePage.contentAreaPage.cancelButtonIsDisplayed(section.getName()));
    }
}
