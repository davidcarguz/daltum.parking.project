package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.time.Duration;

public class DriverManager {

    protected static WebDriver driver;

    protected void setUpDriver(){
        try {
            String nodeUrl = "http://localhost:4444/wd/hub";
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.LINUX);
            capabilities.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void initializePage(){
        PageFactory.initElements(driver,this);
    }

    protected void finalizeDriver(){
        driver.quit();
    }
}
