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
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));

    //****************************************************************************//
    //! Wait Methods
    //****************************************************************************//

    //Gebruik deze alleen waneer je op een request moet wachten
    public void hardWait(int sec){
        try {
            System.out.println(sec);
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //? Wacht tot dat de website 100% geladen is. Het is goed om dit altijd te gebruiken, soms duurt element te lang om te laden die we eens niet nodig hebben.
    public void waitUntilSiteIsFullLoaded() {
        GWD.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //? Wacht tot de element om de DOM verschijnt
    public void waitUntilElementToBePresence_Tools(By byElement) { // Waits until present on the DOM but not maybe not be visible
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

    //? Wacht tot de element niet zichtbaar is voor de end user maar is zichtbaar op DOM
    public void waitUntilElementToBeVisible_Tools(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.isTrue(element.isDisplayed(), "The element wasn't displayed");
    }

    //TODO ToBe => is
    // ? Wacht tot de element niet zicht baar is voor de end user maar is zichtbaar op DOM
    public void waitUntilElementToBeInvisible_Tools(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //? Wacht tot dat het element de tekst bevat dat je hebt geschreven.
    public void waitUntilElementContainsText_Tools(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    //? Wacht tot dat de element de text niet bevat.
    //! Element en de text die je wilt checken geef je zelf
    public void waitUntilElementDoesNotContainsText_Tools(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    //? Wacht tot dat element niet meer stale is
    //! Geen idee of de werkt... ¯\_(ツ)_/¯
    public void waitUntilStalenessOfElement_Tools(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    //? Wacht tot de element verschijnt op DOM
    public void waitUntilVisibilityOfElementLocated_Tools(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }

    //? Wacht tot dat de element klikbaar IS
    public void waitUntilElementToBeClickable_Tools(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //? Wacht tot de URL bevat de tekst dat je gegeven hebt
    public void waitUntilUrlContainsText(String urlText) {
        wait.until(ExpectedConditions.urlContains(urlText));
    }

    //? TODO: BURAYA ACIKLAMA YAPILACAK
    public void waitUntilElementsListSizeIs(By  byList,int size) {
        wait.until(ExpectedConditions.numberOfElementsToBe(byList,size));
    }
    //? TODO: BURAYA ACIKLAMA YAPILACAK
    public void waitUntilURLDoesNotContainsText(String urlText){wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(urlText)));}

    //****************************************************************************//
    //! Scroll Methods
    //****************************************************************************//

    //? Wacht tot de element op de site verschijnt dan scroll naar de element
    public void scrollToElement_Tools(WebElement element) {
        waitUntilElementToBeVisible_Tools(element);
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //? Scrol helemaal naar boven
    public void scrollBrowserAllTheWayUp() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }

    //? Scrol helemaal naar beneden
    public void scrollBrowserAllTheWayDown() {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //? Scrolled naar boven hoeveel pixel/Unit je gegeven hebt
    //! Je roept de functie en voer een int in
    public void scrollBrowserUp(int px) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, -" + px + ")");
    }

    //? Scrolled naar beneden hoeveel pixel/Unit je gegeven hebt
    //! Je roept de functie en voer een int in
    public void scrollBrowserDown(String px) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, " + px + ")");

    }

    //****************************************************************************//
    //! Do stuff from DOM
    //****************************************************************************//

    //? Klik het element op de DOM
    // ** Gebruik dit niet. Dit is niet hoe de end user de site gebruikt
    public void clickElementFromDOM_Tools(WebElement element) {
        js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    //? Delete de Cookie bar op de DOM
    // ** De reden dat ik dit gebruik is om dat onze Cookie bar niet goed werkt
    public void deleteCookieFromDOM_Tools() { // Use this until the "Cookies cant be close" bug has been fixed
        js = (JavascriptExecutor) GWD.getDriver();

        while (true) {
            List<WebElement> cookies = GWD.getDriver().findElements(By.cssSelector("[class=\"cookiewarning clearfix\"]"));
            if (!cookies.isEmpty()) {
                WebElement cookie = cookies.get(0);
                js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", cookie);
                break; // Eğer liste boşsa, döngüyü sonlandır
            }
        }
    }

    //****************************************************************************//
    //! Click Methods
    //****************************************************************************//

    //? Wacht tot dat de element verschijnt en da wacht tot de element klikbaar is en dan klik op de element
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

    //? Wacht tot dat de element verschijnt en da wacht tot de element klikbaar is en dan klik op de element
    public void clickElement_Tools(By byElement) {
        waitUntilElementToBePresence_Tools(byElement);
        WebElement element = GWD.getDriver().findElement(byElement);
        waitUntilElementToBeVisible_Tools(element);
        waitUntilElementToBeClickable_Tools(element);
        element.click();
    }
    //****************************************************************************//
    //! ???????????????
    //****************************************************************************//

    //? Wacht tot de element zichtbaar is en dan scroll naar de element en dan verwijder de text en dan stuur de text dat je wild
    //! Eerst schrijf de element waar je de tekst wild schrijven daarna schrijf de tekst dat je wil stuuren
    public void sendKeysElement_Tools(WebElement element, String value) {
        js = (JavascriptExecutor) GWD.getDriver();

        try {
            waitUntilElementToBeVisible_Tools(element);
            scrollToElement_Tools(element);
            element.clear();
            element.sendKeys(value);
        } /*catch (StaleElementReferenceException e) {
            //TODO
            System.out.println(e);
            }*/ catch (Exception message) {
            System.out.println(message.getMessage());
            waitUntilElementToBeVisible_Tools(element);
            scrollToElement_Tools(element);
            //js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(value);
        }
    }

    //****************************************************************************//
    //! Verify
    //****************************************************************************//
    //TODO _ sil

    //? Kijkt of de element de text dat je geschreven hebt bevat
    public void verifyElementContainsText_Tools(WebElement element, String text) {
        Assert.isTrue(element.getText().toLowerCase().contains(text.toLowerCase()), "Doesn't contains: " + text);
    }

    //? Kijkt of de URL bevat de tekst dat je hebt geschreven
    public void verifyURLContainsText_Tools(String URLtext) {
        //  softAssert.assertTrue(GWD.getDriver().getCurrentUrl().contains(URLtext), "De URL bevat geen: " + URLtext);
        Assert.isTrue(GWD.getDriver().getCurrentUrl().contains(URLtext), "De URL bevat geen: " + URLtext);

    }

    //? Kijkt of de element geselecteerd is
    public void elementIsSelected_Tools(WebElement element) {
        Assert.isTrue(element.isSelected(), "De element is niet geselecteerd");
    }

    //? Het krijgt het vervolgkeuzemenu en dankzij de getOptions-methode kunnen we alle opties van het WebElement één voor één oproepen en vervolgens controleren of de WebElement-tekst overeenkomt met wat we in het tweede argument hebben geschreven.
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

    public void softAssertAll_Tools() {
        softAssert.assertAll(); //TODO Daha sonar bakilmasi gerek. soft Assert mu yapacagiz yoksa normal assert mu kalmasi gerekiyor karar veremiyoruz. Soft assert yapmak en iyisi gibi ama yapamadik YOK EN IYISI DEGILMIS GELECEKTEKI KANKILER
    }

    public void colorCheckRGB(WebElement element, String colorCode) {
        try {
            String c = element.getCssValue("background-color");
            Color color = Color.fromString(c);
            String rgb = color.asRgb();
            Assert.isTrue(rgb.equals(colorCode), "De kleur komt niet overeen, Actual color is: " + rgb);
        } catch (StaleElementReferenceException e) {
            //waitUntilStalenessOfElement_Tools(element);
            System.out.println("Color Check staleness");
            String c = element.getCssValue("background-color");
            Color color = Color.fromString(c);
            String rgb = color.asRgb();
            Assert.isTrue(rgb.equals(colorCode), "De kleur komt niet overeen, Actual color is: " + rgb);
        }
    }

    //****************************************************************************//
    //! Create element
    //****************************************************************************//

    //? Het maakt een element dank zij de partialLinkText, je hoeft niet al de text te schrijven
    public WebElement createElementByPartialLinkText(String txt) {
        WebElement element;

        try {
            element = GWD.getDriver().findElement(By.partialLinkText(txt));
        } catch (StaleElementReferenceException e) {
            element = GWD.getDriver().findElement(By.partialLinkText(txt));
        }
        return element;
    }

    //? Je create een element via ByLinkText
    public WebElement createElementByLinkText(String txt) {
        WebElement element = null;

        try {
            element = GWD.getDriver().findElement(By.linkText(txt));
        } catch (StaleElementReferenceException e) {

            element = GWD.getDriver().findElement(By.linkText(txt));
        }
        return element;
    }

    //? Het maakt een element dank zij de partialLinkText, je moet al de text schrijven
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

    //****************************************************************************//
    //! SelectBy
    //****************************************************************************//

    //? Hij selecteerd de text van de select
    //! Je moet eerst de element van de selecet schrijven en dan moet je schrijven welke text in de select je wild
    public void selectByVisibleText_Tools(WebElement element, String text) {
        waitUntilElementToBeVisible_Tools(element);
        Select drpdwn = new Select(element);
        drpdwn.selectByVisibleText(text);
    }

    //? Hij selecteerd de value van de select
    //! Je moet eerst de element van de selecet schrijven en dan moet je schrijven welke value in de select je wild
    public void selectByValueText_Tools(WebElement element, String text) {
        waitUntilElementToBeVisible_Tools(element);
        Select drpdwn = new Select(element);
        drpdwn.selectByValue(text);
    }


    // TODO //? Eerst check die of de element de tekst bevat dat we gegeven hebben als het niet bevat stuurt die de tekst naar de element what we willen en dan kijk die nog een keer
    // TODO //!
    //TODO Ayser yazmasi anlatmasi gerek !object nedir ve "data-value" nedir diye
    public void recursiveFunction_Tools(WebElement element, String text) {
        //if(element.getAttribute("data-value") == null){
        if (!Objects.equals(element.getAttribute("data-value"), text)) { //TODO Objects olma nedeni iki farkli obje yi karsilastirmak istedigimiz icin yaptik. element.getAttribute("data-value").equals(text) koyabilir miyiz dene
            sendKeysElement_Tools(element, text);
            recursiveFunction_Tools(element, text);
        }
    }

//****************************************************************************//
//! Driver proces
//****************************************************************************//

    //? Het verandert de tab van de browser
    public void switchNextTab() {
        for (String winHandle : GWD.getDriver().getWindowHandles()) {
            GWD.getDriver().switchTo().window(winHandle);
        }
    }

//****************************************************************************//
//! robotClass
//****************************************************************************//

    //? Hier bepaal je hoeveel keer je op Tab en op Enter wil kliken
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

    //? Dit is copy paste wat je wild text je wild plakken kan je hier bepalen
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

    //? Klik op Enter als of je op de toetsenboard geklikt hebt
    public void robot_Press_Enter_Tools() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

//****************************************************************************//
//! Date & Time process
//****************************************************************************//

    //? Hier maakt die automatisch de datum van vandaag met Uur min en sec en jij zelf moet de ticket nummer schrijven, deze is handig wanneer we een document maken zo kunnen we de datums zien vanneer die gemaakt is
    // ! Je roep deze functie en schrijf de ticket nummer in voorbeeld ABO-1938 dan geneerdet die automatisch de datum tijd met de ticket nummer
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

//****************************************************************************//
// ! File process
//****************************************************************************//

    //? Hier kunnen we eindelijk de path van de documenten bepalen zonder op onze lokale PC te uploaden.
    //! Je schrijft alleen de bestand naam met de file extensions voorbeeld Jinx.png
    public String addFile(String bestanNaam) { // Alleen voor windows
        String folderName = "_Files";
        String fileName = bestanNaam;

        String projectPath = System.getProperty("user.dir");
        String filePath = folderName + FileSystems.getDefault().getSeparator() + fileName;

        String fullPath = projectPath + FileSystems.getDefault().getSeparator() + "src" + FileSystems.getDefault().getSeparator() + "test" + FileSystems.getDefault().getSeparator() + "java" + FileSystems.getDefault().getSeparator() + filePath;
        System.out.println("Bestand Path: " + fullPath);
        return fullPath;
    }
//TODO Log => log4J

}