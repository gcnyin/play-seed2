-- !Ups
create table "user"
(
    user_id    uuid         not null primary key,
    username   varchar(255) not null unique,
    password   varchar(255) not null,
    created_at timestamptz  not null,
    updated_at timestamptz  not null
);

create table "role"
(
    role_id    uuid         not null primary key,
    name       varchar(255) not null unique,
    created_at timestamptz  not null,
    updated_at timestamptz  not null
);

create table "permission"
(
    permission_id uuid         not null primary key,
    name          varchar(255) not null unique,
    created_at    timestamptz  not null,
    updated_at    timestamptz  not null
);

create table "user_role"
(
    user_id    uuid        not null primary key,
    role_id    uuid        not null,
    created_at timestamptz not null,
    updated_at timestamptz not null
);

create table "role_permission"
(
    role_id       uuid        not null primary key,
    permission_id uuid        not null,
    created_at    timestamptz not null,
    updated_at    timestamptz not null
);
-- !Downs
drop table "user";
drop table "role";
drop table "permission";
drop table "user_role";
drop table "role_permission";
