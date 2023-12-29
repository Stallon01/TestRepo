Feature: Verifying OMR Branch Select Hotel Automation

  Scenario Outline: Verifying Select Hotel page with accept alert
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User Select the first hotel name and save the hotel name and prize
    And User accept the popup
    Then User Should verify success message after select hotel "Book Hotel"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying select hotel page with dismiss alert
   Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User Select the first hotel name and save the hotel name and prize
    And User dismiss the popup
    Then User Should verify success message after search hotel "Select Hotel"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying Select Hotel page sort in ascending order
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User click the name ascending in sort by
    Then User Should verify whether the selected roomType are listed in Ascending

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying Select Hotel page with listed hotels after unselect roomType
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User unselect the roomType "<roomType>"
    Then User should verify listed hotels after unselect roomType

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |
