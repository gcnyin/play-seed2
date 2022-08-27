-- !Ups
create table "user"
(
    user_id    uuid         not null primary key,
    username   varchar(255) not null unique,
    created_at timestamp    not null,
    updated_at timestamp    not null
);
-- !Downs
drop table "user";
