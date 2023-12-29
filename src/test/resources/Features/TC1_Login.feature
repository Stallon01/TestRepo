Feature: Verifying OMR Branch Hotel Login Automation

  Scenario Outline: Verifying login with valid credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"

    Examples: 
      | userName                 | password  |
      | stallonchandru@gmail.com | Ch@ndru01 |

  Scenario Outline: Verifying login with valid credentials using ENTER key
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>" with Enter Key
    Then User Should verify success message after login "Welcome Stallon"

    Examples: 
      | userName                 | password  |
      | stallonchandru@gmail.com | Ch@ndru01 |

  Scenario Outline: Verifying login with invalid credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify error message after login "Invalid Login details or Your Password might have expired. "

    Examples: 
      | userName                 | password   |
      | stallonchandru@gmail.com | uhuhgd@123 |
