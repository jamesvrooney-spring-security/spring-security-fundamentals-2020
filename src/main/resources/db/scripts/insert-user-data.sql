insert into users (id, username, password, enabled) values
(1, 'james', 'password', true);

insert into authorities (id, username, authority) values
(1, 'james', 'read'),
(2, 'james', 'write');

insert into users_authorities (user_id, authority_id) values
(1, 1);