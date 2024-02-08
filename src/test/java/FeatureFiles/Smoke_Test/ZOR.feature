@Smoketest

Feature: Smoke Test ZOR

  Scenario: Dit is een Smoke test voor ZOR
    Given Ga naar "zorgcijfersdatabank.nl/"
    #//TODO Acaba "Ga naar zor.nl" dedigimizde acaba browser i da mi yazak daha cok dinamik olur. Mesela "Ga naar ist.nl met Chrome/Brave/FireFox"

#    And Klik op "Meer nieuws"
 #   And Ga naar huis pagina
    And Controleer de bladerbaan
    When Klik op login
    And Enter de naam "MandeepH"
    And Enter de wachtwoord
    And Klik op in log
    Then (Ingelogd als) moet zichtbaar zijn op de header
    And Controleer of het tabel Verzekeraar wordt toegevoegd in de bladerbaan
    And Zoek "geneesmiddel" op search

  Scenario Outline: Dit is een Smoke test voor ZOR voor Footer
    Given Ga naar "zorgcijfersdatabank.nl"
    And Scroll helemaal naar beneden
    Then Klik op "<footer>"
    Then Voer de nodige acties uit in het "<footer>"

    Examples: #//TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer               |
      | Contact              |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Nieuwsbrief          |
      | Nieuwsbrievenarchief |
      | Veelgestelde vragen  |
      | Open data            |
      | Copyright            |
      | Privacy              |
      | Cookies              |
      | Toegankelijkheid     |
      | Kwetsbaarheid melden |

