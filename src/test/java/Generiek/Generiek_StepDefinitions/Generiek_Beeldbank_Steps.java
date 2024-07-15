package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_FormContent;
import Generiek.Generiek_Pages.Generiek_Landingspagina_Pages;
import Utilities.Tools;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Generiek_Beeldbank_Steps {
    Tools ts = new Tools();
    Generiek_FormContent dc = new Generiek_FormContent();
    Generiek_Landingspagina_Pages glp = new Generiek_Landingspagina_Pages();
    public String titel = "titel van deze test demo";
    public String alternatieveTekst = "Alternative Text voor deze demo";
    public String cc = "Copyright";
    //public String tag = "abc";
    public String auteurText = "Popis Sena";
    public static List<String> tagNamesList;

    @When("Schrijf de titel")
    public void schrijfDeTitel() {
        ts.sendKeysElement_Tools(dc.getTitelNieuweAfbeelding(), titel);
    }

    @When("Schrijf de titel op {string}")
    public void schrijfDeTitelOp(String titel) {
        ts.sendKeysElement_Tools(dc.getTitelNieuweAfbeelding(), Tools.dateTime(titel));
    }

    @And("Voeg een tag toe")
    public void voegEenTagToe(DataTable dt) {
        tagNamesList = dt.asList(String.class);
        for (String tagName : tagNamesList) {
            ts.sendKeysElement_Tools(dc.getTagNieuweAfbeelding(), tagName);
            ts.clickElement_Tools(dc.getSelecteerDeEersteTag());
        }
    }

    @And("Voeg een alternative tekst")
    public void voegEenAlternativeTekst() {
        ts.sendKeysElement_Tools(dc.getAlternatieveTekst(), alternatieveTekst);
    }

    @And("Voeg een Afbeeldingstype")
    public void voegEenAfbeeldingstype() {
        ts.selectByVisibleText_Tools(dc.getSelectAfbeeldingstype(), "Logo");
    }

    @And("Voeg een Auteursrecht")
    public void voegEenAuteursrecht() {
        ts.selectByVisibleText_Tools(dc.getSelectAuteursrecht(), cc);
    }

    @And("Als auteur zicht baar is schrijf de auteur naam")
    public void alsAuteurZichtBaarIsSchrijfDeAuteurNaam() {
        ts.recursiveFunction_Tools(dc.getAuteur(), auteurText);
    }

    @And("Schrijf de bron")
    public void schrijfDeBron() {
        ts.sendKeysElement_Tools(dc.getBron(), "https://www.nu.nl");
    }

    @And("voeg een afbeelding")
    public void voegEenAfbeelding() {
        ts.sendKeysElement_Tools(dc.getBijlageContactFormulier(), ts.addFile("56MB.png"));
    }

    @And("Klik op Bewaren")
    public void klikOpBewaren() {
        ts.clickElement_Tools(dc.getBewarenContent());
    }

    @Then("Kijk of de afbeelding fotolijst heeft en klik op de afbeelding")
    public void kijkOfDeAfbeeldingFotolijstHeeftEnKlikOpDeAfbeelding() {
        ts.waitUntilElementToBeInvisible_Tools(dc.getPanelContent());
        ts.clickElement_Tools(dc.getFirstImage());
    }

    @When("Klik op de afbeelding die gepubliceerd is")
    public void klikOpDeAfbeeldingDieGepubliceerdIs() {
        ts.clickElement_Tools(glp.getGepubliceerdeAfbeelding());
    }
}
