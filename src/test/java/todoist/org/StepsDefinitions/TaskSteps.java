package todoist.org.StepsDefinitions;

import entities.Project;
import entities.Section;
import entities.Task;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddTaskPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class TaskSteps {

    AddTaskPage addTaskPage;
    HomePage homePage;
    Section section;
    Project project;
    Task task;

    public TaskSteps(HomePage homePage, Project project, Section section, Task task) {
        this.homePage = homePage;
        this.section = section;
        this.project = project;
        this.task = task;
    }

    @When("I click on add task option")
    public void iClickOnAddTaskOption() {
        addTaskPage = homePage.contentBoardProjectPage.clickAddTaskIcon();
    }

    @And("I set {string} name in task name field")
    public void iSetNameInTaskNameField(String taskName) {
        task.setName(taskName);
        addTaskPage.setTaskName(taskName);
    }

    @And("I click on Add Task button")
    public void iClickOnAddTaskButton() {
        homePage = addTaskPage.clickAddTaskButton();
    }

    @Then("I expect the task is created")
    public void iExpectTheTaskIsCreated() {
        assertTrue(homePage.contentAreaPage.getAddTask().contains("FirstTask"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.getCountTask().contains("1"), "Incorrect Message");
        assertTrue(homePage.contentAreaPage.cancelButtonIsDisplayed(task.getName()));
    }
}
