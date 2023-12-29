  Feature: Verifying OMR Branch Explore Hotel Automation

  Scenario Outline: Verifying explore hotel with valid credentials
     Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying Explore Hotel with valid credentials with multiple roomType
     Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    And User Should verify after select hotel success message multipleRoomType header "<roomType>"

    Examples: 
      | userName                 | password  | state  | city               | roomType                            | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard/Deluxe/Suite/Luxury/Studio | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying Explore Hotel with valid credentials and header ends with selected roomType
     Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    And User Should verify hotel header name ends with selected room type "<roomType>"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 |

  Scenario Outline: Verifying Explore Hotel without credentials
     Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User click search button without enter any fields
    Then User Should verify error message after clicking submit button "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | userName                 | password  |
      | stallonchandru@gmail.com | Ch@ndru01 |
