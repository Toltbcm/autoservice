--liquibase formatted sql
--changeSet <postgres>:<create-parts-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.parts_id_seq INCREMENT 1 START 0 MINVALUE 0;

--rollback DROP SEQUENCE public.parts_id_seq;
