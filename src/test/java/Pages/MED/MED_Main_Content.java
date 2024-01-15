package Pages.MED;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MED_Main_Content {
    public MED_Main_Content(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name=\"inline-days\"]")
    private WebElement medicijnPrijs;
}
