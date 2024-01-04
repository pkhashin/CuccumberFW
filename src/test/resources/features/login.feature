Feature: Login

  Background:
    Given the user is on the login page

    @tc01
    Scenario: Valid login
      Given user logins in with valid username and password
#      When the user click on the login button
#      Then I should be logged in successfully