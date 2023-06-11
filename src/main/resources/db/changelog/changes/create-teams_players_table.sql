--liquibase formatted sql
--changeset sql:create
--liquibase formatted sql
--changeset sql:create-teams_players_table

CREATE TABLE IF NOT EXISTS `teams_players`
(
    `players_id` bigint NOT NULL,
    `team_id`    bigint NOT NULL,
    PRIMARY KEY (`players_id`, `team_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;
