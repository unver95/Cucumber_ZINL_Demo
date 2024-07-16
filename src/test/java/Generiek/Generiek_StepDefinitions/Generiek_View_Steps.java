package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_View;
import Utilities.Tools;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generiek_View_Steps {

    Tools ts = new Tools();
    Generiek_View gv = new Generiek_View();
    Generiek_Beeldbank_Steps dbs = new Generiek_Beeldbank_Steps();
    public static List<String> tagEmptyNamesList;


    @And("kijk of de Titel {string} heeft")
    public void kijkOfDeTitelHeeft(String ticketCode) {
        ts.waitUntilSiteIsFullLoaded();
        ts.verifyElementContainsText_Tools(gv.getViewTitel(), Tools.dateTime(ticketCode));
    }

    @And("Kijk of de Alternative tekst correct staat")
    public void kijkOfDeAlternativeTekstCorrectStaat() {
        ts.verifyElementContainsText_Tools(gv.getViewAlternativeText(), dbs.alternatieveTekst);
    }


    @And("Kijk of de CC correct staat")
    public void kijkOfDeCCCorrectStaat() {
        ts.verifyElementContainsText_Tools(gv.getViewCredit(), dbs.auteurText);
    }

    @And("Kijk of de Tag correct staat")
    public void kijkOfDeTagCorrectStaat() {
        List<String> tagSortedNamesList = tagEmptyNamesList.stream().sorted().collect(Collectors.toList());
        Generiek_View gv = new Generiek_View();
        ts.waitUntilSiteIsFullLoaded();

        for (int i = 0; i < gv.getZieOokTagsList().size(); i++) {
            ts.verifyElementContainsText_Tools(gv.getZieOokTagsList().get(i), tagSortedNamesList.get(i));
        }
    }
}