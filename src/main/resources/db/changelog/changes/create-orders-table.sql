--liquibase formatted sql
--changeSet <postgres>:<create-orders-table>
CREATE TABLE IF NOT EXISTS public.orders
(
    id                  BIGINT                 NOT NULL,
    car_id              BIGINT                 NOT NULL,
    start_time          TIMESTAMP              NOT NULL,
    finish_time         TIMESTAMP              NOT NULL,
    problem_description CHARACTER VARYING(256) NOT NULL,
    status              CHARACTER VARYING(32)  NOT NULL,
    total_price         NUMERIC(19, 2)         NOT NULL,
    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT car_id_fk FOREIGN KEY (car_id) REFERENCES cars
);

--rollback DROP TABLE orders;
