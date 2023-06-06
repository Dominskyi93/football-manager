--liquibase formatted sql
--changeset sql:create-teams_table

CREATE TABLE IF NOT EXISTS `teams`
(
    `balance`    decimal(38, 2) DEFAULT NULL,
    `commission` decimal(38, 2) DEFAULT NULL,
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `city`       varchar(255)   DEFAULT NULL,
    `country`    varchar(255)   DEFAULT NULL,
    `title`      varchar(255)   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;

--rollback DROP TABLE teams;
