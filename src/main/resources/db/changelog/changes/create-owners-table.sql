--liquibase formatted sql
--changeSet <postgres>:<create-parts-table>
CREATE TABLE IF NOT EXISTS public.parts
(
    id            bigint primary key     NOT NULL,
    car           character varying(256) NOT NULL,
    service_order numeric(19, 2)    references orders(id)    NOT NULL
);

--rollback DROP TABLE parts;
