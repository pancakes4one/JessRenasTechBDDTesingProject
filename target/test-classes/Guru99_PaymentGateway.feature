Feature: Guru 99 Payment Gateway Scenarios for Elephant Toy Purchase

  Background: Mother Elephant With Babies Soft Toy Page
#    Given The user wants to navigate to Product Page in Hooks
    Then The user wants to verify they are at beginning of Payment Gateway


  @TC1 @Smoke
  Scenario: The user wants to verify expected Product Header
    Then The user wants to see item header as "Mother Elephant With Babies Soft Toy"


  @TC2 @Smoke
  Scenario: The user wants to verify the toy price
    When The user verifies the displayed price is shown
    Then The user wants to verify toy price is "$20"


  @TC3 @Smoke
  Scenario: The user wants to verify the Payment Gateway URL
    Then The user wants to verify the URL should contain "payment-gateway"


  @TC4 @Regression
  Scenario: The user wants to successfully make a purchase
    Then The user wants to make the quantity "5"
    Then The user wants to click Buy Now
    Then The user wants to enter payment information as
      |CNumber | 1234123412341234 |
      |EMonth  |    10            |
      |EYear   |   2027           |
      |CVVCode |    444           |
    Then The user wants to click Pay
    And The user wants to verify message as "Payment successfull!"


  @TC5 @Regression
  Scenario Outline: The user wants to successfully make a purchase with varying quantities
    When The user wants to select quantity of "<Quantity>"
    Then The user wants to click Buy Now
    Then The user wants to enter credit card number
    And The user wants to select expiration month
    And The user wants to select expiration year
    And The user wants to select CVV code
    Then The user wants to click Pay
    And The user wants to verify message as "Payment successfull!"
    Examples:
      |Quantity|
      | 5      |
      | 8      |
      | 9      |
      | 2      |
      | 4      |