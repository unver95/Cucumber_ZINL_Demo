@Smoketest



Feature: Smoke Test IST
# //TODO FK ICIN TEKRARDAN TEST YAOILMASI GEREK YAPMAYI UNUTTUM O SITEYI
  Scenario:
    Given Ga naar "istandaarden.nl"
    #//TODO Acaba "Ga naar ist.nl" dedigimizde acaba browser i da mi yazak daha cok dinamik olur. Mesela "Ga naar ist.nl met Chrome/Brave/FireFox"
    And Klik op "Meer nieuws"
    And Voer de nodige acties uit in het "Meer nieuws"
      # Burada bir sikinti var; nieuws larin kategorilerine teker teker tikladigimizda ve en bastaki yeni haberin tagini kontrol etmek istedigimizde her elementin kendine ozel locatori oldugunu goruyoruz. Bu nedenle genel kontrol mumkun degil.
    And Ga terug via web browser
    And Klik op "iWlz"
    And Kijk of de URL "iwlz" bevat
    And Ga naar huis pagina
    And Zoek "Releases" op search
  #// TODO Voor zoeken moeten we eerst naar de home page gaan daar na kunnen we pas zoeken gebruiken
  #//TODO Zoek werkt niet goed de url verandert niet het is een BUG maar als je via de home pagina doet dat update die de URL wel

  Scenario Outline: Dit is een Smoke test voor IST voor Footer
    Given Ga naar "istandaarden.nl"
    And Scroll helemaal naar beneden
    Then Klik op "<footer>"
    And Voer de nodige acties uit in het "<footer>"
    Examples: //TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer               |
      | Contact              |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Begrippenlijst       |
      | Nieuwsbrief          |
      | Nieuwsbrievenarchief |
      | Servicedesk          |
      | Archief              |
      | Vacatures            |
      | Over ons             |
      | Copyright            |
      | Privacy              |
      | Cookies              |
      | Toegankelijkheid     |
      | Kwetsbaarheid melden |