package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_Dashboard;
import Utilities.Tools;
import io.cucumber.java.en.And;

public class Generiek_Dahsboard_Steps {
    Tools ts = new Tools();
    Generiek_Dashboard gd = new Generiek_Dashboard();

    @And("Controleer het Dashboard van de gebruiker")
    public void controleerHetDashboardVanDeGebruiker() {
        ts.waitUntilElementToBeVisible_Tools(gd.getDahsboard());
    }
}
