--liquibase formatted sql
--changeset sql:insert-data-into-teams_players

INSERT INTO `teams_players` (`players_id`, `team_id`)
VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1);

INSERT INTO `teams_players` (`players_id`, `team_id`)
VALUES (6, 2), (7, 2), (8, 2), (9, 2), (10, 2);

INSERT INTO `teams_players` (`players_id`, `team_id`)
VALUES (11, 3), (12, 3), (13, 3), (14, 3), (15, 3);

INSERT INTO `teams_players` (`players_id`, `team_id`)
VALUES (16, 4), (17, 4), (18, 4), (19, 4), (20, 4);

INSERT INTO `teams_players` (`players_id`, `team_id`)
VALUES (21, 5), (22, 5), (23, 5), (24, 5), (25, 5);
