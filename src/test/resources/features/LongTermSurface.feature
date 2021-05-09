@LongTermSurface @Regression
Feature: Valet parking scenarios

  @LessThanAnHourSurface
  Scenario: parking during less than an hour
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "00:48"
    Then user validates parking cost for type "long-term surface"

  @5HoursSurface
  Scenario: parking during 5 hours
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "05:00"
    Then user validates parking cost for type "long-term surface"

  @6HoursSurface
  Scenario: parking during 6 hours
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:00"
    Then user validates parking cost for type "long-term surface"

  @6HoursAndAFractionSurface
  Scenario: parking during 6 hours and a fraction
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:23"
    Then user validates parking cost for type "long-term surface"

  @9HoursSurface
  Scenario: parking during 9 hours
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "09:00"
    Then user validates parking cost for type "long-term surface"

  @2WeeksSurface
  Scenario: parking during 2 weeks
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "05/20/2021" and time "18:00"
    Then user validates parking cost for type "long-term surface"

  @4MonthsAndAFractionSurface
  Scenario: parking during 4 months and a fraction
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "09/20/2021" and time "22:30"
    Then user validates parking cost for type "long-term surface"

  @6MonthsSurface
  Scenario: parking during 6 months
    When user selects type of parking "Long-Term Surface Parking"
    And user selects entry date "05/20/2021" and time "22:00"
    And user selects leaving date "11/20/2021" and time "22:00"
    Then user validates parking cost for type "long-term surface"