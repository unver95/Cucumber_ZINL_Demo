package Pages.FK;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@FindBy
public class FK_GlobalNav {
    public FK_GlobalNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[id=\"select-geneesmiddelen\"]")
    private WebElement geneesmiddelenSearchResult;
    @FindBy(css = "[id=\"counter-medicines\"]")
    private WebElement geneesmiddelenSearchResultNumber;
    @FindBy(css = "[id=\"select-groepsteksten\"]")
    private WebElement geneesmiddelgroepenSearchResult;
    @FindBy(css = "[id=\"counter-medicine-groups\"]")
    private WebElement geneesmiddelgroepenSearchResultNumber;
    @FindBy(css = "[id=\"select-indicaties\"]")
    private WebElement indicatiesSearchResult;
    @FindBy(css = "[id=\"counter-indications\"]")
    private WebElement indicatiesSearchResultNumber;
    @FindBy(css = "[class=\"result-title\"]")
    private WebElement firstElementSearchResult;
    @FindBy(css = "[id=\"trigger-advanced-search\"]")
    private WebElement geavanceerdSearchResult;
    @FindBy(css = "[name=\"geneesmiddelen_rubriekterm_1\"]")
    private WebElement zoekTerm;
    @FindBy(css = "[class=\"result-item medicine\"]")
    private WebElement zoekTermResult;
}
