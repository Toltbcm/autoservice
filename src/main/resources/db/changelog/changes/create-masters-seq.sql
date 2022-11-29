--liquibase formatted sql
--changeSet <postgres>:<create-masters-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.masters_id_seq INCREMENT 1 START 0 MINVALUE 0;

--rollback DROP SEQUENCE public.masters_id_seq;
