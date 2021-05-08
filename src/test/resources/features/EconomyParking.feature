@EconomyParking
Feature: Valet parking scenarios

  @LessThanAnHour
  Scenario: parking during less than 5 minutes
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "07/06/2021" and time "03:00"
    Then user validates parking cost for type "economy parking"