@Login
Feature: Login Todoist

  Background:
    Given I go to Todoist page

  Scenario Outline: Login Todoist
    When I login with email "<email>" and the password "<password>"
    Then I expect the login is successfully
    Examples:
      | email                     | password |
      | juana.rodriguez@gmail.com | P@00000  |
      | marylinmoya@gmail.com     | P000000  |
