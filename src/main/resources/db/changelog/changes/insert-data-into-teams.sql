--liquibase formatted sql
--changeset sql:insert-data-into-teams

INSERT INTO `football-manager`.`teams` (`balance`, `commission`, `city`, `country`, `title`)
VALUES ('1000000', '5', 'Madrid', 'Spain', 'Real Madrid');
INSERT INTO `football-manager`.`teams` (`balance`, `commission`, `city`, `country`, `title`)
VALUES ('800000', '6', 'Barcelona', 'Spain', 'FC Barcelona');
INSERT INTO `football-manager`.`teams` (`balance`, `commission`, `city`, `country`, `title`)
VALUES ('1200000', '4', 'Munich', 'Germany', 'Bayern Munich');
INSERT INTO `football-manager`.`teams` (`balance`, `commission`, `city`, `country`, `title`)
VALUES ('950000', '4', 'Turin', 'Italy', 'Juventus');
INSERT INTO `football-manager`.`teams` (`balance`, `commission`, `city`, `country`, `title`)
VALUES ('1100000', '6', 'Paris', 'France', 'Paris Saint-Germain');

