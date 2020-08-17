@wd
  Feature: WebDriver practice
    @wd1
    Scenario: Work with WebDriver
      Given I go to "google" page
      And I go to "quote" page
      And I print page details
      And I go back and forward, then refresh the page
      And I change resolution to "phone"
      And I change resolution to "desktop"
      And I fill out required fields
      When I verify email field behavior
      And I submit the page
      Then I verify that fields values recorded correctly