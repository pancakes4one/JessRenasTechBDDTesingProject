package renastech.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import renastech.util.ConfigRdr;
import renastech.util.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {
        log.info(" ::: TEST EXECUTION START ::: ");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigRdr.getProperty("url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        log.info(" ::: TEST EXECUTION END ::: ");
    }

}
