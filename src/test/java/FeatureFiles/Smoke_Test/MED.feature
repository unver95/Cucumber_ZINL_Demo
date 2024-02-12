@Smoketest

Feature: Smoke Test MED

  Scenario: Dit is een Smoke test voor MED
    Given Ga naar "medicijnkosten.nl/"

 #   And Klik op "Meer nieuws"
  #  And Voer de nodige acties uit in het "Meer nieuws"
   # And Ga naar huis pagina
    When Controleer de eerste link op Toptask view
    And Ga naar huis pagina
    And Zoek "Elvanse" op search
    Then Kies "20MG" van uit "sterkte"
   # And Kies de 2. select en dan kies out select "20MG"
    And Kies "20MG" uit select
    And Klik op zoeken button op search pagina
    And Klik op de 1. zoekresultaat die op search verschijnen is

    #sThen Kies de 1. select en dan kies out select "package"


    # //TODO Then kisim calismiyor bakilmasi gerek Ayserle

  Scenario Outline: Dit is een Smoke test voor MED voor Footer
    Given Ga naar "medicijnkosten.nl"
    And Scroll helemaal naar beneden
    Then Klik op "<footer>"
    Then Voer de nodige acties uit in het "<footer>"

    Examples: //TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer               |
      | Contact              |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Begrippenlijst       |
      | Nieuwsbrief          |
      | Veelgestelde vragen  |
      | Copyright            |
      | Privacy              |
      | Cookies              |
      | Toegankelijkheid     |
      | Kwetsbaarheid melden |