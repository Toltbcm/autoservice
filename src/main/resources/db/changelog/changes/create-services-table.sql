--liquibase formatted sql
--changeSet <postgres>:<create-services-table>
CREATE TABLE IF NOT EXISTS public.services
(
    id             BIGINT                NOT NULL,
    payment_status CHARACTER VARYING(32) NOT NULL,
    master_id      BIGINT                NOT NULL,
    order_id       BIGINT                NOT NULL,
    price          NUMERIC(19, 2)        NOT NULL,
    CONSTRAINT services_pk PRIMARY KEY (id),
    CONSTRAINT master_id_fk FOREIGN KEY (master_id) REFERENCES masters,
    CONSTRAINT orders_id_fk FOREIGN KEY (order_id) REFERENCES orders
);

--rollback DROP TABLE services;
