@Short-Term @Regression
Feature: Valet parking scenarios

  @LessThanAnHour
  Scenario: parking during less than an hour
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "00:26"
    Then user validates parking cost for type "short-term"

  @MoreThan30Minutes
  Scenario: parking during more than 30 minutes
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "00:31"
    Then user validates parking cost for type "short-term"

  @OneHour
  Scenario: parking during 1 hour
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "01:00"
    Then user validates parking cost for type "short-term"

  @OneHourAndAFraction
  Scenario: parking during 1 hour and a fraction
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "01:03"
    Then user validates parking cost for type "short-term"

  @6Hours
  Scenario: parking during 6 hours
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:00"
    Then user validates parking cost for type "short-term"

  @6HoursAndAFraction
  Scenario: parking during 6 hours
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:29"
    Then user validates parking cost for type "short-term"

  @9HoursAndAFraction
  Scenario: parking during 9 hours and a fraction
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "09:30"
    Then user validates parking cost for type "short-term"

  @2Days
  Scenario: parking during 2 days
    When user selects type of parking "Short-Term Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/07/2021" and time "00:00"
    Then user validates parking cost for type "short-term"