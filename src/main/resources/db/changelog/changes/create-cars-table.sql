--liquibase formatted sql
--changeSet <postgres>:<create-cars-table>
CREATE TABLE IF NOT EXISTS public.cars
(
    id              bigint                 NOT NULL,
    manufacturer    character varying(256) NOT NULL,
    model           character varying(256) NOT NULL,
    production_year int                    NOT NULL,
    serial_number   character varying(256) NOT NULL,
    order_id        bigint                 NOT NULL,
    CONSTRAINT cars_pk PRIMARY KEY (id)
);

--rollback DROP TABLE cars;
