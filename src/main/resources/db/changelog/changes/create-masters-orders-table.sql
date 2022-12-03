--liquibase formatted sql
--changeSet <postgres>:<create-masters-orders-table>
CREATE TABLE IF NOT EXISTS public.masters_orders
(
    master_id BIGINT NOT NULL,
    order_id  BIGINT NOT NULL,
    CONSTRAINT master_id_fk FOREIGN KEY (master_id) REFERENCES masters,
    CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES orders
);

--rollback DROP TABLE masters_orders;
