package StepDefinitions.VZIZ;

import Pages.VZIZ.VZIZ_Landingspagina_Pages;
import Utilities.Tools;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;

public class VZIZ_Main_Content_Steps {
    Tools ts = new Tools();
    VZIZ_Landingspagina_Pages vlp = new VZIZ_Landingspagina_Pages();

    @And("Kijk of huidige jaar klopt") //TODO Sunuma ekle onemli
    public void klikOpTransparantiekalenderEnKijkOfHuidigeJaarKlopt() {
        LocalDate datum = LocalDate.now();
        int huidigeJaar = datum.getYear();
        int huidigeMaand = datum.getMonthValue();

        System.out.println(huidigeMaand + " " + huidigeJaar);


        int jaarCheck;

        if (huidigeMaand >= 8){
            jaarCheck = datum.getYear();
        }else {
           jaarCheck= datum.getYear()-1;
        }

        Select select = new Select(vlp.getVerslagjaar());

        WebElement option = ts.findOptionContainsText_Tools(select, Integer.toString(jaarCheck));
        ts.elementIsSelected_Tools(option);

    }
}
