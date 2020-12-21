Feature: the information of the user's products displayed on different platforms should be the same and reliable

  @HumanChecked
  Scenario Outline: a customer makes a transfer from the transactional portal and on a different platform I can verify the details
    Given the customer "pedro" make a transfer from transactional portal
    When the customer "pedro" can verify the details on platform "<platform type>"
    Then the customer should be able to verify the details of transfer
    Examples:
      | platform type |
      | portal movile |
      | SMS           |


  @HumanChecked
  Scenario Outline: a customer makes a transfer from the portal movile and on a different platform I can verify the details
    Given the customer "pedro" make a transfer from portal movile
    When the customer "pedro" can verify the details on platform "<platform type>"
    Then the customer should be able to verify the details of transfer
    Examples:
      | platform type        |
      | transactional portal |
      | SMS                  |


  @HumanChecked
  Scenario Outline: a customer makes a transfer from sms and on a different platform I can verify the details
    Given the customer "pedro" make a transfer from sms
    When the customer "pedro" can verify the details on platform "<platform type>"
    Then the customer should be able to verify the details of transfer
    Examples:
      | platform type        |
      | transactional portal |
      | portal movile        |
