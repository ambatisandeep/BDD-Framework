Feature: Todays Deals Feature

  Background:
    Given user launch the browser
    When user enters  the URL "https://www.amazon.in/"
    Then user enters valid username and password

  Scenario: Amazon Homepage Page title
    Given user is on Homepage page
    When user gets the title of the page
    Then page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
