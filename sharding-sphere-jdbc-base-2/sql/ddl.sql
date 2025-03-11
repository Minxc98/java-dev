
CREATE DATABASE config;

\c config;

-- 创建 t_order 表
CREATE TABLE public.client_config
(
    id    SERIAL PRIMARY KEY,                                             -- 自增主键
    client_id   bigint ,                                          -- 配置键
    ds_name TEXT         NOT NULL
);


insert into public.client_config(client_id,ds_name) values(1,'ds0');
insert into public.client_config(client_id,ds_name) values(2,'ds1');

alter table public.client_config
    owner to postgres;




CREATE DATABASE test1;

\c test1;

-- 创建 t_order 表
CREATE TABLE public.t_order
(
    order_id BIGINT NOT NULL PRIMARY KEY, -- 使用 SNOWFLAKE 生成的主键
    user_id  INT    NOT NULL
);

-- 创建 t_order_item 表
CREATE TABLE public.t_order_item
(
    order_item_id BIGINT NOT NULL PRIMARY KEY, -- 使用 SNOWFLAKE 生成的主键
    order_id      BIGINT NOT NULL
);
-- 创建 t_config 表
CREATE TABLE t_config
(
    config_id    SERIAL PRIMARY KEY,                                             -- 自增主键
    config_key   VARCHAR(255) NOT NULL,                                          -- 配置键
    config_value TEXT         NOT NULL
);


alter table public.t_order
    owner to postgres;
alter table public.t_order_item
    owner to postgres;
alter table public.t_config
    owner to postgres;

insert into public.t_order(order_id,user_id) values(1,1);
insert into public.t_order(order_id,user_id) values(2,2);

insert into public.t_order_item(order_item_id,order_id) values(1,1);
insert into public.t_order_item(order_item_id,order_id) values(2,2);

CREATE DATABASE test2;

\c test2;

-- 创建 t_order 表
CREATE TABLE public.t_order
(
    order_id BIGINT NOT NULL PRIMARY KEY, -- 使用 SNOWFLAKE 生成的主键
    user_id  INT    NOT NULL
);

-- 创建 t_order_item 表
CREATE TABLE public.t_order_item
(
    order_item_id BIGINT NOT NULL PRIMARY KEY, -- 使用 SNOWFLAKE 生成的主键
    order_id      BIGINT NOT NULL
);
CREATE TABLE t_config
(
    config_id    SERIAL PRIMARY KEY,                                             -- 自增主键
    config_key   VARCHAR(255) NOT NULL,                                          -- 配置键
    config_value TEXT         NOT NULL
);

insert into public.t_order(order_id,user_id) values(3,3);
insert into public.t_order(order_id,user_id) values(4,4);

insert into public.t_order_item(order_item_id,order_id) values(3,3);
insert into public.t_order_item(order_item_id,order_id) values(4,4);


alter table public.t_order
    owner to postgres;
alter table public.t_order_item
    owner to postgres;
alter table public.t_config
    owner to postgres;


