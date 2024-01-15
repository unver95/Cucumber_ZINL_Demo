package Generiek.Generiek_Pages;

import Utilities.GWD;
import Utilities.Tools;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Generiek_Login {
    Tools ts = new Tools();
    WebElement myElement;
    public Generiek_Login() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "username")
    private WebElement usernameGeneriek;

    @FindBy(id = "password")
    private WebElement passwordGeneriek;

    @FindBy(css = "[class*=\"default pat-button\"]")
    private WebElement loginGeneriek;

    /*        public void generiekLoginFindAndClick(String strElement) {
            switch (strElement) {
                case "login":
                    myElement = login;
                    break;
            }
            ts.clickElement_Tools(myElement);
        }

        public void generiekLoginFindAndSend(String strElement, String txt) {
            switch (strElement) {
                case "username":
                    myElement = username;
                    break;
                case "password":
                    myElement = password;
                    break;

            }
            ts.sendKeysElement_Tools(myElement, txt);
        }*/
/*   public WebElement getUsernameGeneriek() {
        return username;
    }

    public WebElement getPasswordGeneriek() {
        return password;
    }
    public WebElement getLoginGeneriek() {
        return login;
    }*/
}
