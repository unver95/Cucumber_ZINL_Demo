package Generiek.Generiek_StepDefinitions;

import io.cucumber.java.en.And;

import Generiek.Generiek_Pages.Generiek_Toolbar;
import Utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Generiek_Toolbar_Steps {
    Tools ts = new Tools();
    Generiek_Toolbar gt = new Generiek_Toolbar();
    @And("Klik op de + icon op de toolbar")
    public void klikOpDeIconOpDeToolbar() {
        ts.clickElement_Tools(gt.getPlus());
    }

    @And("klik op tippybox die verschijnen is")
    public void klikOpTippyboxDieVerschijnenIs() {
        ts.clickElement_Tools(gt.getTippyBox());
    }

    @When("Kijk of de afbeelding op concept staat")
    public void kijkOfDeAfbeeldingOpConceptStaat() {
        System.out.println(gt.getConcept().getText());
        ts.verifyElementContainsText_Tools(gt.getConcept(), "concept");
    }

    @And("Klik op publiceer nu")
    public void klikOpPubliceerNu() {
        ts.waitUntilSiteIsFullLoaded();
        ts.clickElement_Tools(gt.getPubliceerNu());
    }
}