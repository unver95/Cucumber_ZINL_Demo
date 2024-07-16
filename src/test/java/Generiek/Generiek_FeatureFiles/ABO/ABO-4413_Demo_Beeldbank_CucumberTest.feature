Feature: Beeldbank pagina

#  Background:
#    Given Ga naar "zorginzicht.nl/"
#    When Klik op login
#    And Enter de naam "Riwka"
#    And Enter de wachtwoord
#    And Klik op in log
#    Then (Ingelogd als) moet zichtbaar zijn op de header
#    And Klik op Beheer

  Scenario Outline: Als Riwka wil ik een nieuwe afbeelding uploaden,bewerken en bekijken op beeldbank.
###########################################################
  #Background#
###########################################################
    Given Ga naar ABO sites "<sites>"
    When Klik op login
    And Enter de naam "Riwka"
    And Enter de wachtwoord
    And Klik op in log
   # Then (Ingelogd als) moet zichtbaar zijn op de header
    And Klik op Beheer
###########################################################
  #NIEUW#
###########################################################
    Given Klik op "Beeldbank"
    And Klik op de + icon op de toolbar
    And klik op tippybox die verschijnen is
    # When Schrijf de titel
    When Schrijf de titel op "ABO-4413"
    And Voeg een tag toe
      | abc |
      | sna |
      | pps |
      | brk |
    And Voeg een alternative tekst
    And Voeg een Afbeeldingstype
    And Voeg een Auteursrecht
    And Als auteur zicht baar is schrijf de auteur naam
    And Schrijf de bron
    And voeg een afbeelding
    And Wacht "12" seconden

    And Klik op Bewaren
    Then Kijk of de afbeelding fotolijst heeft en klik op de afbeelding
###########################################################
  #View Concept#
###########################################################
  When Kijk of de afbeelding op concept staat
  And kijk of de Titel "ABO-4413" heeft
  And Kijk of de Alternative tekst correct staat
  And Kijk of de CC correct staat
  And Kijk of de Tag correct staat
  Then Klik op "Publiceer"
  And Klik op publiceer nu

###########################################################
  #View Gepubliceerd#
###########################################################
  And kijk of de Titel "ABO-4413" heeft
  And Kijk of de Alternative tekst correct staat
  And Kijk of de CC correct staat
  And Kijk of de Tag correct staat
###########################################################
  #Bewerk#
###########################################################
    And Klik op Beheer
    When Klik op "Beeldbank"
    When Klik op de afbeelding die gepubliceerd is
    When Klik op "Nieuwe versie"
    And Voeg een tag toe
      | a |
      | s |
      | p |
      | b |
    And Voeg een alternative tekst
    And Voeg een Afbeeldingstype
    And Voeg een Auteursrecht
    And Als auteur zicht baar is schrijf de auteur naam
    And Schrijf de bron
    And voeg een afbeelding
    And Klik op Bewaren

    Examples:
      | sites                        |
      | zorginzicht.nl               |
#      | gipdatabank.nl               |
#      | medicijnkosten.nl            |
#      | istandaarden.nl              |
#      | zorgcijfersdatabank.nl       |
#      | horizonscangeneesmiddelen.nl |
