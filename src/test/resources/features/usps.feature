@usps
  Feature: USPS scenarios

#    Background:
#      Given I go to "usps" page

    @usps1
    Scenario Outline: Validate ZIP code for Portnov Computer School
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out "<street>" street, "<city>" city, "<state>" state
      Then I validate "<zip>" zip code exists in the result
      Examples:
        |street             |city     |state| zip |
        |4970 El Camino Real|Los Altos|CA   |94022|
        |371 Elan Village Ln|San Jose |CA   |95134|

    @usps2
    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.40"

    @usps3
    Scenario: Verify location
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "Mail & Ship" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      Then I validate that Sign In is required

    @usps4
    Scenario: Quadcopters delivery
      Given I go to "usps" page
      When I go to "Help" tab
      And I perform "Quadcopters delivery" help search
      Then I verify that no results of "Quadcopters delivery" available in help search

    @usps5
    Scenario: Phone number of the nearest Mail Pickup
      Given I go to "usps" page
      When I navigate to Find a Location page
      And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
      And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
      Then I verify phone number is "800-275-8777"


    @usps7
    Scenario: Every door direct mail
      Given I go to "usps" page
      When I go to "Every Door Direct Mail" under "Business"
      And I search for "4970 El Camino Real, Los Altos, CA 94022"
      And I click "Show Table" on the map
      When I click "Select All" on the table
      And I close modal window
      Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

    @ups1 @ups
    Scenario: UPS end to end first
      Given I go to "ups" page
      And I open Shipping menu
      And I go to Create a Shipment
      When I fill out origin shipment fields
      And I submit the shipment form
      Then I verify origin shipment fields submitted
      And I cancel the shipment form
      Then I verify shipment form is reset


    @ups2 @ups
    Scenario: UPS end to end full
      Given I go to "ups" page
      And I open Shipping menu
      And I go to Create a Shipment
      When I fill out origin shipment fields
      And I submit the shipment form
      Then I verify origin shipment fields submitted
      When I fill out destination shipment fields
      When I submit the shipment form
      And I set packaging type and weight
      When I submit the shipment form
      Then I verify total charges appear
      And I select cheapest delivery option
      And I submit the shipment form
      And I set description and check Saturday Delivery type
      Then I verify total charges changed
      When I submit the shipment form
      And I select Paypal payment type
      And I submit review the shipment form
      Then I review all recorded details on the review page
      And I cancel the shipment form
      Then I verify shipment form is reset