@Smoketesta

Feature: Smoke Test FK

  Scenario: Dit is een Smoke test voor FK
    Given Ga naar "farmacotherapeutischkompas.nl/"
    #//TODO Acaba "Ga naar fk.nl" dedigimizde acaba browser i da mi yazak daha cok dinamik olur. Mesela "Ga naar ist.nl met Chrome/Brave/FireFox"...... Gelecekte ki burak yazdi bunu yapma cunku o zaman her sey icin tek tek degistirmek zorunda kalirsin ve daha zor olur
    And Klik op "Meer nieuws"
    And Voer de nodige acties uit in het "Meer nieuws"
    And Ga naar huis pagina
    When Controleer de eerste link op Toptask view voor FK
    And Ga naar huis pagina
    # And Controleer het Dashboard van de Beheerder FK heft geen dashboard
    And Ga naar "farmacotherapeutischkompas.nl/"
    And Zoek "paracetamol" op search
    And Controleer voor FK of de search result op "geneesmiddelen" bevat
    And Zoek "Nsaid's, oculair" op search
    And Controleer voor FK of de search result op "geneesmiddelgroepen" bevat
    And Zoek "Obstipatie" op search
    And Controleer voor FK of de search result op "indicaties" bevat
    # And Zoek "analeptica" op search TODO deze bestaat niet
    # And Controleer voor FK of de search result op "geneesmiddelgroepen" bevat //TODO "analeptica" bestaat niet daarom dit kunnen we skippen

#    And Klik op het vergrootglas
#    And Ga naar "farmacotherapeutischkompas.nl/"
#    And Klik op het vergrootglas
#    And klik op Geavanceerd
#    Then Kies de 1. select en dan kies out select "Stofnaam"
#    And Zoek "Paracetamol" op zoekterm
#    And Klik op Enter
#    And Zoekterm resultaten worden getoond.

  Scenario Outline: Dit is een Smoke test voor FK voor Footer
    Given Ga naar "farmacotherapeutischkompas.nl"
    And Scroll helemaal naar beneden
    And Klik op "<footer>"
    Then Voer de nodige acties uit in het "<footer>"


    Examples: //TODO Burda ki sikinti her seferinde Scenario yu bastan baslatacak cunku footer da hepsini yapmak gerek Ayserle konus o bu fikri vermisti herhalde nededn verdi diye sor
      | footer               |
    #  | Contact              |
  #//TODO DONE!!!!!!!!! [class="default pat-button si-event"] OLMASI GEREKIYOR AMA OBURLERINDE [class='default pat-button']
      | E-learning cursus FK |
      | Mobiele apps         |
      | Help                 |
      | Over deze site       |
      | Verantwoording       |
      | Verantwoording       |
      | Veelgestelde vragen  |
      | Proclaimer           |
      | Copyright            |
      | Cookies              |