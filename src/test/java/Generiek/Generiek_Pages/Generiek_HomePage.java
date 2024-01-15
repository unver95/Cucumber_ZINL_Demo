package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_HomePage {
    public Generiek_HomePage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='top-task-navigation']")
    private WebElement topTaskNavigation;

    @FindBy(xpath = "(//*[@class=\"top-task-navigation\"]//*[@data-pat-inject=\"history: record\"])[1]")
    private WebElement topTaskNavigationFirstLink;
    private By topTaskNavigationFirstLinkBy = By.xpath("(//*[@class=\"top-task-navigation\"]//*[@data-pat-inject=\"history: record\"])[1]");

    @FindBy(css = "[class=\"cookiewarning clearfix\"]")
    private WebElement cookie; //Yhum
    @FindBy(xpath = "//form[@action=\"/databank\"]")
    private WebElement blaaderbaan;
    @FindBy(xpath = "//*[@id=\"browse-bar\"]/div/form//div[@class=\"browser-column organization pat-checklist free-form radio pat-bar-toggles multi-line pat-switch\"]/h3")
    private WebElement blaaderbaanVerzekeraarTitel;

    @FindBy(css = "[class=\"table hd\"]")
    private WebElement resultTable;


}
