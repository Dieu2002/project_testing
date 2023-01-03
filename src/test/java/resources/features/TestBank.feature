Feature: Manage Customer Account

  Scenario: Login as Customer
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Deposit button
    And user input amount
    And click on Deposit button
    Then message is display
  Scenario Outline: User input invalid data into amount field
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Deposit button
    And input invalid <data> into amount field
    And click on Deposit button
    Then message is display
    Examples:
      | data  |
      | -20000 |
      | hai00  |
      | ☂нa̘̫͈̭͌͛͌̇̇̍ıt̲̅ɾ๖ۣۜaɱ₦αмɱⓤ๖ۣۜOi̞̟̫̺ͭ̒ͭͣ๖ۣۜNﻮ ąn☂  |

  Scenario: Amount field blank
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Deposit button
    And click on Deposit button
    Then message is display
  Scenario: Verify that user can not withdrawl in case amount more than Balance
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Withdrawl button
    And input Amount more than Balance
    And click on Withdrawl button
    Then message is display
  Scenario: verify that user can withdraw successfully with valid data
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Withdrawl button
    And input valid Amount to be Withdrawn
    And click on Withdrawl button
    Then message is display

   Scenario Outline: verify that user can not withdraw in case user input invalid data
     Given user is on manager page
     And verify manage page
     When user click on Customer Login button
     And select <account>
     And click on Login button
     And user click on Withdrawl button
     And input <data> invalid Amount to be Withdrawn
     And click on Withdrawl button
     Then message is display
     Examples:
       | data |
       | -4000 |
       | hai00  |
       | ☂нa̘̫͈̭͌͛͌̇̇̍ıt̲̅ɾ๖ۣۜaɱ₦αмɱⓤ๖ۣۜOi̞̟̫̺ͭ̒ͭͣ๖ۣۜN |


  Scenario: Amount to be Withdrawn leave blank
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And user click on Withdrawl button
    And click on Withdrawl button
    Then message is display
  Scenario: verify that user navigate successfully to the transactions page
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And click on Transactions button
    Then message is display
  Scenario: verify that user can reset transactions successfully
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And click on Transactions button
    And click on reset button
    When click on back button
    Then message is display
  Scenario: Verify that user can filter data when user click on Date - time text
    Given user is on manager page
    And verify manage page
    When user click on Customer Login button
    And select <account>
    And click on Login button
    And click on Transactions button
    And filter data
    Then message is display
#  Scenario: verify that user can edit successfully start date on transactions page
#    Given user is on manager page
#    And verify manage page
#    When user click on Customer Login button
#    And select <account>
#    And click on Login button
#    And click on Transactions button
#    And click on start date button
#    And select start date
#    Then message is display
