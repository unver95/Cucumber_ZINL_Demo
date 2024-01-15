package Pages.VZIZ;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class VZIZ_Landingspagina_Pages {
    public VZIZ_Landingspagina_Pages() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(css = "[name=\"verslagjaar\"]")
    private WebElement verslagjaar;


}
