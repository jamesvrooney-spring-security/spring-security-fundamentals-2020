CREATE TABLE IF NOT EXISTS users
(
    id integer NOT NULL PRIMARY KEY,
    username character varying NOT NULL,
    password character varying NOT NULL,
    enabled boolean
);

CREATE TABLE IF NOT EXISTS authorities (
    id integer NOT NULL PRIMARY KEY,
    username character varying NOT NULL,
    authority character varying NOT NULL
);

CREATE TABLE IF NOT EXISTS users_authorities
(
    user_id bigint NOT NULL,
    authority_id bigint NOT NULL,
    CONSTRAINT "authorityIdFK" FOREIGN KEY (authority_id)
        REFERENCES authorities (id),
    CONSTRAINT "userIdFK" FOREIGN KEY (user_id)
        REFERENCES users (id)
);