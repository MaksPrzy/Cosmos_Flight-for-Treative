create table tourist_flights (
  id bigint auto_increment,
  flight_id bigint not null,
  tourist_id bigint not null,
  primary key(id),
  constraint tourist_flights_flight_id_fk foreign key (flight_id) references flights (id),
  constraint tourist_flights_tourist_id_fk foreign key (tourist_id) references tourists (id)
);
