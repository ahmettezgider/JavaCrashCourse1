Feature: Entrance menu functionanily


  Scenario: menu usage
    Given user on homepage
    When  user open the entrance menu
    Then  all links in the menu should be usable
    And   user should be able to close the entrance menu



    Scenario: choose language
      Given user on homepage
      When  user select the language as "fr"
      Then  user should be navigate to related page