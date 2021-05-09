@EconomyParking @Regression
Feature: Valet parking scenarios

  @LessThanAnHourEconomy
  Scenario: parking during less than an hour
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "00:48"
    Then user validates parking cost for type "economy parking"

  @5HoursEconomy
  Scenario: parking during 5 hours
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "05:00"
    Then user validates parking cost for type "economy parking"

  @6HoursEconomy
  Scenario: parking during 6 hours
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:00"
    Then user validates parking cost for type "economy parking"

  @6HoursAndAFractionEconomy
  Scenario: parking during 6 hours and a fraction
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "06:23"
    Then user validates parking cost for type "economy parking"

  @9HoursEconomy
  Scenario: parking during 9 hours
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "00:00"
    And user selects leaving date "05/06/2021" and time "09:00"
    Then user validates parking cost for type "economy parking"

  @2WeeksEconomy
  Scenario: parking during 2 weeks
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "05/20/2021" and time "18:00"
    Then user validates parking cost for type "economy parking"

  @4MonthsAndAFractionEconomy
  Scenario: parking during 4 months and a fraction
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/06/2021" and time "18:00"
    And user selects leaving date "09/20/2021" and time "22:30"
    Then user validates parking cost for type "economy parking"

  @6MonthsEconomy
  Scenario: parking during 6 months
    When user selects type of parking "Economy Parking"
    And user selects entry date "05/20/2021" and time "22:00"
    And user selects leaving date "11/20/2021" and time "22:00"
    Then user validates parking cost for type "economy parking"