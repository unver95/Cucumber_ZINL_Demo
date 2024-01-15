Feature: [IST-1758] Meetinstrumenten bewerken

  Background:

   # Given Ga naar "istandaarden.nl/"



Scenario: Als Riwka wil ik de Meetinstrumenten bewerken
  #Als Riwka wil ik de Meetinstrumenten bewerken
  Given Ga naar "istandaarden.nl/"
  When Klik op login
  And Enter de naam "Riwka"
  And Enter de wachtwoord
  And Klik op in log
  Then (Ingelogd als) moet zichtbaar zijn op de header
