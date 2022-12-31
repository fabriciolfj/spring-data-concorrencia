create table inventory (
id BIGSERIAL        PRIMARY KEY NOT NULL,
code                varchar(100) not null,
product             varchar(100) not null,
entrance            numeric(20,0) not null,
exit                numeric(20,0)  not null,
balance             numeric(20,0)  not null check (balance >= 0),
date_registration   timestamp not null,
unique(code)
);