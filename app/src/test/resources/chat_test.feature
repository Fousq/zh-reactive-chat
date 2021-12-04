Feature: The message is received from user
  Scenario: The new not empty message was received
    Given new not empty message
    When receive not empty message
    Then return message with status 'Send'

  Scenario: Empty text message was received
    Given empty text message
    When receive empty text message
    Then return empty text error

  Scenario: Receive message without user
    Given message without user
    When receive message without user
    Then return user absent error

  Scenario: Receive message without status
    Given message without status
    When receive message without status
    Then return status absent error