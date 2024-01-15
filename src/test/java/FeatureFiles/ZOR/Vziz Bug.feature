Feature: nieuws pagina aanmaken als Riwka

  Background:
 #   Given Ga naar "gipdatabank.nl/"
#    When Vul de prompt alert in
#    And Klik op login
#    And Enter de naam Riwka
#    And Enter de wachtwoord "Welkom02!"
#    And Klik op in log
#    Then (Ingelogd als moet) zichtbaar zijn op de header
#    And Klik op Beheer
#
  Scenario: Dit is een demo dat voor de Spark report om een screenshot te krijgen.
  #Als Riwka wil ik een nieuwe afbeelding uploaden,bewerken en bekijken op beeldbank.
    Given Ga naar "gipdatabank.nl/"
    When Klik op login
    And Enter de naam "Deze persoon bestaat niet"
    And Enter de wachtwoord
    And Klik op in log
    Then (Ingelogd als) moet zichtbaar zijn op de header
    And Klik op Beheer

############################################################
#  #NIEUW#
############################################################
#    Given Klik op "Beeldbank"
#    And Klik op de + icon op de toolbar
#    And klik op tippybox die verschijnen is
#    When Schrijf de titel
##    And Voeg een tag toe
##      | abc |
##      | sna |
##      | pps |
##      | brk |
#    And Voeg een alternative tekst
#    And Voeg een Afbeeldingstype
#    And Voeg een Auteursrecht
#    And Als auteur zicht baar is schrijf de auteur naam
#    And Schrijf de bron
#    And voeg een afbeelding
#    And Klik op Bewaren
#    Then Kijk of de afbeelding fotolijst heeft en klik op de afbeelding
############################################################
#  #View#
############################################################
#    When Kijk of de afbeelding op concept staat
#    And kijk of de Titel correct staat
#    And Kijk of de Alternative tekst correct staat
#    And Kijk of de CC correct staat
##    And Kijk of de Tag correct staat
#    Then Klik op "Publiceer"
#    And Klik op publiceer nu
##    And kijk of de Titel correct staat
##    And Kijk of de CC correct staat
##    And Kijk of de Tag correct staat
############################################################
#  #Bewerk#
############################################################
#    When Klik op "Beeldbank"
#    When Klik op de afbeelding die gepubliceerd is
#    When Klik op "Nieuwe versie"
#    And Voeg een tag toe
#      | a |
#      | s |
#      | p |
#      | b |
#    And Voeg een alternative tekst
#    And Voeg een Afbeeldingstype
#    And Voeg een Auteursrecht
#    And Als auteur zicht baar is schrijf de auteur naam
#    And Schrijf de bron
#    And voeg een afbeelding
#    And Klik op Bewaren
#
