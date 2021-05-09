@TimeValidations
  Feature: Scenarios related to time validations perform by the application

    @EarlierLeavingDate
    Scenario: Select earlier leaving date than entry date
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/09/2021" and time "00:00"
      And user selects leaving date "05/06/2021" and time "12:00"
      Then user validates error message "ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME"

    @EarlierLeavingTime
    Scenario: Select earlier leaving time than entry time
      When user selects type of parking "Valet Parking"
      And user selects entry date "05/06/2021" and time "18:00"
      And user selects leaving date "05/06/2021" and time "16:00"
      Then user validates parking cost should be "0.0"

    @NoDataInserted
    Scenario: No data inserted for date
      Then user validates error message "ERROR! ENTER A CORRECTLY FORMATTED DATE"
