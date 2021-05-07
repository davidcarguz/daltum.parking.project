package step_definitions;

import core.DriverManager;
import io.cucumber.java8.En;

public class Hooks extends DriverManager implements En {

    public Hooks(){
        Before(()->{
            setUpDriver();
            driver.get("https://www.shino.de/parkcalc/");
        });
        After(()->{
            finalizeDriver();
        });
    }
}
