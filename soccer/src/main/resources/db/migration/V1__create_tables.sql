CREATE TABLE game
(
    game_id         BIGINT AUTO_INCREMENT NOT NULL,
    local_goals     INT                   NOT NULL,
    visitor_goals   INT                   NOT NULL,
    finished        BIT(1)                NOT NULL,
    local_team_id   BIGINT                NULL,
    visitor_team_id BIGINT                NULL,
    CONSTRAINT pk_game PRIMARY KEY (game_id)
);

CREATE TABLE player
(
    player_id BIGINT       NOT NULL,
    name      VARCHAR(255) NULL,
    team_id   BIGINT       NULL,
    CONSTRAINT pk_player PRIMARY KEY (player_id)
);

CREATE TABLE team
(
    team_id BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)          NULL,
    scheme  VARCHAR(255)          NULL,
    CONSTRAINT pk_team PRIMARY KEY (team_id)
);

ALTER TABLE game
    ADD CONSTRAINT FK_GAME_ON_LOCAL_TEAM FOREIGN KEY (local_team_id) REFERENCES team (team_id);

ALTER TABLE game
    ADD CONSTRAINT FK_GAME_ON_VISITOR_TEAM FOREIGN KEY (visitor_team_id) REFERENCES team (team_id);

ALTER TABLE player
    ADD CONSTRAINT FK_PLAYER_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (team_id);