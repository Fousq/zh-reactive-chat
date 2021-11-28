Feature: The message is received from user
  Scenario: The new not empty message was received
    Given new not empty message
    When receive message
    Then return message with status 'Send'