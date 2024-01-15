package Generiek.Generiek_StepDefinitions;

import Generiek.Generiek_Pages.Generiek_GlobalNav;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Generiek_Web_Browser_Steps {
    Tools ts = new Tools();
    Generiek_GlobalNav gg = new Generiek_GlobalNav();
    JavascriptExecutor js;

    @And("Ga terug via web browser")
    public void gaTerugViaWebBrowser() {
        ts.waitUntilElementToBeVisible_Tools(gg.getGlobalNav());
        GWD.getDriver().navigate().back();
    }

    @And("Scroll {int} unit naar beneden")
    public void scrollNaarBeneden(int px) {
        js = (JavascriptExecutor) GWD.getDriver();
        //js.executeScript("window.scrollBy(0, 6500);");
        js.executeScript("window.scrollBy(0," + px + ");");
        System.out.println("scroll");
    }

    @And("Scroll {int} unit naar boven en {int} unit naar beneden")
    public void scrollUnitNaarBovenEnNaarBeneden(int pxUp, int pxDown) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollBy(" + pxUp + "," + pxDown + ");");
        System.out.println("scroll");
    }

    @And("Scroll helemaal naar beneden")
    public void scrollHelemaalNaarBeneden() {
        ts.waitUntilSiteIsFullLoaded();
        ts.scrollBrowserAllTheWayDown();
    }

    @And("Scroll helemaal naar boven")
    public void scrollHelemaalNaarBoven() {
        ts.waitUntilSiteIsFullLoaded();
        ts.scrollBrowserAllTheWayUp();
    }
}