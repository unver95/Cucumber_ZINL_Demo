package StepDefinitions.FK_Homepage_Steps.java;

import Generiek.Generiek_Pages.Generiek_Header;
import Generiek.Generiek_Pages.Generiek_HomePage;
import Generiek.Generiek_Pages.Generiek_View;
import Pages.FK.FK_HomePage;
import Utilities.Tools;
import io.cucumber.java.en.When;

public class FK_Homepage_Steps {
    Tools ts = new Tools();
    Generiek_View gv = new Generiek_View();
    FK_HomePage fkhp = new FK_HomePage();
    Generiek_HomePage ghp = new Generiek_HomePage();

    @When("Controleer de eerste link op Toptask view voor FK")
    public void controleerDeEersteLinkOpToptaskViewVoorFK() {
        ts.waitUntilElementToBeVisible_Tools(ghp.getTopTaskNavigation());
        ts.clickElement_Tools(fkhp.getTopTaskNavigationFirstLinkFKBy());
        ts.waitUntilElementToBeVisible_Tools(gv.getPaginaTitel());
    }
}
