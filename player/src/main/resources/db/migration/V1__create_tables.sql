CREATE TABLE player
(
    player_id BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)          NULL,
    position  SMALLINT              NULL,
    skill     INT                   NOT NULL,
    energy    INT                   NOT NULL,
    CONSTRAINT pk_player PRIMARY KEY (player_id)
);