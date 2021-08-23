Feature: To verify the login test feature

  @poistive
  Scenario: Login with valid testdata
    Given User should be on the login page
    When User entered valid username
    And User entered valid password
    And Clicked on signin button
    Then User should be on the homepage

  @negetive
  Scenario: Login with valid testdata
    Given User should be on the login page
    When User entered invalid username
    And User entered invalid password
    And Clicked on signin button
    Then Application should show some validation message
