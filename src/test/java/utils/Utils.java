package utils;

import core.DriverManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Utils extends DriverManager {

    private static String mainWindow;


    public static void switchToSecondWindow(){
        mainWindow = driver.getWindowHandle();
        Set<String> openWindows = driver.getWindowHandles();
        for(String window : openWindows){
            if(!window.contentEquals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
    }
    public static void switchBackToMainWindow(){
        driver.switchTo().window(mainWindow);
    }

    public static void calculateParkingCost(String entryDate, String entryTime, String leavingDate, String leavingTime){

        String entryDateTimeString = entryDate+" "+entryTime;
        String leavingDateTimeString = leavingDate+" "+leavingTime;

        Date entryDateTime = stringToDate(entryDateTimeString);
        Date leavingDateTime = stringToDate(leavingDateTimeString);

        long timeInMillis = Math.abs(leavingDateTime.getTime() - entryDateTime.getTime());
        long timeInMinutes = TimeUnit.MINUTES.convert(timeInMillis,TimeUnit.MILLISECONDS);

        double weeks = 0.0;
        double days = 0.0;
        double hours = 0.0;
        double minutes = (double) timeInMinutes;
        double fraction;
        double integer;

        if(minutes >= 10080){
            integer = minutes / 10080.0;
            fraction = integer % 1;
            weeks = integer - fraction;
            minutes = minutes - weeks * 10080.0;
        }

        if(minutes >= 1440){
            integer = minutes / 1440.0;
            fraction = integer - 1;
            days = integer - fraction;
            minutes -= days*1440;
        }

        if(minutes >= hours){
            integer = minutes / 60.0;
            fraction = integer % 1;
            hours = integer - fraction;
            minutes -= hours*60;
        }

        minutes = timeInMinutes;

        System.out.println("weeks: "+weeks+" days: "+days+" hours: "+hours+" minutes: "+minutes);

    }

    private static Date stringToDate(String dateString){
        try {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
