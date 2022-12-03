--liquibase formatted sql
--changeSet <postgres>:<create-orders-sequence-id>
CREATE SEQUENCE IF NOT EXISTS public.orders_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.orders_id_seq;
