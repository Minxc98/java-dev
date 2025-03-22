create table public.student
(
    id   serial
        primary key,
    name text,
    age  integer
);


create table public.toy
(
    id   serial
        primary key,
    student_id integer,
    name text
);