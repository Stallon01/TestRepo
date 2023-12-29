Feature: Verifying OMR Branch Cancel Booking Automation

  Scenario Outline: Verifying cancel booking with order id
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User Select the first hotel name and save the hotel name and prize
    And User accept the popup
    Then User Should verify success message after select hotel "Book Hotel"
    And User add guest details "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    And User enter Total Payment Fill Card Details "<cardType>"
      | selectCard  | selectCardType | Enter Card Number | Enter Your Name On Card | Select Month | Year | Enter Card CVV |
      | Credit Card | Visa           |  5555555555552223 | Stallon                 | August       | 2023 |            987 |
      | Credit Card | Amex           |  5555555555552223 | Stallon                 | August       | 2023 |            987 |
      | Credit Card | Mastercard     |  5555555555552223 | Stallon                 | August       | 2023 |            987 |
      | Credit Card | Discover       |  5555555555552223 | Stallon                 | August       | 2023 |            987 |
      | Debit Card  | Visa           |  5555555555552222 | Stallon                 | August       | 2023 |            987 |
      | Debit Card  | Amex           |  5555555555552222 | Stallon                 | August       | 2023 |            987 |
      | Debit Card  | Mastercard     |  5555555555552222 | Stallon                 | August       | 2023 |            987 |
      | Debit Card  | Discover       |  5555555555552222 | Stallon                 | August       | 2023 |            987 |
    Then User Should verify success message after submit "Booking is Confirmed" and save the generated order id
    And User Should verify whether same selected hotel is booked or not
    When User navigate to my booking page
    Then User Should verify the success message after navigate to booking page "Bookings"
    When User search the generated order id
    Then User Should verify same order id is displayed
    And User Should verify same hotel name is displayed
    And User Should verify same hotel prize is displayed
    When User click the edit button and modify the checkInDate "<modifyDate>"
    Then User Should verify success message edit checkInDate "Booking updated successfully"
    When User search the generated order id
    Then User Should verify same order id is displayed after modifyDate
    And User Should verify same hotel name is displayed after modifyDate
    And User Should verify same hotel prize is displayed after modifyDate
    When User click the cancel button
    And User Should accept the alert
    Then User Should verify after cancel success message "Your booking cancelled successfully"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                    | cardType    | modifyDate |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com | Credit Card | 2023-07-18 |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com | Debit Card  | 2023-07-18 |

  Scenario Outline: Verifying cancel booking with modify first booking
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User navigate to the my bookings page
    Then User Should verify the success message after navigate to booking page "Bookings"
    When User click the first booking cancel button
    And User Should accept the alert
    Then User Should verify after cancel success message "Your booking cancelled successfully"

    Examples: 
      | userName                 | password  |
      | stallonchandru@gmail.com | Ch@ndru01 |

  Scenario Outline: Verifying cancel booking with modify existing booking order id
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User navigate to the my bookings page
    Then User Should verify the success message after navigate to booking page "Bookings"
    When User enter the existing order id "<orderId>"
    When User click the cancel button
    And User Should accept the alert
    Then User Should verify after cancel success message "Your booking cancelled successfully"

    Examples: 
      | userName                 | password  | orderId    |
      | stallonchandru@gmail.com | Ch@ndru01 | TVBEW76560 |
