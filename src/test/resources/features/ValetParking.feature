@ValetParking @Regression
  Feature: Valet parking scenarios

    @LessThan5HoursValet
    Scenario: parking during less than 5 hours
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "00:00"
      And user selects leaving date "05/06/2021" and time "03:00"
      Then user validates parking cost for type "valet parking"

    @5HoursAndAFractionValet
    Scenario: parking during 5 hours and a fraction
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "00:00"
      And user selects leaving date "05/06/2021" and time "05:10"
      Then user validates parking cost for type "valet parking"

    @5HoursValet
    Scenario: parking during 5 hours
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "14:00"
      And user selects leaving date "05/06/2021" and time "19:00"
      Then user validates parking cost for type "valet parking"

    @HalfADayValet
    Scenario: parking during half a day (12 hours)
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "00:00"
      And user selects leaving date "05/06/2021" and time "12:00"
      Then user validates parking cost for type "valet parking"

    @WholeDayValet
    Scenario: parking during a whole day (24 hours)
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "05/07/2021" and time "18:00"
      Then user validates parking cost for type "valet parking"

    @OneDayAndAFractionValet
    Scenario: parking during one day and a fraction
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "05/07/2021" and time "20:10"
      Then user validates parking cost for type "valet parking"

    @OneWeekValet
    Scenario: parking during one week
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "05/13/2021" and time "18:00"
      Then user validates parking cost for type "valet parking"

    @OneWeekAndAFractionValet
    Scenario: parking during a week and a fraction
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "05/13/2021" and time "18:05"
      Then user validates parking cost for type "valet parking"

    @TwoMonthsAndAFractionValet
    Scenario: parking during two months and a fraction
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "07/15/2021" and time "24:20"
      Then user validates parking cost for type "valet parking"