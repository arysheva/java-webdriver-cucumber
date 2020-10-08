@rest
Feature: REST API automation

  @rest1
  Scenario: REST API Position CRUD
#    login
    Given I login via REST as "recruiter"
#    post
    When I crate via REST "automation" position
#    get
    Then I verify via REST new position is in the list
#    put
    When I update REST "automation" position
#    get /positions {id}
    Then I verify via REST new position is updated
#    delete /position {id}
    When I delete via REST new position
#    get /position
    Then I verify via REST new position is deleted