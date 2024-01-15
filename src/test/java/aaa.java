import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class aaa {

    @Test
    public static void test() {
        GWD.getDriver().get("https://www.farmacotherapeutischkompas.nl/");

        WebElement element = GWD.getDriver().findElement(By.cssSelector("[id=\"global-nav\"]"));
        String c = element.getCssValue("background-color");
        Color color = Color.fromString(c);

        String hx = color.asHex();
        System.out.println(hx);
    }
}