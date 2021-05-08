package utils;

import core.DriverManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    public static double calculateParkingCost(String parkingType,String entryDate, String entryTime, String leavingDate, String leavingTime){
        HashMap<String, Double> sortedTime = sortTime(entryDate,entryTime,leavingDate,leavingTime);
        double weeks = sortedTime.get("weeks");
        double days = sortedTime.get("days");
        double hours = sortedTime.get("hours");
        double minutes = sortedTime.get("minutes");
        double cost = 0;

        switch(parkingType){
            case "valet parking":
                double totalDays = (weeks * 7) + days;
                double totalMinutes = (hours * 60) + minutes;
                if(totalDays > 1){
                    cost = totalDays * 18;
                    if(hours > 0 || minutes > 0){
                        cost += 18;
                    }
                }else if(totalMinutes <= 300){
                    cost = 12;
                }else{
                    cost = 18;
                }
                break;

            case "short-term":
                double totalHalfHours = weeks * 336 + days * 48 + hours * 2;
                if(minutes >= 30){
                    totalHalfHours += 1;
                    minutes -= 30;
                    totalHalfHours += minutes / 30.0;
                }else{
                    totalHalfHours += minutes / 30.0;
                }
                if(days >= 1){
                    cost = days * 24;
                    totalHalfHours -= days * 48;
                }
                if(totalHalfHours >= 2 ){
                    cost += hours * 2;
                    totalHalfHours -= hours * 2;
                }
                if(totalHalfHours >= 1){
                    cost += 1;
                    totalHalfHours -= 1;
                }
                if(totalHalfHours > 0){
                    cost += 1;
                }
        }

        return cost;

    }

    private static Date stringToDate(String dateString){
        try {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static HashMap<String, Double> sortTime(String entryDate, String entryTime, String leavingDate, String leavingTime) {
        HashMap<String, Double> sortedTime = new HashMap<>();
        String entryDateTimeString = entryDate + " " + entryTime;
        String leavingDateTimeString = leavingDate + " " + leavingTime;

        Date entryDateTime = stringToDate(entryDateTimeString);
        Date leavingDateTime = stringToDate(leavingDateTimeString);

        long timeInMillis = Math.abs(leavingDateTime.getTime() - entryDateTime.getTime());
        long timeInMinutes = TimeUnit.MINUTES.convert(timeInMillis, TimeUnit.MILLISECONDS);

        double weeks = 0.0;
        double days = 0.0;
        double hours = 0.0;
        double minutes = (double) timeInMinutes;
        double fraction;
        double integer;

        if (minutes >= 10080) {
            integer = minutes / 10080.0;
            fraction = integer % 1;
            weeks = integer - fraction;
            minutes = minutes - weeks * 10080.0;
        }

        if (minutes >= 1440) {
            integer = minutes / 1440.0;
            fraction = integer % 1;
            days = integer - fraction;
            minutes = minutes - days * 1440;
        }

        if (minutes >= hours) {
            integer = minutes / 60.0;
            fraction = integer % 1;
            hours = integer - fraction;
            minutes = minutes - hours * 60;
        }
        sortedTime.put("weeks" , weeks);
        sortedTime.put("days" , days);
        sortedTime.put("hours" , hours);
        sortedTime.put("minutes" , minutes);

        return sortedTime;
    }
}
