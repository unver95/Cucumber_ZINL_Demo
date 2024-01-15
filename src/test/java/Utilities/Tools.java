package Utilities;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.FileSystems;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Tools extends GWD {
    Robot robot;
    JavascriptExecutor js;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    //! Wait Methods
    //****************************************************************************//
    public void waitUntilSiteIsFullLoaded() {
        GWD.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitUntilElementToBePresence_Tools(By byElement) { // Waits until present on the DOM but not maybe not be visible
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

    public void waitUntilElementToBeVisible_Tools(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.isTrue(element.isDisplayed(), "The element wasn't displayed");
    }


    public void waitUntilElementToBeInvisible_Tools(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitUntilElementContainsText_Tools(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    public void waitUntilElementDoesNotContainsText_Tools(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    public void waitUntilStalenessOfElement_Tools(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitUntilVisibilityOfElementLocated_Tools(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }

    public void waitUntilElementToBeClickable_Tools(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilUrlContainsText(String urlText) {
        wait.until(ExpectedConditions.urlContains(urlText));
    }

    //! Scroll Methods
//****************************************************************************//
    public void scrollToElement_Tools(WebElement element) {
        waitUntilElementToBeVisible_Tools(element);
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollBrowserAllTheWayUp() {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void scrollBrowserAllTheWayDown() {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollBrowserUp(int px) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, -" + px + ")");
    }

    public void scrollBrowserDown(String px) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, " + px + ")");

    }

//! Click Methods
//****************************************************************************//

    public boolean checkElementNotPresent_Tools(WebElement element) {
        return element == null; //TODO Bu cok sacma oldu oncesini yazmamisiz mesela Assert yok
    }

    public void clickElementFromDOM_Tools(WebElement element) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void deleteCookieFromDOM_Tools() { // Use this until the "Cookies cant be close" bug has been fixed
        js = (JavascriptExecutor) GWD.getDriver();

        while (true) {
            List<WebElement> cookies = GWD.getDriver().findElements(By.cssSelector("[class=\"cookiewarning clearfix\"]"));
            if (cookies.isEmpty()) {
                break; // Eğer liste boşsa, döngüyü sonlandır
            } else {
                WebElement cookie = cookies.get(0);
                js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", cookie);
            }
        }
    }

    public void clickElement_Tools(WebElement element) {
        // js = (JavascriptExecutor) GWD.getDriver();
        try {
            waitUntilElementToBeVisible_Tools(element);

            waitUntilElementToBeClickable_Tools(element);

            element.click();

        } catch (Exception ignore) {
            //js.executeScript("window.scrollBy(0, 6500);");
            //element.click();
            //Actions actions = new Actions(GWD.getDriver());
            //actions.moveToElement(element).perform();
            //   js.executeScript("arguments[0].scrollIntoView(true);", element);
            waitUntilElementToBeVisible_Tools(element);
            waitUntilElementToBeClickable_Tools(element);
            element.click();
        }
    }

    public void clickElement_Tools(By byElement) {
        waitUntilElementToBePresence_Tools(byElement);
        WebElement element = GWD.getDriver().findElement(byElement);
        waitUntilElementToBeVisible_Tools(element);
        waitUntilElementToBeClickable_Tools(element);
        element.click();
    }

    public void sendKeysElement_Tools(WebElement element, String value) {
        js = (JavascriptExecutor) GWD.getDriver();

        try {
            waitUntilElementToBeVisible_Tools(element);
            scrollToElement_Tools(element);
            element.clear();
            element.sendKeys(value);
        } catch (Exception ingore) {
            waitUntilElementToBeVisible_Tools(element);
            scrollToElement_Tools(element);
            //js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(value);
        }
    }

    public void verifyElementContainsText_Tools(WebElement element, String text) {
        Assert.isTrue(element.getText().toLowerCase().contains(text.toLowerCase()), "Doesn't contains: " + text);
    }

    public void verifyURLContainsText_Tools(String URLtext) {
        //  softAssert.assertTrue(GWD.getDriver().getCurrentUrl().contains(URLtext), "De URL bevat geen: " + URLtext);
        Assert.isTrue(GWD.getDriver().getCurrentUrl().contains(URLtext), "De URL bevat geen: " + URLtext);

    }

    public void elementIsSelected_Tools(WebElement element) {
        Assert.isTrue(element.isSelected(), "De element is niet geselecteerd");
    }

    public WebElement findOptionContainsText_Tools(Select dropdown, String partialText) {
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().contains(partialText)) {
                return option;
            }
        }
        return null; // Eğer eşleşen seçenek bulunamazsa null döndürür
    }

    public void colorCheckHex(WebElement element, String colorCode) {
        String c = element.getCssValue("background-color");
        Color color = Color.fromString(c);
        String hx = color.asHex();

        Assert.isTrue(hx.equals(colorCode), "De kleur komt niet overeen, Actual color is: " + hx);
    }

    public void colorCheckRGB(WebElement element, String colorCode) {
        try {
            String c = element.getCssValue("background-color");
            Color color = Color.fromString(c);
            String rgb = color.asRgb();
            Assert.isTrue(rgb.equals(colorCode), "De kleur komt niet overeen, Actual color is: " + rgb);
        }
        catch (StaleElementReferenceException e){
            //waitUntilStalenessOfElement_Tools(element);
            System.out.println("Color Check staleness");
            String c = element.getCssValue("background-color");
            Color color = Color.fromString(c);
            String rgb = color.asRgb();
            Assert.isTrue(rgb.equals(colorCode), "De kleur komt niet overeen, Actual color is: " + rgb);
        }
    }

    public WebElement createElementByPartialLinkText(String txt) {
        WebElement element = null;

        try {
            element = GWD.getDriver().findElement(By.partialLinkText(txt));
        } catch (StaleElementReferenceException e) {
            element = GWD.getDriver().findElement(By.partialLinkText(txt));
        }
        return element;
    }

    public WebElement createElementByLinkText(String txt) {
        WebElement element = null;

        try {
            element = GWD.getDriver().findElement(By.linkText(txt));
        } catch (StaleElementReferenceException e) {

            element = GWD.getDriver().findElement(By.linkText(txt));
        }
        return element;
    }

    public WebElement createElementByContainsTextXpath_Tools(String txt) {
        WebElement element = null;
        try {
            element = GWD.getDriver().findElement(By.xpath("//*[contains(text(),'" + txt + "')]"));
        } catch (StaleElementReferenceException e) {
            waitUntilStalenessOfElement_Tools(element);
            element = GWD.getDriver().findElement(By.xpath("//*[contains(text(),'" + txt + "')]"));
        }
        return element;
    }

    public void selectByVisibleText_Tools(WebElement element, String text) {
        waitUntilElementToBeVisible_Tools(element);
        Select drpdwn = new Select(element);
        drpdwn.selectByVisibleText(text);
    }

    public void selectByValueText_Tools(WebElement element, String text) {
        waitUntilElementToBeVisible_Tools(element);
        Select drpdwn = new Select(element);
        drpdwn.selectByValue(text);
    }

    public void recursiveFunction_Tools(WebElement element, String text) {
        //if(element.getAttribute("data-value") == null){
        if (!Objects.equals(element.getAttribute("data-value"), text)) {
            sendKeysElement_Tools(element, text);
            recursiveFunction_Tools(element, text);
        }
    }

    public void switchNextTab() {
        for (String winHandle : GWD.getDriver().getWindowHandles()) {
            GWD.getDriver().switchTo().window(winHandle);
        }
    }

    public void robotClass_TAB_ENTER(int TAB, int Enter) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < TAB; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        for (int i = 0; i < Enter; i++) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        robot.setAutoDelay(2000);
    }


    // Hier onder maakt die een datum en tijd maar 1 keer per test en die datum kunnen we op onze document gebruiken dat we gaan uploaden.
    private static String StaticDateTime = "";

    public static String dateTime(String ticketCode) {
        if (StaticDateTime.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            int Day = cal.get(Calendar.DAY_OF_MONTH);
            int Maand = cal.get(Calendar.MONTH) + 1;
            int Jaar = cal.get(Calendar.YEAR);
            int Uur = cal.get(Calendar.HOUR_OF_DAY);
            int Minute = cal.get(Calendar.MINUTE);
            int Seconde = cal.get(Calendar.SECOND);

            StaticDateTime = String.format("%02d/%02d/%04d %02d:%02d:%02d", Day, Maand, Jaar, Uur, Minute, Seconde);
        }
        return ticketCode + " " + StaticDateTime;
    }


    public void softAssertAll_Tools() {
        softAssert.assertAll(); //TODO Daha sonar bakilmasi gerek. soft Assert mu yapacagiz yoksa normal assert mu kalmasi gerekiyor karar veremiyoruz. Soft assert yapmak en iyisi gibi ama yapamadik
    }

    public String addFile(String bestanNaam) { // Alleen voor windows
        String folderName = "_Files";
        String fileName = bestanNaam;

        String projectPath = System.getProperty("user.dir");
        String filePath = folderName + FileSystems.getDefault().getSeparator() + fileName;

        String fullPath = projectPath + FileSystems.getDefault().getSeparator() + "src" + FileSystems.getDefault().getSeparator() + "test" + FileSystems.getDefault().getSeparator() + "java" + FileSystems.getDefault().getSeparator() + filePath;
        System.out.println("Bestand Path: " + fullPath);
        return fullPath;
    }

    public void robot_Clipboard_Paste_Enter_Tools(String path) {
        StringSelection selection = new StringSelection(path);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(selection, selection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease((KeyEvent.VK_V));

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void robot_Press_Enter_Tools() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}