package Pages.VZIZ;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class VZIZ_HomePage {

    public VZIZ_HomePage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

}