# Unicode JPA Opgave

Denne applikation giver mulighed for at interagere med Unicode-tegn via forskellige REST-endpoints. Brugere kan omdanne et Unicode-kodepunkt til dets tilsvarende tegn og omvendt ved at indsende enten en numerisk værdi eller et tegn. Derudover kan man generere en række tegn, startende fra et specifikt bogstav.

### Funktionalitet:
- Omdanne Unicode-kodepunkter til deres respektive tegn og omvendt.
- Generere en sekvens af bogstaver fra et startpunkt.
- Alle Unicode-tegn fra Basic Multilingual Plane (BMP) op til 65.536 kodepunkter bliver gennemgået og gemt i en database med en beskrivelse.

### REST Endpoints:

- **Få et Unicode-tegn fra et kodepunkt**:
  - `GET /unicode/{i}`
  - Eksempel: `/unicode/65` returnerer `"unicode = 65  char = A"`

- **Få et Unicode-kodepunkt fra et tegn**:
  - `GET /unicode/char/{c}`
  - Eksempel: `/unicode/char/A` returnerer `"char = A  unicode = 65"`

- **Generer en sekvens af tegn startende fra et specifikt bogstav**:
  - `GET /unicode/generate/{bogstav}/{antal}`
  - Eksempel: `/unicode/generate/a/5` returnerer `"abcde"`

### Beskrivelse af Programmet:
Programmet gennemgår alle kodepunkter fra Unicode's Basic Multilingual Plane (BMP) op til 65.536 tegn. For hvert kodepunkt finder programmet det tilhørende tegn og gemmer det i en database sammen med en beskrivelse. Dette gør det muligt at arbejde med både Unicode-kodepunkter og deres respektive tegn.

### Test i Postman:
1. **GET `/unicode/{i}`**: Sender en numerisk værdi (kodepunkt) og får det tilsvarende tegn som svar.
2. **GET `/unicode/char/{c}`**: Sender et tegn og får det tilsvarende Unicode-kodepunkt.
3. **GET `/unicode/generate/{bogstav}/{antal}`**: Genererer en sekvens af bogstaver startende fra det angivne bogstav.

### Vigtigt:
Husk at ændre de lokale variabler i `application.properties`-filen for at konfigurere dine databaseforbindelser og andre nødvendige indstillinger.
