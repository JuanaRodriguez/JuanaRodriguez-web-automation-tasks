@Project
Feature: Projects

  @Login @deleteProject
  Scenario: Add a project
    Given I open add project popup
    When I set "FirstProject" name in project name field
    And I click on Add button
    Then I expect the project is created

  @createProject @deleteProject
  Scenario: Update a project
    Given I click on name project
    When I update "FirstProjectUpdated" name in project name field
    And I click on save button
    Then I expect the project name is updated

  @createProject
  Scenario: Delete a project
    Given I select delete project option
    When I click on Delete menu button
    Then I expect the Project is deleted
