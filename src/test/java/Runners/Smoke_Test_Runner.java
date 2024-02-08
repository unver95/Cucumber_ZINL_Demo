package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "@Smoketest",
        features = {"src/test/java/Generiek/Generiek_FeatureFiles",
                "src/test/java/FeatureFiles"},
        glue = {"StepDefinitions", "Generiek.Generiek_StepDefinitions"},
             plugin = {"pretty", "json:target/cucumber/cucumberReport.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Smoke_Test_Runner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Burak Unver");
        ExtentService.getInstance().setSystemInfo("Application Name", "WEB TEAM DEMO");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "WEB Team");
        ExtentService.getInstance().setSystemInfo("Extra line", "uitleg");
        ExtentService.getInstance().setSystemInfo("Extra line", "uitleg");
        ExtentService.getInstance().setSystemInfo("Extra line", "uitleg");
        ExtentService.getInstance().setSystemInfo("Extra line", "uitleg");
    }
}