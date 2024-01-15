package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_Toolbar {
    public Generiek_Toolbar() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains (@class, 'button icon-plus')]")
    private WebElement plusWithText;

    @FindBy(xpath = "//a[@class=\"icon new pat-tooltip tooltip-inactive\"]")
    private WebElement plus;

    @FindBy(xpath = "//div[@class=\"tippy-content\"]")
    private WebElement tippyBox;

    @FindBy(xpath = "//select[@name=\"versie\"]")
    private WebElement concept;
    @FindBy(xpath = "//button[@id=\"modal-main-submit\"]")
    private WebElement publiceerNu;

/*    public WebElement getPlusWithText() {
        return plusWithText;
    }

    public WebElement getPlus() {
        return plus;
    }

    public WebElement getTippyBox() {
        return tippyBox;
    }

    public WebElement getConcept() {
        return concept;
    }

    public WebElement getPubliceerNu() {
        return publiceerNu;
    }*/
}

