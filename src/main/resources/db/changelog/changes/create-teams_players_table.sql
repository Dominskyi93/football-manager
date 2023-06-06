--liquibase formatted sql
--changeset sql:create
--liquibase formatted sql
--changeset sql:create-teams_players_table

CREATE TABLE IF NOT EXISTS `teams_players`
(
    `players_id` bigint NOT NULL,
    `team_id`    bigint NOT NULL,
    PRIMARY KEY (`players_id`, `team_id`),
    UNIQUE KEY `UK_nb0pdbtxmay2vnw649e9i8n7t` (`players_id`),
    KEY `FKplpi00gxrp7xx6jhpeolx4ek1` (`team_id`),
    CONSTRAINT `FKic8mysm1vaupst5gfnw711cr3` FOREIGN KEY (`players_id`) REFERENCES `players` (`id`),
    CONSTRAINT `FKplpi00gxrp7xx6jhpeolx4ek1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;
