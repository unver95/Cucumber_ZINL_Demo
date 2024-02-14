package z_Presentation;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/Generiek/Generiek_FeatureFiles",
                "src/test/java/FeatureFiles"},
        glue = {"StepDefinitions", "Generiek.Generiek_StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Runners_Presentation_NOT_A_CLASS {

   // @AfterClass
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


    //**************************************************************************************************\\

    // tags = "@SmokeTest" => Hier maak je tag je kan alles schrijven wat je wilt, ik heb een tag gemaakt
    //                          die "SmokeTest" heet. Hoe je het moet gebruiken is heel simple, open een
    //                          .feature file en boven Scenario schijf de tag: @SmokeTest doe dit voor alle
    //                          .feature files die je een groep wild maken.
    //                          Alleen de Tag met @SmokeTest hebben gaan werken..

    // features = {"src/test/java/Generiek/Generiek_FeatureFiles", "src/test/java/FeatureFiles"}
    //                     => Geef je de locatie van de FeatureFiles er zijn maar 2 één voor
    //                          Generiek en de andere voor aparte sites.

    //  glue = {"StepDefinitions", "Generiek.Generiek_StepDefinitions"}
    //                     => Geef je de locatie van de StepDefinitions er zijn maar 2 één voor
    //                          Generiek en de andere voor aparte sites.

    //  plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    //                     => Dit is waar we plugins kunnen gebruiken hier gebruik ik
    //                          een plugin voor external report system
}
