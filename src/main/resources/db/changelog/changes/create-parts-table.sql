--liquibase formatted sql
--changeSet <postgres>:<create-parts-table>
CREATE TABLE IF NOT EXISTS public.parts
(
    id    bigint                 NOT NULL,
    title character varying(256) NOT NULL,
    price character varying(256) NOT NULL,
    CONSTRAINT parts_pk PRIMARY KEY (id)
);

--rollback DROP TABLE parts;
