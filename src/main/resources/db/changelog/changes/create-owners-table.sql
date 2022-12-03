--liquibase formatted sql
--changeSet <postgres>:<create-owners-table>
CREATE TABLE IF NOT EXISTS public.owners
(
    id BIGINT NOT NULL,
    CONSTRAINT owners_id PRIMARY KEY (id)
);

--rollback DROP TABLE parts;
