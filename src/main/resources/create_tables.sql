create table messages
(
    id  int not null constraint primary key,
    date_received timestamp,
    word varchar (100) not null
);