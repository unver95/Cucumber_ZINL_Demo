package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_Header;
import Generiek.Generiek_Pages.Generiek_HomePage;
import Generiek.Generiek_Pages.Generiek_Login;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Generiek_Login_Steps {

    String wachtwoord = "Welkom01!";
    String url = "https://www.";
    Tools ts = new Tools();
    Generiek_Login gl = new Generiek_Login();
    Generiek_Header gh = new Generiek_Header();
    Generiek_HomePage ghp = new Generiek_HomePage();


    @Given("Ga naar {string}") // For individual sites
    public void gaNaar(String webSite) {
        GWD.getDriver().get(url + webSite);
        System.out.println(url + webSite);
        if (GWD.getDriver().getCurrentUrl().contains("www-ac")) { // De reden waarom we dit gedaan hebben is om de Alert prompt niet hoeven te in vullen
            url = url.replace("https://", "");
            GWD.getDriver().get("https://zorginstituut:Het!1s.E1ndelijk%40Geregeld.2407@" + url + webSite); // url = www-ac.
        }
        ts.waitUntilElementToBeVisible_Tools(gh.getHomePageButton());
        ts.deleteCookieFromDOM_Tools();
    }

    @Given("Ga naar ABO sites {string}") // If it is an ABO use this it takes all the PROZIN site if used with Scenario Outline
    public void gaNaarABOSites(String webSite) {
        GWD.getDriver().get(url + webSite);
        System.out.println(url + webSite);
        if (GWD.getDriver().getCurrentUrl().contains("www-ac")) {
            url = url.replace("https://", "");
            GWD.getDriver().get("https://zorginstituut:Het!1s.E1ndelijk%40Geregeld.2407@" + url + webSite);
        }
        ts.waitUntilElementToBeVisible_Tools(gh.getHomePageButton());
    }

    @When("Klik op login")
    public void klikOpLogin() {
        ts.clickElement_Tools(gh.getLogin());
    }

    @And("Enter de naam {string}")
    public void enterDeNaam(String naam) {
        ts.sendKeysElement_Tools(gl.getUsernameGeneriek(), naam);
    }

    @And("Enter de wachtwoord")
    public void enterDeWachtwoord() {
        ts.sendKeysElement_Tools(gl.getPasswordGeneriek(), wachtwoord);
    }

    @And("Klik op in log")
    public void klikOpInLog() {
        ts.clickElementFromDOM_Tools(gl.getLoginGeneriek());
    }

    @Then("\\(Ingelogd als) moet zichtbaar zijn op de header")
    public void ingelogdAlsMoetZichtbaarZijnOpDeHeader() {

        ts.waitUntilElementDoesNotContainsText_Tools(gh.getLogin(), "Inloggen"); // wacht tot dat "Inloggen" niet meer daar staat
        ts.verifyElementContainsText_Tools(gh.getLogin(), "Ingelogd als"); // Kijk of "Ingelogd als" staat
    }
}