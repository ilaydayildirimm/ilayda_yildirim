Feature: Simple sign in test
  Scenario Outline: User sign in with invalid credentials
    Given User navigates to home page
    When User clicks login button on Papara homepage
    And User clicks corporate login button on Papara page
    And User clicks create account button on Papara login page
    And User enters "<firstname>", "<lastname>" , "<email>", "<telephonenumber>" into credential fields on Papara sign in page
    And User clicks radio buttons on Papara sign in page
    And User clicks continue button on Papara sign in page
    And User enters otp fields on Papara sign in page
    And User clicks approve button on Papara sign in page
    Then User should see error message on Papara sign in page
    Examples:
      | firstname | lastname | email            | telephonenumber |
      | John      | Doe      | ilayda@gmail.com | 5532921289      |