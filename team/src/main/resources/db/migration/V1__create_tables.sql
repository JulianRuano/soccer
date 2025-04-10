CREATE TABLE team (
    team_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    scheme VARCHAR(255)
);

CREATE TABLE player (
    player_id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    team_id BIGINT,
    CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES team(team_id)
);
