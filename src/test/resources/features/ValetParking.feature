@ValetParking
  Feature: Valet parking scenarios

    @LessThan5Hours
    Scenario: parking during less than 5 minutes
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "00:00"
      And user selects leaving date "05/06/2021" and time "03:00"
      Then user validates parking cost for type "valet parking"
