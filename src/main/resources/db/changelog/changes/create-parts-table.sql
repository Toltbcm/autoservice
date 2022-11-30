--liquibase formatted sql
--changeSet <postgres>:<create-parts-table>
CREATE TABLE IF NOT EXISTS public.parts
(
    id    BIGINT                 NOT NULL,
    title CHARACTER VARYING(256) NOT NULL,
    price NUMERIC(19, 2)         NOT NULL,
    CONSTRAINT parts_pk PRIMARY KEY (id)
);

--rollback DROP TABLE parts;
