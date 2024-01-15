package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.*;
import Utilities.Tools;
import io.cucumber.java.en.And;
import lombok.Getter;

public class Generiek_Homepage_Steps {
    Tools ts = new Tools();
    Generiek_View gv= new Generiek_View();
    Generiek_Header gh = new Generiek_Header();
    Generiek_HomePage ghp = new Generiek_HomePage();
    Generiek_GlobalNav ggn = new Generiek_GlobalNav();
    @And("Controleer de eerste link op Toptask view")
    public void controleerDeLinkOpToptaskViewVaakBekeken() {
      ts.clickElement_Tools(ghp.getTopTaskNavigationFirstLinkBy());
      ts.waitUntilElementToBeVisible_Tools(gv.getPaginaTitel());
    }

    @And("Ga naar huis pagina")
    public void gaNaarHuisPagina() {
        ts.scrollBrowserAllTheWayUp();
        ts.scrollBrowserAllTheWayUp();
        ts.clickElement_Tools(gh.getHomePageButton());
    }

    @And("Controleer de bladerbaan")
    public void controleerDeBladerbaan() {
        ts.waitUntilElementToBeVisible_Tools(ghp.getBlaaderbaan());
    }

    @And("Controleer of het tabel Verzekeraar wordt toegevoegd in de bladerbaan")
    public void controleerOfHetTabelVerzekeraarWordtToegevoegdInDeBladerbaan() {
        ts.waitUntilElementToBeVisible_Tools(ghp.getBlaaderbaanVerzekeraarTitel());
        ts.verifyElementContainsText_Tools(ghp.getBlaaderbaanVerzekeraarTitel(),"Verzekeraar");
    }

    @And("Klik op Toon overzicht om tabellen te zien")
    public void klikOpToonOverzichtOmTabellenTeZien() {
        ts.clickElement_Tools(ts.createElementByContainsTextXpath_Tools("Toon overzicht"));
    }

    @And("Kijk of de tabel wordt getoond")
    public void kijkOfDeTabelWordtGetoond() {
        ts.waitUntilElementToBeVisible_Tools(ghp.getResultTable());
    }
}
