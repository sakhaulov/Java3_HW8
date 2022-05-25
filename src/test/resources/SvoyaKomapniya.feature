Feature: I as a user can choose my location

  Scenario: Changing location to "Барнаул"
    Given I've selected Chelyabinsk as my location
    When I click on location button at the page header
    And Pick "Барнаул" in the drop-down menu
    Then My location changed to "Барнаул"