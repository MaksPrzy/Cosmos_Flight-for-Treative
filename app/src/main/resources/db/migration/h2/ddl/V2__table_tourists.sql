create table tourists (
  id bigint auto_increment,
  first_name varchar(128) not null,
  last_name varchar(128) not null,
  sex varchar(16) not null,
  country varchar(128) not null,
  note text,
  birth_date date not null,
  removed boolean not null default false,
  primary key(id)
);
