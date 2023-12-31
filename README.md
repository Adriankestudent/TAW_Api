# TAW_Api

# Wymagania

Warunkiem zaliczenia jest przygotowanie aplikacji serwerowej opartej o REST API oraz raportu komunikacji z tym serwerem według podanego scenariusza.
Raport komunikacji z serwerem powinien zawierać zestawienie wywołanych żądań do serwera wraz z adresem zasobu, metodą http, body żądania, 
nagłówkami żądania oraz odpowiedzią serwera na wysłane żądanie w postaci kodu odpowiedzi http oraz body odpowiedzi.

Przykładowy opis żądania z ćwiczeń:
Metoda: POST
Adres zasobu: http://localhost:8080/api/activities
Nagłówki: Content-Type: application/json
Request Body:
{
"nazwa": "programowanie",
"priorytet": 10
}
Odpowiedź:
HTTP Code: 200 OK
Body: brak

W ramach projektu należy przygotować REST API bazujące na zasobie przedmiotów na studia. Każdy przedmiot na studia powinien zawierać informacje o:
- nazwie przedmiotu,
- punktach ects,
- numerze sali, w której odbywają się zajęcia,
- informacji czy przedmiot kończy się egzaminem.

Serwer powinien umożliwiać wprowadzanie nowych przedmiotów, pobieranie przedmiotów oraz usuwanie przedmiotów.
Ocena za zaliczenie będzie uzależniona od złożoności przygotowanego rozwiązania.
W podstawowej wersji serwer powinien umożliwiać wprowadzanie nowego przedmiotu, pobieranie wszystkich przedmiotów 
i usuwanie wszystkich przedmiotów. W rozszerzonej wersji serwer powinien pozwalać na filtrację pod kątem informacji 
o tym czy przedmiot kończy się egzaminem oraz o filtrację po numerze sali, w której obywają się zajęcia. Serwer 
powinien także udostępniać możliwość pobierania konkretnego zasobu w oparciu o identyfikator oraz usuwanie konkretnego 
przedmiotu w oparciu o identyfikator.

# Scenariusz do raportu

1. Wprowadzenie przedmiotów do systemu w podanej kolejności:
- Nazwa: Metodologie obiektowe, ECTS: 2, Sala: 216, Egzamin: tak,
- Nazwa: Testowanie oprogramowania, ECTS: 1, Sala: 216, Egzamin: nie,
- Nazwa: Technologie i aplikacje webowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Zarządzanie projektem informatycznym, ECTS: 2, Sala: 216, Egzamin: nie,
- Nazwa: Zaawansowane technologie bazodanowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Technologie komponentowe i sieciowe, ECTS: 2, Sala: 208, Egzamin: tak
2. Pobranie wszystkich przedmiotów,
3. Pobranie przedmiotów, które mają egzamin,
4. Pobranie przedmiotów, które odbywają się w sali 216,
5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208,
6. Pobranie przedmiotu o identyfikatorze 3,
7. Pobranie przedmiotu o identyfikatorze 15,
8. Usunięcie przedmiotu o identyfikatorze 2,
9. Pobranie wszystkich przedmiotów,
10. Usunięcie wszystkich przedmiotów,

## Wprowadzenie przedmiotów do systemu:

Metoda: POST
Adres zasobu: http://localhost:8080/api/zajecia  
Nagłówki: Content-Type: application/json  
Request Body:  
{"nazwa":"Metodologie Obiektowe", "ECTS":2, "sala":"216", "egzamin":"true"}  

Odpowiedź:  
HTTP Code: 200 OK  
Body: brak  

Request Body dla kolejnych przedmiotów:  
{"nazwa":"Testowanie oprogramowania", "ECTS":1, "sala":"216", "egzamin":"false"}  
{"nazwa":"Technologie i aplikacje webowe", "ECTS":3, "sala":"208", "egzamin":"false"}  
{"nazwa":"Zarządzanie projektem informatycznym", "ECTS":2, "sala":"216", "egzamin":"false"}  
{"nazwa":"Zaawansowane technologie bazodanowe", "ECTS":3, "sala":"208", "egzamin":"false"}  
{"nazwa":"Technologie komponentowe i sieciowe", "ECTS":2, "sala":"208", "egzamin":"true"} 

