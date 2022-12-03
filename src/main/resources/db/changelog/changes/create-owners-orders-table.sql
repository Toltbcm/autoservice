--liquibase formatted sql
--changeSet <postgres>:<create-owners-orders-table>
CREATE TABLE IF NOT EXISTS public.owners_orders
(
    owner_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    CONSTRAINT owner_id_fk FOREIGN KEY (owner_id) REFERENCES owners,
    CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES orders
);

--rollback DROP TABLE owners_orders;
