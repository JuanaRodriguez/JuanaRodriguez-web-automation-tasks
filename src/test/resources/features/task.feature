@Task
Feature: Tasks

  @createSection @deleteProject
  Scenario: Add task
    Given I click on add task option
    When I set "FirstTask" name in task name field
    And I click on Add Task button
    Then I expect the task is created
