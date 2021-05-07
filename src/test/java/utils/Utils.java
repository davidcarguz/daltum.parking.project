package utils;

import core.DriverManager;

import java.util.Set;

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

}
