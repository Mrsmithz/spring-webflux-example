USE test;

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id         int auto_increment primary key,
    first_name varchar(255),
    last_name  varchar(255),
    email      varchar(255) not null unique,
    picture    varchar(255),
    role       varchar(255) default 'LEARNER',
    created_at timestamp    default current_timestamp,
    updated_at timestamp    default current_timestamp on update current_timestamp
);

DROP TABLE IF EXISTS course;

CREATE TABLE course
(
    id          int auto_increment primary key,
    title       varchar(255) not null,
    password    varchar(255),
    description varchar(255),
    banner      varchar(255),
    status      varchar(255) default 'INACTIVE',
    created_by  int          not null,
    created_at  timestamp    default current_timestamp,
    updated_at  timestamp    default current_timestamp on update current_timestamp,
    foreign key (created_by) references user (id)
);

DROP TABLE IF EXISTS users_in_courses;

CREATE TABLE users_in_courses
(
    user_id    int not null,
    course_id  int not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,

    primary key (user_id, course_id),
    foreign key (user_id) references user (id),
    foreign key (course_id) references course (id)
)