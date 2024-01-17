package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_GlobalNav {
    public Generiek_GlobalNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[title='Dashboard']")
    private WebElement dashboard;
    @FindBy(css = "[title='Persoonlijke ruimte']")
    private WebElement persoonlijkeRuimte;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement submit;
    @FindBy(css = "[id=\"global-nav\"]")
    private WebElement globalNav;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement globalSearchSubmit;
    @FindBy(css = "[id=\"global-search-lemma\"]")
    private WebElement globalSearchTextField;
}
