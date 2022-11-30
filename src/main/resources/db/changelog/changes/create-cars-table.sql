--liquibase formatted sql
--changeSet <postgres>:<create-cars-table>
CREATE TABLE IF NOT EXISTS public.cars
(
    id              BIGINT                 NOT NULL,
    manufacturer    CHARACTER VARYING(256) NOT NULL,
    model           CHARACTER VARYING(256) NOT NULL,
    production_year INT                    NOT NULL,
    serial_number   CHAR(15) NOT NULL,
    owner_id        BIGINT                 NOT NULL,
    CONSTRAINT cars_pk PRIMARY KEY (id)
);

--rollback DROP TABLE cars;
