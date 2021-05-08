package step_definitions;
import io.cucumber.java8.En;
import pages.ParkingCostCalculationPage;

public class ParkingCostSteps implements En {

    private static String entryDate, entryTime, leavingDate, leavingTime;

    public ParkingCostSteps(ParkingCostCalculationPage parkingCostCalculationPage){
        When("user selects type of parking {string}", (String parkingType) -> {
            parkingCostCalculationPage.initializePage();
            parkingCostCalculationPage.selectParkingType(parkingType);
        });
        When("user selects entry date {string} and time {string}", (String date, String time) -> {
            parkingCostCalculationPage.initializePage();
            parkingCostCalculationPage.selectDate("entry",date).selectTime("entry",time);
            entryDate = date;
            entryTime = time;
        });
        When("user selects leaving date {string} and time {string}", (String date, String time) -> {
            parkingCostCalculationPage.initializePage();
            parkingCostCalculationPage.selectDate("leaving",date).selectTime("leaving",time);
            leavingDate = date;
            leavingTime = time;
        });
        Then("user validates parking cost for type {string}", (String parkingType) -> {
            parkingCostCalculationPage.initializePage();
            parkingCostCalculationPage.validateParkingCost(entryDate, entryTime, leavingDate, leavingTime);
        });
    }
}
