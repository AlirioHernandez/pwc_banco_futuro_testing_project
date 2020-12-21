Feature: The client can request the different products offered by the bank through the different services of the bank

  @Autometion
  Scenario Outline: a new client without product request a product
    Given tha bank has clients
      | name  | id         | products |
      | anita | 1122334455 | [blank]  |
    When the client "anita" request a "<product>" type "<type>"
    Then the bank should assign a "<product>" to client "anita"
    And "anita" should have the following products
      | <product> |
    Examples:
      | product         | type        |
      | savings account | account     |
      | current account | account     |
      | credit card     | credit card |

  @Autometion
  Scenario Outline: a client with product request a new product
    Given tha bank has clients
      | name   | id     | products      |
      | pepito | 224466 | <old product> |
    When the client "pepito" request a "<product>" type "<type>"
    Then the bank should assign a "<product>" to client "pepito"
    And "pepito" should have the following products
      | <product>     |
      | <old product> |
    Examples:
      | product         | old product     | type        |
      | savings account | current account | account     |
      | current account | savings account | account     |
      | credit card     | savings account | credit card |

  @Autometion
  Scenario: a client with product request cancellation of a product
    Given tha bank has clients
      | name  | id        | products                                    |
      | alejo | 333444555 | savings account,current account,credit card |
    When the client "alejo" request the cancellation of a "savings account" type "account"
    Then the bank should assign a "<product>" to client "alejo"
    And "alejo" should have the following products
      | current account |
      | credit card     |
