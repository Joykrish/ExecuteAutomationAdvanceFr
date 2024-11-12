Feature:Login Feature
  This feature is responsible for testing all  the scenarios for the Login application
  Scenario: Check login with correct userName and password

    And I see the application opened
    Then I click login link
    When I enter UserName and Password
    |userName|Password|
    |Admin|password|
    Then I click login button
    Then I should see the userName with hello

