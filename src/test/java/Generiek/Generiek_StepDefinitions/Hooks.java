package Generiek.Generiek_StepDefinitions;

import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    Tools ts = new Tools();

    @Before
    public void beforae() {
        System.out.println("De test is gestart..");
    }


    @After
    public void after(Scenario scenario) {
        System.out.println("De test is voorbij.");
//TODO Runners siz burasi calisiyor mu diye kontrol et
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot naam");
        }
        ts.softAssertAll_Tools();
        GWD.quitDriver();
    }
}
