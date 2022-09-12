Feature: bot for klavogonki.ru
  Background: website klavogonki.ru is open
    Given open website "https://klavogonki.ru"

  Scenario: bot start game and print words
    When start game
    And  wait for start
    And print marked word
    Then check that the game is over and score more then 1500