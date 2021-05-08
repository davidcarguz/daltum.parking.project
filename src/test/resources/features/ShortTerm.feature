@Short-Term
Feature: Valet parking scenarios

  @LessThanAnHour
  Scenario: parking during less than 5 minutes
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/08/2021" and time "03:20"
    Then user validates parking cost for type "short-term"