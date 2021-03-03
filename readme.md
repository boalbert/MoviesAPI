# Webservices Lab 2
# Movies API

I detta projekt har vi byggt en Movie-Rating-Api som hantera filmer.
Projektet är byggt som en microservice applikation i Spring-ramverket med en MariaDB relationsdatabas.


## Specifikation

Sammankopplingen av information görs genom UserEndpoint som hämtar information från alla andra
services och som sammanställer informationen. 

- Metoder som ändrar på data har auth begränsning via Auth Service och tokens (JWT).
- Configurering körs från en config service.
- Gateway med lastbalansering.
- Discovery service för att kunna köra flera instancer av samma service.

## Endpoints

Servicen innehåller nedan endpoints.

`/movies` - Hanterar filminformation.

`/directors` - Hanterar information om reghssörer.

`/languages` - Hanterar information om filmens språk.

`/genre` - SHanterar information om filmens genre.

`/movies` - Innehåller referenser till information ovan. Även möjlighet att lägga till kommentar.

`/fullmovies` - Sammanställer information ovan till en separat film.
