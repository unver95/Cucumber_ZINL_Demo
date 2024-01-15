package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Generiek_View {
    public Generiek_View() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"page-head\"]/h1")
    private WebElement viewTitel;
    @FindBy(xpath = "//*[@id=\"main-content\"]/dl/dd")
    private WebElement viewAlternativeText;
    @FindBy(xpath = "//small[contains(@class,\"copyright-mention\")]")
    private WebElement viewCredit;
    @FindBy(xpath = "//*[@id=\"SECT-ZIEOOK\"]/ul/li/a/h4")
    private List<WebElement> viewTags;
    @FindBy(id = "page-head")
    private WebElement paginaTitel;

/*    public WebElement getViewTitel() {
        return viewTitel;
    }

    public WebElement getViewAlternativeText() {
        return viewAlternativeText;
    }

    public WebElement getViewCredit() {
        return viewCredit;
    }

    public List<WebElement> getViewTags() {
        return viewTags;
    }*/
}

