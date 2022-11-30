--liquibase formatted sql
--changeSet <postgres>:<create-owners-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.owners_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.owners_id_seq;
