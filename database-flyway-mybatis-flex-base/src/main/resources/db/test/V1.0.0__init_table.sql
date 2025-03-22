create table public.student_test
(
    id   serial
        primary key,
    name text,
    age  integer
);


create table public.toy_test
(
    id   serial
        primary key,
    student_id integer,
    name text
);