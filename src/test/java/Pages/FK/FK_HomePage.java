package Pages.FK;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FK_HomePage {
    public FK_HomePage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class=\"top-task-navigation\"]//*[@class=\"pat-inject\"])[1]")
    private WebElement topTaskNavigationFirstLinkFK;
    private By topTaskNavigationFirstLinkFKBy = By.xpath("(//*[@class=\"top-task-navigation\"]//*[@class=\"pat-inject\"])[1]");
}
