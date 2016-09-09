# Sortering av slumpmässiga nummer
## Användning:
Applikationen bygger på ett Spring Boot-Maven projekt och körs enklast via maven plugin:
spring-boot:run

Sorteringssidan hittas på:

http://localhost:8080/sort

Nya slumpmässiga nummerföljder läggs in via syntax:

http://localhost:8080/sort?sort=6,3,88,34,48,67


## To do:
- Databaskoppling som sparar resultaten vid omstart. (In-memory databas som används nu men kan lätt bytas ut).
- Felhantering för felaktig indata
- Styling så att sidan ser lika "fräsig" ut som efterfrågas.
- Dela upp visning av gamla nummer och insättning av nya nummer på olika sidor (index / sort)



