package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_View;
import Utilities.Tools;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generiek_View_Steps {

    Tools ts = new Tools();
    Generiek_View gv = new Generiek_View();
    Generiek_Beeldbank_Steps dbs = new Generiek_Beeldbank_Steps();


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
        ts.waitUntilSiteIsFullLoaded();
        List<String> viewTagsStr = new ArrayList<>();
        List<String> tagNamesStr = new ArrayList<>(dbs.tagNamesList);

        for (WebElement viewTag : gv.getViewTags()) {
                viewTagsStr.add(viewTag.getText());
        }

        Collections.sort(tagNamesStr);
        System.out.println(viewTagsStr);
        System.out.println(tagNamesStr);
        Assert.isTrue(viewTagsStr.equals(tagNamesStr), "Is not equal");

/*
        for (int i = 0; i < gv.getViewTags().size(); i++) {
            System.out.println(tagNamesList);
            System.out.println(tagNamesList.get(i));
            System.out.println(gv.getViewTags().get(i).getText());
            ts.verifyElementContainsText_Tools(gv.getViewTags().get(i), tagNamesList.get(i));
        }*/

       /*     for(String tagName: tagNamesList){
                Assert.isTrue(gv.getViewTags().contains(tagName),"It doesnt contains");
            }*/
    }
}
