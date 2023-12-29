 Feature: Verifying OMR Branch Book Hotel Automation

  Scenario Outline: Verifying Book Hotel page without including GST and otherRequest
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

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                    | cardType    |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-10-17  | 2023-10-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com | Credit Card |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-10-17  | 2023-10-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com | Debit Card  |

  Scenario Outline: Verifying Book Hotel page with including GST and otherRequest
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User Select the first hotel name and save the hotel name and prize
    And User accept the popup
    Then User Should verify success message after select hotel "Book Hotel"
    And User add guest details with gst "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    Then User enter GST Details "<EnterRegistrationNo>","<EnterCompanyName>" and "<EnterCompanyAddress>"
    And User add special request "<otherRequest>"
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

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | otherRequest  | cardType    |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | Late Check-in | Credit Card |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | Late Check-in | Debit Card  |

  Scenario Outline: Verifying Book Hotel page error messages without entering fill card details
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User Should verify success message after login "Welcome Stallon"
    When User select "<state>","<city>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdults>" and "<noOfChildren>"
    Then User Should verify success message after search hotel "Select Hotel"
    When User Select the first hotel name and save the hotel name and prize
    And User accept the popup
    Then User Should verify success message after select hotel "Book Hotel"
    And User add guest details with gst "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    Then User enter GST Details "<EnterRegistrationNo>","<EnterCompanyName>" and "<EnterCompanyAddress>"
    And User add special request "<otherRequest>"
    Then User Should verify error message "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples: 
      | userName                 | password  | state  | city               | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                    | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | otherRequest  |
      | stallonchandru@gmail.com | Ch@ndru01 | Kerala | Thiruvananthapuram | Standard | 2023-07-17  | 2023-07-20   | 1-One    | 2-Two      |            1 | Mr.        | Stallon   | Chandru  | 9876543210 | stallonchandru@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | Late Check-in |
