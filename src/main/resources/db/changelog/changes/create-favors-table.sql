--liquibase formatted sql
--changeSet <postgres>:<create-favors-table>
CREATE TABLE IF NOT EXISTS public.favors
(
    id             BIGINT                 NOT NULL,
    payment_status CHARACTER VARYING(32)  NOT NULL,
    master_id      BIGINT                 NOT NULL,
    order_id       BIGINT                 NOT NULL,
    description    CHARACTER varying(256) NOT NULL,
    price          NUMERIC(19, 2)         NOT NULL,
    CONSTRAINT services_pk PRIMARY KEY (id),
    CONSTRAINT master_id_fk FOREIGN KEY (master_id) REFERENCES masters,
    CONSTRAINT orders_id_fk FOREIGN KEY (order_id) REFERENCES orders
);

--rollback DROP TABLE favors;
