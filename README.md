# BySykkelData

Kodeoppgave for Origo Oslo

I denne oppgaven skulle jeg vise sanntids data på Oslos BySykkel
Informasjon som skulle vises var:

a. Navn på stasjonen
b. Antall ledige sykler
c. Antall ledige “docks” (for tilbakelevering) 

Jeg valgte å gjøre ting så enkelt som mulig ved å sette opp Koin dependency injection framework.
Jeg valgte også kotlin serialization for å analysere JSON

Min applikasjon skal innholde feilhåndtering når telefonen er offline
og brukeren skal bli innformert når man ikke har dekning.
Når brukeren swiper nedover vil ny data bli lastet inn for brukeren.

under er en liten utsnitt av min applikasjon 


![bySykkelApp](https://user-images.githubusercontent.com/71320559/138570927-b2a9adec-bb38-4bfe-b320-95028f2ad089.jpg)

for å kjøre koden:
Last ned debbe repository -> last ned Android Studio -> åpne filen i Android Studio
