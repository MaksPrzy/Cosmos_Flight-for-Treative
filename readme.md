###
COSMOS FLIGHTS
Przybyło Maksymilian


## Kompilacja backendu: `mvn install`

## Uruchomienie backendu: `mvn spring-boot:run` z katalogu `app`

## Uruchomienie frontu: `npm start` z katalogu `web`

## Przeglądarka: http://localhost:4200/flights


REST API:

POBRANIE LISTY LOTÓW
GET http://localhost:8082/api/flights
RESPONSE:
[ {
  "id" : 1,
  "name" : "FIRST FLIGHT TO MOOON!",
  "departure" : {
    "place" : "Moon",
    "dateTime" : "2100-01-12T01:00:00"
  },
  "arrival" : {
    "place" : "Rzeszów",
    "dateTime" : "2020-01-12T01:10:00"
  },
  "sitCount" : 15,
  "touristCount" : 1,
  "ticketPrice" : 10000.00,
  "tourists" : [ {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 1
  } ]
}, {
  "id" : 3,
  "name" : "Gdańsk >> Rzeszów",
  "departure" : {
    "place" : "Gdańsk",
    "dateTime" : "2019-06-17T19:30:00"
  },
  "arrival" : {
    "place" : "Rzeszów",
    "dateTime" : "2019-06-17T20:30:00"
  },
  "sitCount" : 200,
  "touristCount" : 3,
  "ticketPrice" : 120.99,
  "tourists" : [ {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 2
  }, {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 4
  }, {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 3
  } ]
} ]




DODANIE NOWEGO LOTU
POST http://localhost:8082/api/flights
BODY: 
{
    "name": "Kraków >> Rzeszów",
    "departure": {
      "place": "Kraków",
      "dateTime": "2019-06-17T19:30"
    },
    "arrival": {
      "place": "Rzeszów",
      "dateTime": "2019-06-17T20:30"
    },
    "sitCount": 200,
    "ticketPrice": "120.99"
}

RESPONSE:
{
  "id" : 4,
  "name" : "Kraków >> Rzeszów",
  "departure" : {
    "place" : "Kraków",
    "dateTime" : "2019-06-17T19:30:00"
  },
  "arrival" : {
    "place" : "Rzeszów",
    "dateTime" : "2019-06-17T20:30:00"
  },
  "sitCount" : 200,
  "touristCount" : 0,
  "ticketPrice" : 120.99,
  "tourists" : [ ]
}



DODANIE TURYSTY DO LOTU
POST http://localhost:8082/api/flights/1
BODY:
{
    "firstName": "Jan",
    "lastName": "Kowalski",
    "sex": "MALE",
    "country": "Poland",
    "birthDate": "2009-06-17"
}

RESPONSE:
{
  "id" : 1,
  "name" : "FIRST FLIGHT TO MOOON!",
  "departure" : {
    "place" : "Moon",
    "dateTime" : "2100-01-12T01:00:00"
  },
  "arrival" : {
    "place" : "Rzeszów",
    "dateTime" : "2020-01-12T01:10:00"
  },
  "sitCount" : 15,
  "touristCount" : 2,
  "ticketPrice" : 10000.00,
  "tourists" : [ {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 5
  }, {
    "firstName" : "Jan",
    "lastName" : "Kowalski",
    "sex" : "MALE",
    "country" : "Poland",
    "birthDate" : "2009-06-17",
    "id" : 1
  } ]
}



USUNIECIE TURYSTY Z LOTU
DELETE http://localhost:8082/api/flights/1/tourists/1
STATUS: 200 (OK)




USUNIECIE LOTU
DELETE http://localhost:8082/api/flights/1
STATUS: 200 (OK)







