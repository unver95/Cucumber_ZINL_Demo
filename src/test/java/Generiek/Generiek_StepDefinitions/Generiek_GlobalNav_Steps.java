package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_FormContent;
import Generiek.Generiek_Pages.Generiek_GlobalNav;
import Generiek.Generiek_Pages.Generiek_Header;
import Pages.FK.FK_GlobalNav;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generiek_GlobalNav_Steps {
    Tools ts = new Tools();
    Generiek_Header gh = new Generiek_Header();
    Generiek_GlobalNav ggn = new Generiek_GlobalNav();
    Generiek_FormContent gfc = new Generiek_FormContent();
    FK_GlobalNav fgn = new FK_GlobalNav();


    @And("Klik op Beheer")
    public void klikOpBeheer() {
        ts.waitUntilSiteIsFullLoaded();
        try {
            ts.clickElement_Tools(ggn.getDashboard());

        } catch (StaleElementReferenceException e) {
            ts.clickElement_Tools(ggn.getDashboard());
        }
    }

    @And("Klik op Persoonlijke ruimte")
    public void klikOpPersoonlijkeRuimte() {
        ts.clickElement_Tools(ggn.getPersoonlijkeRuimte());
    }

    @And("Klik op submit")
    public void klikOpSubmit() {
        ts.clickElement_Tools(ggn.getSubmit());
    }

    @And("Zoek {string} op search")
    public void zoekOpOpSearch(String zoekText) {
        if (!GWD.getDriver().getCurrentUrl().contains("farmacotherapeutischkompas")) {
            if (!gh.getLogin().getText().contains("Ingelogd als")) {
                ts.clickElement_Tools(ggn.getGlobalSearchSubmit());
                try {
                    Thread.sleep(2000); //Todo Burda bunu kullanma nedeni biraz beklemesi gerek
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ts.robot_Press_Enter_Tools();
                if (GWD.getDriver().getCurrentUrl().contains("medicijnkosten")) {
                    ts.sendKeysElement_Tools(gfc.getZoekTrefwoordVoorMedicijnkosten(), zoekText);
                } else {
                    System.out.println(123);
                    ts.sendKeysElement_Tools(gfc.getZoekTrefwoord(), zoekText);
                    ts.robot_Press_Enter_Tools();
                }
            } else {
                ts.scrollBrowserAllTheWayUp();
                ts.clickElementFromDOM_Tools(ggn.getGlobalSearchSubmit());
                ts.clickElement_Tools(ggn.getGlobalSearchSubmit());
                try {
                    Thread.sleep(1000); //Todo Burda bunu kullanma nedeni biraz beklemesi gerek
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ts.robot_Press_Enter_Tools();
                if (GWD.getDriver().getCurrentUrl().contains("medicijnkosten")) {
                    ts.sendKeysElement_Tools(gfc.getZoekTrefwoordVoorMedicijnkosten(), zoekText);
                } else {
                    ts.sendKeysElement_Tools(gfc.getZoekTrefwoord(), zoekText);
                }
            }
        } else { // else is voor FK
            ts.sendKeysElement_Tools(ggn.getGlobalSearchTextField(), zoekText);
            ts.robot_Press_Enter_Tools();
        }
    }

    @And("Kies {string} uit select")
    //TODO Bunun Global Nav da isi ne baska yere koymak lazim bence // TODO Bide bu dinamik degil sadece tek bir yerde calisir "gfc.getSelectSterkte()" oldugu icin herkes le ortak degil bu
    public void kiesUitSelect(String selectValue) {
        ts.selectByVisibleText_Tools(gfc.getSelectSterkte(), selectValue);
    }



 /*    @Then("Kies de {int}. select en dan kies out select {string}")
    //TODO Ama bu generiek oldu "Kies {string} uit select" e gore
    public void kiesDeSelectEnDanKiesOutSelect(int selectNummer, String selectValue) {
            ts.waitUntilSiteIsFullLoaded(); //TODO Burayi Aysere at
        String xpath = String.format("(//select[@name])[%d]", selectNummer);
        System.out.println(xpath);
        WebElement webelementSelect = GWD.getDriver().findElement(By.xpath(xpath));
        System.out.println(webelementSelect.getText() + " popis");
        //ts.clickElement_Tools(webelementSelect);
        //ts.waitUntilElementToBeVisible_Tools(webelementSelect);
        System.out.println("Done yey");
        ts.selectByVisibleText_Tools(webelementSelect, selectValue);
    }*/

    @And("Klik op zoeken button op search pagina") //TODO Bunun Global Nav da isi ne baska yere koymak lazim bence
    public void klikOpZoekenButtonOpSearchPagina() {
        if (GWD.getDriver().getCurrentUrl().contains("medicijnkosten")) {
            ts.waitUntilElementToBeVisible_Tools(gfc.getSearchVorm());
        }
        ts.waitUntilElementToBeVisible_Tools(gfc.getZoekButton());
        ts.waitUntilElementToBeClickable_Tools(gfc.getZoekButton());
        ts.clickElement_Tools(gfc.getZoekButton());
    }

    @Then("Kies {string} van uit {string}") //TODO Bunun Global Nav da isi ne baska yere koymak lazim bence
    public void kiesVanUit(String value, String select) {
        ts.waitUntilSiteIsFullLoaded();
        WebElement selectElement = GWD.getDriver().findElement(By.xpath("//select[@name='" + select + "']"));
        ts.waitUntilElementToBeVisible_Tools(selectElement);
        Select select1 = new Select(selectElement);
        select1.selectByValue(value);
    }
}