CREATE TABLE player
(
    player_id BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    team_id   BIGINT NULL,
    CONSTRAINT pk_player PRIMARY KEY (player_id)
);

CREATE TABLE team
(
    team_id BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255) NULL,
    CONSTRAINT pk_team PRIMARY KEY (team_id)
);

ALTER TABLE player
    ADD CONSTRAINT FK_PLAYER_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (team_id);