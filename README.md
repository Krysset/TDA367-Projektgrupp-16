# TDA367-Projektgrupp-16
## Starta Programmet
 - Installera java 8 JRE och java 8-16 JDK
 - Installera gradle för ditt operativ system
 - Starta en konsol i root av projektet
 - skriv i konsolen följande ```gradle build```
## Dokumentation
Du kan hitta javaDoc på sidan https://krysset.github.io/TDA367-Projektgrupp-16/

UML diagram hittas i documents i formen av yuml och svg filer.
Klasser med blå bakgrund är paket.
## Om Projektet
Projektet är ett spel som har tagit mycket inspiration ifrån Pokémon och Undertale.
Vi kallar det *Feyrune*. 
I Feyrune är tanken att man ska kunna slåss mot monster med sina egna monster och utforska olika områden.

Vektyg vi har använt oss av är:
 - LibGDX för visualisering av spelet
 - Tiled för att lättare kunna skapa tile maps och tilesets

Alla texturer vi använder oss av hittade vi gratis på hemsidan itch.io

## Struktur
Projektet är strukturerat enligt MVC, det är därför inte förvånande att man inte ett paket för vardera.

### Controller
Vi använder oss av vad LibGdx kallar "Input Processor", 
alltså flera olika sorters controllers som hanterar input annorlunda varav en är aktiv åt gången.
Controller paketet har även knappar m.m i dess combat paket för att kunna ta input från spelaren på ett
annat sätt än endast tangenter.

### Model
Modellen är uppdelad i två delar.
Vad vi kallar Overworld och Combat.

Overworld representerar en karta (map) och en spelare (player) som kan röra sig.
Kartan har kollision och data för transport till nya kartor.
Det är även i Overworld som spelaren kan stöta på fiender i formen av "Encounters".

Väl i en encounter byter modellen till Combat.
I Combat så slåss en spelarstyrd varelse mot en fiendevarelse, vad vi kallar "Creatures".
Man kan välja mellan två "Actions", attack och flee.

### View
View har två paket som ansvarar för att visualisera motsvarande del av modellen.