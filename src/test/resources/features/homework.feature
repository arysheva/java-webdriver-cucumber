@hw
  Feature: Scenarios with different web sites

    @converter1
    Scenario: Convert Temperature
      Given I go to "converter" page
      When I click on "Temperature"
      And I set from "Fahrenheit" to "Celsius"
      Then I set "54" value and verify that result is "12.2"

    @converter2
    Scenario: Convert Pound to Kilogram
      Given I go to "converter" page
      When I click on "Weight"
      And I set from "Pound" to "Kilogram"
      Then I set "170" value and verify that result is "77"

    @converter3
    Scenario: Convert Mile to Kilometer
      Given I go to "converter" page
      When I click on "Length"
      And I set from "Mile" to "Kilometer"
      Then I set "50" value and verify that result is "80.4"

    @calculator
    Scenario: Verify calculator result
      Given I go to "calculator" page
      When I navigate to "Auto Loan Calculator"
      And I clear all calculator fields
      And I calculate
      Then I verify "Please provide a positive auto price." calculator error
      Then I verify "Please provide a positive interest value." calculator error
      And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
      And I calculate
      Then I verify monthly pay is "$372.86"