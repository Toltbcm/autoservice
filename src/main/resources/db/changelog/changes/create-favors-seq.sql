--liquibase formatted sql
--changeSet <postgres>:<create-favors-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.favors_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.favors_id_seq;
