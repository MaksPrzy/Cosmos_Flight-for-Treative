create table flights (
  id bigint auto_increment,
  name varchar(256) not null,
  departure_place varchar(128) not null,
  departure_date datetime not null,
  arrival_place varchar(128) not null,
  arrival_date datetime not null,
  sit_count int not null,
  tourist_count int not null default 0,
  ticket_price decimal(13, 2) not null,
  removed boolean not null default false,
  primary key(id)
);
