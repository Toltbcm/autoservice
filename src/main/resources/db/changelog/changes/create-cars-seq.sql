--liquibase formatted sql
--changeSet <postgres>:<create-cars-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.cars_id_seq INCREMENT 1 START 0 MINVALUE 0;

--rollback DROP SEQUENCE public.cars_id_seq;
