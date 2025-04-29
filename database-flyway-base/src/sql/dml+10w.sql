CREATE OR REPLACE FUNCTION generate_students(num_records INTEGER)
RETURNS VOID AS $$
DECLARE
i INTEGER;
    random_name TEXT;
    random_age INTEGER;
BEGIN
FOR i IN 1..num_records LOOP
        -- 生成随机姓名
        random_name := 'Student_' || i;
        -- 生成随机年龄（假设年龄在18到25之间）
        random_age := FLOOR(RANDOM() * (25 - 18 + 1)) + 18;

        -- 插入数据
INSERT INTO student (name, age) VALUES (random_name, random_age);
END LOOP;
END;
$$ LANGUAGE plpgsql;

SELECT generate_students(100000);