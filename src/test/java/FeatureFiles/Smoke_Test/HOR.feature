@Smoketesta

Feature: Smoke Test HOR

  Scenario: Dit is een Smoke test voor HOR
    Given Ga naar "horizonscangeneesmiddelen.nl/?lang=nl"

    And Scroll helemaal naar beneden
    And Klik op "Meer nieuws"
    And Voer de nodige acties uit in het "Meer nieuws"
    And Ga naar huis pagina
    When Controleer de eerste link op Toptask view
    And Ga naar huis pagina
    When Klik op login
    And Enter de naam "MandeepH"
    And Enter de wachtwoord
    And Klik op in log
    Then (Ingelogd als) moet zichtbaar zijn op de header
    And Klik op Beheer
    And Controleer het Dashboard van de gebruiker
    And Zoek "Geneesmiddel" op search
    #Then Ga naar de homepagina en klik op Geneesmiddelen
    #//TODO Waar is "Ga naar de homepagina en klik op Geneesmiddelen" ??

  Scenario Outline: Dit is een Smoke test voor HOR voor Footer
    Given Ga naar "horizonscangeneesmiddelen.nl/?lang=nl"
    And Scroll helemaal naar beneden
    And Klik op "<footer>"
    Then Voer de nodige acties uit in het "<footer>"


    Examples: //TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer                 |
      | Contact                |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Downloads              |
      | Export                 |
      | Copyright              |
      | Privacy                |
      | Cookies                |
      | Toegankelijkheid       |
      | Kwetsbaarheid melde    |
      | Over de Horizonscan    |
      | About the Horizon Scan |
