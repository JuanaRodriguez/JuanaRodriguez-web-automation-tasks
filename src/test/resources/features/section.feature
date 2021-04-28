@Section
Feature: Sections

  @createProject @deleteProject
  Scenario: Add section
    Given I click on add section option
    When I set "FirstSection" name in section name field
    And I click on Add Section button
    Then I expect the section is created

  @createSection @deleteProject
  Scenario: Edit section
    Given I click on edit section option
    When I set "FirstSectionUpdated" name in edit section name field
    And I click on Edit Section button
    Then I expect the section is updated

  @createSection
  Scenario: Delete section
    Given I click on menu section
    When I click on delete menu section
    And I click on delete confirmation button
    Then I expect the section is deleted
