package pages;

import core.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import static utils.Utils.*;

public class ParkingCostCalculationPage extends DriverManager {

    @FindBy(how = How.CSS , using = "select[name = 'ParkingLot']")
    WebElement drp_parkingType;

    @FindBy(how = How.XPATH , using = "//input[@id = 'StartingDate']//following-sibling::a/img")
    WebElement img_entryCalendar;

    @FindBy(how = How.XPATH , using = "//input[@id = 'LeavingDate']//following-sibling::a/img")
    WebElement img_leavingCalendar;

    @FindBy(how = How.CSS , using = "select[name = 'MonthSelector']")
    WebElement drp_month;

    @FindBy(how = How.XPATH , using = "//b/font[text() = '<']")
    WebElement btn_yearLess;

    @FindBy(how = How.XPATH , using = "//b/font[text() = '>']")
    WebElement btn_yearMore;

    @FindBy(how = How.XPATH, using = "(//font[@face = 'Verdana']/b)[1]")
    WebElement lbl_year;

    @FindBy(how = How.CSS , using = "input[name = 'StartingTime']")
    WebElement edt_entryTime;

    @FindBy(how = How.CSS , using = "input[name = 'LeavingTime']")
    WebElement edt_leavingTime;

    @FindBy(how = How.CSS , using = "span[class = 'SubHead'] b")
    WebElement lbl_cost;

    @FindBy(how = How.CSS , using = "input[type = 'submit']")
    WebElement btn_calculate;

    @FindBy(how = How.CSS , using = "td[class = 'SubHead'] b")
    WebElement lbl_error;

    public void selectParkingType(String parkingType) {
        try {
            Select slt_parkingType = new Select(drp_parkingType);
            slt_parkingType.selectByVisibleText(parkingType);
        }catch(Exception e){
            throw new Error("An error occurred when selecting parking type.",e);
        }
    }


    public ParkingCostCalculationPage selectDate(String type, String date) {
        try {
            if (type.equalsIgnoreCase("entry")) {
                img_entryCalendar.click();
            } else if (type.equalsIgnoreCase("leaving")) {
                img_leavingCalendar.click();
            }
            switchToSecondWindow();

            String[] dateArray = date.split("/");
            int month = Integer.parseInt(dateArray[0])-1;
            int day = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            Select slt_month = new Select(drp_month);
            slt_month.selectByIndex(month);
            boolean correctYear = false;
            while(!correctYear){
                int yearSelected = Integer.parseInt(lbl_year.getText());
                if(yearSelected<year){
                    btn_yearMore.click();
                }else if(yearSelected>year){
                    btn_yearLess.click();
                }else{
                    correctYear = true;
                }
            }
            driver.findElement(By.xpath("//a[text() = '"+day+"']")).click();

            switchBackToMainWindow();

            return this;

        }catch (Exception e){
            throw new Error("An error occurred when setting "+type+" date through calendar page.", e);
        }
    }

    public void selectTime(String type, String time) {
        try{
            if(type.equalsIgnoreCase("entry")){
                edt_entryTime.clear();
                edt_entryTime.sendKeys(time);
            }else if(type.equalsIgnoreCase("leaving")){
                edt_leavingTime.clear();
                edt_leavingTime.sendKeys(time);
            }
        }catch (Exception e){
            throw new Error("An error occurred when setting the "+type+" time.", e);
        }
    }

    public ParkingCostCalculationPage clickOnCalculateButton(){
        try{
            btn_calculate.click();
        }catch(Exception e){
            throw new Error("An error occurred when trying to click on Calculate button", e);
        }
        return this;
    }

    public void validateParkingCost(String parkingType,String entryDate, String entryTime, String leavingDate, String leavingTime) {
        System.out.println("COST= "+calculateParkingCost(parkingType,entryDate, entryTime, leavingDate, leavingTime));
        double calculatedCost = calculateParkingCost(parkingType,entryDate, entryTime, leavingDate, leavingTime);
        double obtainedCost = Double.parseDouble(lbl_cost.getText().replaceAll("[^0-9.]",""));
        Assert.assertEquals(calculatedCost , obtainedCost , 0.0);
    }

    public void validateErrorMessage(String errorMessage) {
        try{
            String errorObtained = lbl_error.getText();
            Assert.assertEquals(errorMessage, errorObtained);
        }catch (Exception e){
            throw new Error("An error occurred validating the error message.", e);
        }
    }

    public void validateCost(String cost) {
        try{
            double givenCost = Double.parseDouble(cost);
            String rawObtainedCost = lbl_cost.getText().replaceAll("[^0-9.]" , "");
            double obtainedCost = Double.parseDouble(rawObtainedCost);
            Assert.assertTrue(obtainedCost == givenCost);
        }catch(Exception e){
            throw new Error("Error validating the cost.", e);
        }
    }
}