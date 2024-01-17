@Smoketesta

Feature: Smoke Test VZIZ

  Scenario: Dit is een Smoke test voor VZIZ
    Given Ga naar "zorginzicht.nl/"
    #//TODO Acaba "Ga naar vziz.nl" dedigimizde acaba browser i da mi yazak daha cok dinamik olur. Mesela "Ga naar ist.nl met Chrome/Brave/FireFox"

    When Klik op "Meer nieuws"
    Given Ga naar "zorginzicht.nl/"
    And Controleer de eerste link op Toptask view
    Given Ga naar "zorginzicht.nl/"
    #When Klik op "Transparantiekalender"
    #And Kijk of huidige jaar klopt
    # //TODO ^ Transparantiekalender moet ik nog met Michel bespreken wat de formule is
    And Ga naar huis pagina
  #  Then Zoek "Register" op search


  Scenario Outline: Dit is een Smoke test voor VZIZ voor Footer
    Given Ga naar "zorginzicht.nl"
    And Scroll helemaal naar beneden
    Then Klik op "<footer>"
    Then Voer de nodige acties uit in het "<footer>"

    Examples: //TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer               |
#      | Contact              |
  #//TODO DONE!!!!!!!!! yey FK icin bak, contact formulier stuur olmuyor
      | Toelichting          |
      | Archief              |
      | Copyright            |
      | Privacy              |
      | Cookies              |
      | Toegankelijkheid     |
      | Kwetsbaarheid melden |
      | Kwaliteitstaken      |
