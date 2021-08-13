Feature: Today's Deals Feature
  Background:
    Given user is already on login page
    |emailId|password|
    |sandeepambati.reddy@gmail.com|@Zemoso8|

  Scenario: Today's Deals Selection
    Given user enters in search bar "Today's Deals"
    When user selects today's deals of the day
    Then user verifies page title to be "Amazon.in : Today's Deals"
    And user selects third item from the page
    And user add items to the cart








