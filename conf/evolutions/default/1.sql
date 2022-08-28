-- !Ups
create table "play_seed"."user"
(
    user_id    uuid         not null primary key,
    username   varchar(255) not null unique,
    password   varchar(255) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);
-- !Downs
drop table "play_seed"."user";
