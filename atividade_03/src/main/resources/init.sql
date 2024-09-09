create table if not exists students (
  id serial primary key,
  name varchar(100),
  age integer,
  email varchar(100)
);