Feature: Login page feature
  @smoke
  Scenario: Amazon Homepage Page title
    Given user is on Homepage page
    When user gets the title of the page
    Then page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
  @sanity
  Scenario: User login with valid credentials
    Given user is on login page
    When user enters emailAddress "sandeepambati.reddy@gmail.com"
    And user enters password "@Zemoso8"
    And user clicks on sign-In button

