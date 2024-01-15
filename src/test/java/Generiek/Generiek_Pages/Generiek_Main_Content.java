package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_Main_Content {

    public Generiek_Main_Content() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[id=\"main-content\"]")
    private WebElement contantTitel;

    @FindBy(xpath = "//div[@id=\"result-list\"]/a[{index}]")
    private WebElement kiesEnKlik1VandeZoekResultaatDieVerschijntZijn;
}
