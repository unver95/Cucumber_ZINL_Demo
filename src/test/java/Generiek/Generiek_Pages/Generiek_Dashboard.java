package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class Generiek_Dashboard {
    public Generiek_Dashboard(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "sub-nav")
    private WebElement dahsboard;
}
