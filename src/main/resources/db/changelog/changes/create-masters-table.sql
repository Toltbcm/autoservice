--liquibase formatted sql
--changeSet <postgres>:<create-masters-table>
CREATE TABLE IF NOT EXISTS public.masters
(
    id         BIGINT                 NOT NULL,
    first_name CHARACTER VARYING(256) NOT NULL,
    last_name  CHARACTER VARYING(256) NOT NULL,
    patronymic CHARACTER VARYING(256) NOT NULL,
    CONSTRAINT masters_pk PRIMARY KEY (id)
);

--rollback DROP TABLE masters;
