Feature: Simple login test
  Scenario Outline: User logins with invalid credentials
    Given User navigates to home page
    When User clicks login button on Papara homepage
    And User clicks corporate login button on Papara page
    And User enters "<cardNumber>" and "<password>" credentials on Papara login page
    And User clicks login button on Papara login page
    Then Notification should be seems directly
    Examples:
      | cardNumber | password |
      | 123124134134 | 11111111 |

