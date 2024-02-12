package StepDefinitions.MED;

import Pages.MED.MED_Main_Content;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MED_Medicijn_Page_Steps {
    Tools ts = new Tools();
    MED_Main_Content mmc = new MED_Main_Content();
    @And("Klik op de {int}. zoekresultaat die op search verschijnen is")
    public void klikOpDeMedicijnDieOpSearchVerschijnenIs(int hoeveelste) {
        ts.waitUntilSiteIsFullLoaded();
        String strXpath = String.format("//div[@id=\"result-list\"]/a[%d]", hoeveelste);
        WebElement medicijn = GWD.getDriver().findElement(By.xpath(strXpath));
        ts.clickElement_Tools(medicijn);
    }

    @Then("Klik op het gemiddelde prijs per verpakking")
    public void klikOpHetGemiddeldePrijsPerVerpakking() {
        ts.selectByVisibleText_Tools(mmc.getMedicijnPrijs(), "Gemiddelde prijs per verpakking");
    }
}
