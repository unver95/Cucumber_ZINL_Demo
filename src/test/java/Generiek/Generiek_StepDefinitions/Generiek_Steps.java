package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.*;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Set;


public class Generiek_Steps {
    Tools ts = new Tools();
    Generiek_Main_Content gmc = new Generiek_Main_Content();

    Generiek_FormContent gfc = new Generiek_FormContent();

    Generiek_Landingspagina_Pages glp = new Generiek_Landingspagina_Pages();

    @Given("Klik op {string}")
    public void klikOp(String strElement) {
        ts.waitUntilSiteIsFullLoaded();
        if (strElement.contains("Contact")) {
            ts.scrollBrowserAllTheWayDown();
        }
        ts.clickElement_Tools(ts.createElementByContainsTextXpath_Tools(strElement));
    }

    @And("Kijk of de URL {string} bevat")
    public void kijkOfDeURLBevat(String URLTxt) {
        ts.waitUntilUrlContainsText(URLTxt);
    }

    @And("Voer de nodige acties uit in het {string}")
    public void voerDeNodigeActiesUitInHet(String strElement) {

        switch (strElement) {
            case "Meer nieuws":
                ts.waitUntilUrlContainsText("nieuws");
                ts.scrollBrowserAllTheWayUp();

                List<WebElement> toolbarNieuwsOverviewList = glp.getToolbarNieuwsOverview();
                for (WebElement element : toolbarNieuwsOverviewList) {
                    ts.clickElement_Tools(element);
                }
                ts.verifyURLContainsText_Tools("nieuws");
                break;

            case "Contact":
                ts.sendKeysElement_Tools(gfc.getNaamContactFormulier(), "Test Naam");
                ts.sendKeysElement_Tools(gfc.getEmail(), "test@mail.nl");
                ts.sendKeysElement_Tools(gfc.getOnderwerpContactFormulier(), "Test OnderWerp");
                ts.sendKeysElement_Tools(gfc.getReactieContactFormulier(), "Test reactie");
                ts.clickElement_Tools(gfc.getAkkoordverklaringFormulierButton1());
                ts.clickElement_Tools(gfc.getAkkoordverklaringFormulierButton2());

                if (GWD.getDriver().getCurrentUrl().contains("istandaarden")) {
                    ts.sendKeysElement_Tools(gfc.getTelefoonContactFormulier(), "+31 0000000");
                } else {
                    ts.scrollBrowserUp(1500);
                    ts.scrollBrowserAllTheWayUp();

                    System.out.println("Buraya girdi");
                    ts.clickElement_Tools(gfc.getProfessionalContactFormulierRadioButton());
                    ts.sendKeysElement_Tools(gfc.getFunctieContactFormulier(), "Testing de pagina");
                }
                ts.clickElement_Tools(gfc.getVerstuurButton());
                ts.waitUntilElementToBeVisible_Tools(gfc.getFeedbackMessageContact());
                Assert.assertTrue(gfc.getFeedbackMessageContact().getText().contains("Dankuwel"), "Het bevat geen dankuwel message");
                break;

            case "Begrippenlijst":
                ts.waitUntilSiteIsFullLoaded();
                ts.waitUntilUrlContainsText("begrippen");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;

            case "Nieuwsbrief":
                try {
                    ts.clickElement_Tools(ts.createElementByContainsTextXpath_Tools(strElement));

                } catch (StaleElementReferenceException e) {
                    try {
                        ts.waitUntilStalenessOfElement_Tools(ts.createElementByContainsTextXpath_Tools(strElement));
                        ts.clickElement_Tools(ts.createElementByContainsTextXpath_Tools(strElement));
                    } catch (Exception ignore) {
                        ts.clickElement_Tools(ts.createElementByContainsTextXpath_Tools(strElement));
                    }
                }

                String currentURL = GWD.getDriver().getCurrentUrl();
                if (!currentURL.contains("zorginzicht") && !currentURL.contains("horizonscangeneesmiddelen") && !currentURL.contains("farmacotherapeutischkompas")) {
                    ts.scrollBrowserAllTheWayUp();
                    if (!gfc.getNieuwsbriefCheckBox().isEmpty()) {
                        for (WebElement klikUnckeckedBoxe : gfc.getNieuwsbriefCheckBox()) {
                            ts.clickElement_Tools(klikUnckeckedBoxe);
                        }
                    }
                    ts.sendKeysElement_Tools(gfc.getEmail(), "test@mail.nl");
                    ts.clickElement_Tools(gfc.getVerstuurButton());
                    ts.waitUntilUrlContainsText("servicepagina/subscribe");
                    Assert.assertTrue(gfc.getFeedbackMessageNieuwsbrief().getText().contains("Dank"), "Het bevat geen dank u wel message");
                }
                break;

            case "Nieuwsbrievenarchief":
                ts.waitUntilUrlContainsText("/nieuwsbrievenarchief");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Servicedesk":
                ts.waitUntilUrlContainsText("servicedesk-istandaarden");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Archief":
                ts.waitUntilUrlContainsText("archief");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Vacatures":
                ts.waitUntilUrlContainsText("vacatures");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Over ons":
                ts.waitUntilUrlContainsText("over-team-informatiestandaarden");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Over");
                break;
            case "Copyright":
                ts.waitUntilUrlContainsText("copyright");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Privacy":
                ts.waitUntilUrlContainsText("privacy");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Cookies":
                ts.waitUntilUrlContainsText("cookies");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Toegankelijkheid":
                ts.waitUntilUrlContainsText("toegankelijkheid");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Kwetsbaarheid melden":
                ts.waitUntilUrlContainsText("kwetsbaarheid-melden");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Toelichting":
                ts.waitUntilUrlContainsText("over");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Kwaliteitstaken":
                ts.waitUntilUrlContainsText("kwaliteitstaken");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case " Veelgestelde vragen":
                ts.waitUntilUrlContainsText("veelgestelde");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Open data":
                ts.waitUntilUrlContainsText("open");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Downloads":
                ts.waitUntilUrlContainsText("downloads");
                break;
            case "export":
                ts.waitUntilUrlContainsText("export");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), strElement);
                break;
            case "Over de Horizonscan":
                ts.waitUntilUrlContainsText("over-horizonscan-geneesmiddelen");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Over de Horizonscan");
                break;
            case "About the Horizon Scan":
                ts.waitUntilUrlContainsText("about-horizonscan-geneesmiddelen");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "About the Horizon Scan");
                break;
            case "E-learning cursus FK":
                ts.switchNextTab();
                ts.waitUntilUrlContainsText("medicijngebruik");
                System.out.println(GWD.getDriver().getCurrentUrl());
                break;
            case "Mobiele apps":
                ts.waitUntilUrlContainsText("mobiele");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Mobiele apps");
                break;
            case "Help":
                ts.waitUntilUrlContainsText("help");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Help");
                break;
            case "Over deze site":
                ts.waitUntilUrlContainsText("over");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Over");
                break;
            case "Verantwoording":
                ts.waitUntilUrlContainsText("verantwoording");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Verantwoording");
                break;
            case "Proclaimer":
                ts.waitUntilUrlContainsText("proclaimer");
                ts.verifyElementContainsText_Tools(gmc.getContantTitel(), "Proclaimer");
                break;
        }
    }

    @And("Klik op Enter")
    public void klikOpEnter() {
    ts.robot_Press_Enter_Tools();
    }
}