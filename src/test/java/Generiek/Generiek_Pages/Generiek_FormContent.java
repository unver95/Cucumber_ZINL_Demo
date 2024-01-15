package Generiek.Generiek_Pages;

import Utilities.GWD;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class Generiek_FormContent {

    public Generiek_FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class=\"pat-autofocus focus\"]")
    private WebElement titelNieuweAfbeelding;
    @FindBy(xpath = "//ul//input[@type='text']")
    private WebElement tagNieuweAfbeelding;
    @FindBy(xpath = "//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable select2-highlighted\"]")
    private WebElement selecteerDeEersteTag;
    @FindBy(xpath = "//textarea[@name='V-samenvatting']")
    private WebElement alternatieveTekst;
    @FindBy(xpath = "//select[@name=\"S-beeldtype\"]")
    private WebElement selectAfbeeldingstype;
    @FindBy(xpath = "//select[@name=\"S-auteursrecht\"]")
    private WebElement selectAuteursrecht;
    @FindBy(xpath = "//select[@name='sterkte']")
    private WebElement selectSterkte;
    @FindBy(xpath = "//select[@name='sterkte']")
    private WebElement auteur;
    @FindBy(xpath = "//input[@name=\"S-bron\"]")
    private WebElement bron;
    @FindBy(xpath = "//input[@type=\"file\"]")
    private WebElement bijlageContactFormulier;
    @FindBy(xpath = "//button[@name=\"save_button\"]")
    private WebElement bewarenContent;
    @FindBy(xpath = "//h1[@class=\"panel-class-medium panel\"]")
    private WebElement panelContent;
    @FindBy(xpath = "(//nav[@id='image-collection-image-bank']//a[@class=\"item image  pat-inject state-draft\"])[1]")
    private WebElement firstImage;
    @FindBy(css = "[name='naam']")
    private WebElement naamContactFormulier;
    @FindBy(css = "[name='functie']")
    private WebElement functieContactFormulier;
    @FindBy(css = "[type='email']")
    private WebElement email;
    @FindBy(css = "[name='telefoon']")
    private WebElement telefoonContactFormulier;
    @FindBy(css = "[name='onderwerp']")
    private WebElement onderwerpContactFormulier;
    @FindBy(css = "[name=\"reactie\"]")
    private WebElement reactieContactFormulier;
    @FindBy(xpath = "//label[@data-value=\"Test Naam\"]/following-sibling::fieldset//input[@value=\"Professional\"]//..")
    //TODO SENA BAKSIN BU KODA: Bir suru fieldset oldugu icin istedigim seyin altinda kini alip ondan sonra onun uzerinde kini aldim
    private WebElement professionalContactFormulierRadioButton;
    @FindBy(css = "[value='Burger']")
    private WebElement priveContactFormulierRadioButton;
    @FindBy(xpath = "//*[@id=\"main-content\"]/form/fieldset/fieldset/label[contains(text(), \"Ik geef\")]")
    private WebElement akkoordverklaringFormulierButton1;
    @FindBy(xpath = "//*[@id=\"main-content\"]/form/fieldset/fieldset/label[contains(text(), \"Ik heb gelezen\")]")
    private WebElement akkoordverklaringFormulierButton2;
    @FindBy(css = "[class=\"default pat-button\"]")
    private WebElement privacyContactFormulierRadioButton;
    @FindBy(css = "[class='default pat-button']")
    private WebElement verstuurButton;
    @FindBy(xpath = "//fieldset//button[@type=\"submit\"]")
    private WebElement zoekButton;
    @FindBy(xpath = "//*[@id=\"main-content\"]/article/p")
    private WebElement feedbackMessageContact;
    @FindBy(xpath = "//div[@class=\"pat-well pat-rich\"]/..//div/h1")
    //TODO Bunu da Sena popisine goster cunku o bir popisin tekdir ve onu severiz biz.. Sadece h1 yapinca olmayan bir seyi aliyor (yada basak bir sey anlamadim) O yuzden 100% emin olmak icin once istedigim elementin altinda ki elementi aldim sonra bir yukar ciktim sonra bir altina indim bir yukari cikinca // yapmis gibi oluyor ama bana / lazim di o yuzde / kullanip sonra da tekrar asa indim. Huh geri cok yazdim yav
    private WebElement feedbackMessageNieuwsbrief;
    @FindBy(css = "[class=\"unchecked\"]")
    private List<WebElement> nieuwsbriefCheckBox;
    @FindBy(xpath = "//sup[@class=\"required\"]//following-sibling::input[@name=\"search-field\"]")
    private WebElement zoekTrefwoord; //TODO Tam emin degiliz Ayserle takima sor bu burda mi olsun mu yoksa baska yerde mu diye
    @FindBy(xpath = "//*[@id=\"search-filters\"]/label[1]/select/option[text()='Alle vormen']")
    private WebElement searchVorm;
    @FindBy(xpath = "//fieldset//input[@name=\"trefwoord\"]")
    private WebElement zoekTrefwoordVoorMedicijnkosten; //TODO Tam emin degiliz Ayserle takima sor bu burda mi olsun mu yoksa baska yerde mu diye
}