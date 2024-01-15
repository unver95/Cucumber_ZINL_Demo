package StepDefinitions.FK;

import Generiek.Generiek_Pages.Generiek_GlobalNav;
import Pages.FK.FK_GlobalNav;
import Utilities.Tools;
import io.cucumber.java.en.And;

public class FK_Search_Steps {
    Tools ts = new Tools();
    Generiek_GlobalNav ggn = new Generiek_GlobalNav();
    FK_GlobalNav fgn = new FK_GlobalNav();

    @And("Zoek geneesmiddelgroep {string} op search")
    public void zoekGeneesmiddelgroepOpSearch(String arg0) {
    }

    @And("Controleer voor FK of de search result op {string} bevat")
    public void controleerVoorFKOfDeSearchResultOpBevat(String searchCategory) {
        try { //TODO Burda da Thread sleep var ancak oyle 100% calisiyor. Site neden se yavas o secekleri secerkene elimle yaptim dokunmaktik is laptopunda orda da takiliyordu yani kota sorun yok yada ben beceremedim bilmyiorum
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (searchCategory.equalsIgnoreCase("geneesmiddelen")) {
            ts.waitUntilSiteIsFullLoaded();
            ts.waitUntilElementToBeVisible_Tools(fgn.getGeneesmiddelenSearchResultNumber());
            if (!fgn.getFirstElementSearchResult().isDisplayed()) {
                ts.waitUntilElementToBeVisible_Tools(fgn.getFirstElementSearchResult());
            }
            ts.colorCheckRGB(fgn.getGeneesmiddelenSearchResultNumber(), "rgb(255, 0, 0)");

        } else if (searchCategory.equalsIgnoreCase("geneesmiddelgroepen")) {
            ts.clickElement_Tools(fgn.getGeneesmiddelgroepenSearchResult());
            ts.waitUntilElementToBeVisible_Tools(fgn.getFirstElementSearchResult());
            ts.waitUntilUrlContainsText("groep");
            ts.colorCheckRGB(fgn.getGeneesmiddelgroepenSearchResultNumber(), "rgb(255, 0, 0)");

        } else if (searchCategory.equalsIgnoreCase("indicaties")) {
            ts.clickElement_Tools(fgn.getIndicatiesSearchResult());
            ts.waitUntilElementToBeVisible_Tools(fgn.getFirstElementSearchResult());
            ts.waitUntilUrlContainsText("indicaties");
            ts.colorCheckRGB(fgn.getIndicatiesSearchResultNumber(), "rgb(255, 0, 0)");
        }
    }

    @And("Klik op het vergrootglas")
    public void klikOpHetVergrootglas() {
        ts.waitUntilSiteIsFullLoaded();
        ts.clickElement_Tools(ggn.getSubmit());
    }

    @And("klik op Geavanceerd")
    public void klikOpGeavanceerd() {
        ts.clickElement_Tools(fgn.getGeavanceerdSearchResult());
    }

    @And("Zoek {string} op zoekterm")
    public void zoekOpZoekterm(String zoekText) {
        ts.sendKeysElement_Tools(fgn.getZoekTerm(), zoekText);
    }

    @And("Zoekterm resultaten worden getoond.")
    public void zoektermResultatenWordenGetoond() {
        ts.waitUntilElementToBeVisible_Tools(fgn.getZoekTermResult());
    }
}
