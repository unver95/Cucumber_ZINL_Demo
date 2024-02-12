@Smoketest

Feature: Smoke Test GIP

  Scenario: Dit is een Smoke test voor GIP
    Given Ga naar "gipdatabank.nl/"
    And Scroll 0 unit naar boven en 1500 unit naar beneden
   # And Klik op "Meer nieuws"
    #And Voer de nodige acties uit in het "Meer nieuws"
  #  And Scroll 1000 unit naar boven en 0 unit naar beneden
   # And Ga naar huis pagina
    And Controleer de bladerbaan
    When Klik op login
    And Enter de naam "MandeepH"
    And Enter de wachtwoord
    And Klik op in log
    Then (Ingelogd als) moet zichtbaar zijn op de header
    And Controleer of het tabel Verzekeraar wordt toegevoegd in de bladerbaan
    And Klik op Toon overzicht om tabellen te zien
    And Kijk of de tabel wordt getoond
    And Scroll helemaal naar boven
    And Zoek "geneesmiddel" op search

  Scenario Outline: Dit is een Smoke test voor GIP voor Footer
    Given Ga naar "gipdatabank.nl"
    And Scroll helemaal naar beneden
    Then Klik op "<footer>"
    And Voer de nodige acties uit in het "<footer>"

    Examples: #//TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer                     |
      | Contact                    |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Nieuwsbrief                |
      | Nieuwsbrievenarchief       |
      | Open data                  |
      | Help / veelgestelde vragen |
      | Copyright                  |
      | Privacy                    |
      | Cookies                    |
      | Toegankelijkheid           |
      | Kwetsbaarheid melden       |
