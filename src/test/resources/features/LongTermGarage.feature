@LongTermGarage @Regression
Feature: Valet parking scenarios

  @LessThanAnHourGarage
  Scenario: parking during less than an hour
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "00:48"
    Then user validates parking cost for type "long-term garage"

  @5HoursGarage
  Scenario: parking during 5 hours
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "05:00"
    Then user validates parking cost for type "long-term garage"

  @6HoursGarage
  Scenario: parking during 6 hours
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:00"
    Then user validates parking cost for type "long-term garage"

  @6HoursAndAFractionGarage
  Scenario: parking during 6 hours and a fraction
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:23"
    Then user validates parking cost for type "long-term garage"

  @9HoursGarage
  Scenario: parking during 9 hours
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "09:00"
    Then user validates parking cost for type "long-term garage"

  @2WeeksGarage
  Scenario: parking during 2 weeks
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "05/20/2021" and time "18:00"
    Then user validates parking cost for type "long-term garage"

  @4MonthsAndAFractionGarage
  Scenario: parking during 4 months and a fraction
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "09/20/2021" and time "22:30"
    Then user validates parking cost for type "long-term garage"

  @6MonthsGarage
  Scenario: parking during 6 months
    When user selects type of parking "Long-Term Garage Parking"
    And user selects entry date "05/20/2021" and time "22:00"
    And user selects leaving date "11/20/2021" and time "22:00"
    Then user validates parking cost for type "long-term garage"