## Pobranie wszystkich przedmiotów:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   

  {
    "id": 1,
    "nazwa": "Metodologie obiektowe",
    "ECTS": 2,
    "sala": 216,
    "egzamin": true
  },  
  {
    "id": 2,
    "nazwa": "Testowanie oprogramowania",
    "ECTS": 1,
    "sala": 216,
    "egzamin": false
  },  
  {
    "id": 3,
    "nazwa": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  },  
  {
    "id": 4,
    "nazwa": "Zarządzanie projektem informatycznym",
    "ECTS": 2,
    "sala": 216,
    "egzamin": false
  },  
  {
    "id": 5,
    "nazwa": "Zaawansowane technologie bazodanowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  },  
  {
    "id": 6,
    "nazwa": "Technologie komponentowe i sieciowe",
    "ECTS": 2,
    "sala": 208,
    "egzamin": true
  }  


  ## Pobranie przedmiotów, któer mają egzamin:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia?exam=true  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   

  {
    "id": 1,
    "nazwa": "Metodologie obiektowe",
    "ECTS": 2,
    "sala": 216,
    "egzamin": true
  },  
  {
    "id": 6,
    "nazwa": "Technologie komponentowe i sieciowe",
    "ECTS": 2,
    "sala": 208,
    "egzamin": true
  }  


  ## Pobranie przedmiotów, które odbywają się w sali 216:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia?room=216  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   

  {
    "id": 1,
    "nazwa": "Metodologie obiektowe",
    "ECTS": 2,
    "sala": 216,
    "egzamin": true
  },  
  {
    "id": 2,
    "nazwa": "Testowanie oprogramowania",
    "ECTS": 1,
    "sala": 216,
    "egzamin": false
  },  
  {
    "id": 4,
    "nazwa": "Zarządzanie projektem informatycznym",
    "ECTS": 2,
    "sala": 216,
    "egzamin": false
  }  

  
  ## Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia?room=208&exam=false  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   

  {
    "id": 3,
    "nazwa": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  },  
  {
    "id": 5,
    "nazwa": "Zaawansowane technologie bazodanowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  }  


## Pobranie przedmiotu o identyfikatorze 3:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia/3  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   
{
  "id": 3,
  "nazwa": "Technologie i aplikacje webowe",
  "ECTS": 3,
  "sala": 208,
  "egzamin": false
}  

## Pobranie przedmiotu o identyfikatorze 15:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia/15  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 404  
Body: brak  

## Usunięcie przedmiotu o indentyfikatorze 2:

Metoda: DELETE  
Adres zasobu: http://localhost:8080/api/zajecia/2  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 204  
Body: brak  

## Pobranie wszystkich przedmiotów:

Metoda: GET  
Adres zasobu: http://localhost:8080/api/zajecia  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200 OK  
Body:   
{
    "id": 1,
    "nazwa": "Metodologie obiektowe",
    "ECTS": 2,
    "sala": 216,
    "egzamin": true
  },  
  {
    "id": 3,
    "nazwa": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  },  
  {
    "id": 4,
    "nazwa": "Zarządzanie projektem informatycznym",
    "ECTS": 2,
    "sala": 216,
    "egzamin": false
  },  
  {
    "id": 5,
    "nazwa": "Zaawansowane technologie bazodanowe",
    "ECTS": 3,
    "sala": 208,
    "egzamin": false
  },  
  {
    "id": 6,
    "nazwa": "Technologie komponentowe i sieciowe",
    "ECTS": 2,
    "sala": 208,
    "egzamin": true
  }  

  ## Usunięcie wszystkich przedmiotów:
  
Metoda: DELETE  
Adres zasobu: http://localhost:8080/api/zajecia  
Nagłówki: Content-Type: application/json  
Request Body: brak  

Odpowiedź:  
HTTP Code: 200  
Body: brak  
