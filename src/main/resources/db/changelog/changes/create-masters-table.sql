--liquibase formatted sql
--changeSet <postgres>:<create-masters-table>
CREATE TABLE IF NOT EXISTS public.masters
(
    id         bigint                 NOT NULL,
    first_name character varying(256) NOT NULL,
    last_name  character varying(256) NOT NULL,
    patronymic character varying(256) NOT NULL,
--     order_id   bigint                 NOT NULL,
    CONSTRAINT masters_pk PRIMARY KEY (id)
);

--rollback DROP TABLE masters;
