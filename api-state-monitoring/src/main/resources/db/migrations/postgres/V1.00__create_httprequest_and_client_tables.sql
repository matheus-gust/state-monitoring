create table client (
    id uuid not null primary key,
    tenant uuid not null,
    description character varying(30) not null
);

create table http_request (
    id uuid not null primary key,
    status numeric(10) not null,
    body text not null,
    sender character varying(30) not null,
    client_id uuid not null,
    constraint http_request_client_fk foreign key (client_id) references client(id)
)