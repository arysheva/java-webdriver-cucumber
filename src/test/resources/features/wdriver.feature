@wd
  Feature: WebDriver practice
    @wd1
    Scenario: Work with WebDriver
      Given I go to "usps" page
      And I go to "quote" page
      And I print page details
      And I go back and forward, then refresh the page
      And I change resolution to "phone"
      And I change resolution to "desktop"
      And I fill out required fields
      When I verify email field behavior
      And I submit the page
      Then I verify that fields values recorded correctly
      And I print logs to the console


    @wd2
    Scenario: Practice with window switch
      Given I go to "quote" page
      And I "accept" third party agreement
      And I fill out "Anna Ann" name and "4088169000" phone
      And I verify document list
