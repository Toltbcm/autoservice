--liquibase formatted sql
--changeSet <postgres>:<create-orders-parts-table>
CREATE TABLE IF NOT EXISTS public.orders_parts
(
    order_id BIGINT NOT NULL,
    part_id  BIGINT NOT NULL,
    CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES orders,
    CONSTRAINT part_id_fk FOREIGN KEY (part_id) REFERENCES parts
);

--rollback DROP TABLE orders_parts;
