create sequence order_id_seq
    as integer;

alter sequence order_id_seq owner to admin;

create table product
(
    id      bigserial
        constraint product_pkey
            primary key,
    title   varchar(255),
    cost    varchar(255),
    optlock integer
);

alter table product
    owner to admin;

create table customer
(
    id   bigserial
        constraint customer_pkey
            primary key,
    name varchar(255)
);

alter table customer
    owner to admin;

create table ordering
(
    id            integer default nextval('order_id_seq'::regclass) not null
        constraint order_pk
            primary key,
    customer      integer
        constraint order_customer_id_fk
            references customer,
    product       integer
        constraint order_product_id_fk
            references product,
    quantity      integer,
    date          timestamp,
    "productCost" integer,
    "totalCost"   integer
);

alter table ordering
    owner to admin;

alter sequence order_id_seq owned by ordering.id;

create unique index order_id_uindex
    on ordering (id);
