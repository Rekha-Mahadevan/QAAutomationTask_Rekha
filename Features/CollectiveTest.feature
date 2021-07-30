Feature: QA Automation Task on Collective staging URL

  Background: Below are the common steps for every scenario
    Given I launch Chrome browser
    When I open the Collective Staging URL

  Scenario: Logo Presence on Collective Home Page
    Then I verify the Collective logo is present on the home page
    And close browser

  Scenario: To verify Short Stay Booking verification for Paper Factory
    Then I verify Book now exist
    And click on Book now button
    Then I verify "Stay for a few nights" item is highlighted
    And Location is selected as "Paper Factory"
    And click on "Select your room" button
    Then I verify Home page is navigated to "https://reservations.thecollective.com/95097#/guestsandrooms"
    And close browser

  Scenario: To verify Location field throws an error for empty value
    Then I verify Book now exist
    And click on Book now button
    Then I verify "Stay for a few nights" item is highlighted
    And Location field is unselected
    Then "Please pick a Location" error message is thrown
    And close browser

  Scenario: To verify sign up to newsletter in the Collective home page
    Then I verify "sign up to our newsletter" exist
    And I enter the "yours@example.com" in the newsletter field
    And Click on submit button
    Then verify "thank you for signing up" message is displayed
    And close browser
