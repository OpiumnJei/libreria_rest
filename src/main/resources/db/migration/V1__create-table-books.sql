create table books(
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    fecha datetime not null,
    author varchar(100) not null,
    gender varchar(100) not null,

    primary key(id)
);