package Generiek.Generiek_Pages;

import Utilities.GWD;
import Utilities.Tools;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_Header {
    Tools ts = new Tools();
    WebElement myElement;
    public Generiek_Header() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(id = "login")
    private WebElement login;
    @FindBy(id = "site-header")
    private WebElement homePageButton;

/*    public void generiekHeaderFindAndClick(String strElement) {
        switch (strElement) {
            case "login":
                myElement = login;
                break;
        }
        ts.clickElement_Tools(myElement);
    }

    public void generiekHeaderElementContainsText(String strElement, String txt){
        switch (strElement){
            case "login":
                myElement = login;
                break;
        }
        ts.verifyElementContainsText_Tools(myElement, txt);
    }*/
}
