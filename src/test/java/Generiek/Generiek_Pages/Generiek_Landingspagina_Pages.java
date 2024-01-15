package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class Generiek_Landingspagina_Pages {

    public Generiek_Landingspagina_Pages() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"item image  pat-inject \"]")
    private WebElement gepubliceerdeAfbeelding;
    @FindBy(xpath = "//*[@id=\"news-feed\"]/article[1]/a/figure/img")
    private WebElement eersteNieuwsAfbeelding;
    @FindBy(css = "[class=\"item-title\"]")
    private WebElement nieuwsPaginaTitel;
    @FindBy(css = "[class=\"button unchecked\"]")
    private List<WebElement> toolbarNieuwsOverview;
    @FindBy(id = "page-intro")
    private WebElement pageIntro;
}
