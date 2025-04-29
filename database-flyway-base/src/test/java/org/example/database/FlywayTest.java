package org.example.database;

import org.example.database.dao.StudentMapper;
import org.example.database.entity.Student;
import org.example.database.service.StudentService;
import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;

import static org.junit.Assert.assertThrows;

public class FlywayTest {



    public static void main(String[] args) {

// ... existing code ...
        // Bug fix: Corrected the protocol for PostgreSQL
        String url = "jdbc:postgresql://127.0.0.1:5432/flyway?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=false&serverTimezone=GMT%2B8";
// ... existing code ...
        String user = "postgres";

        String password = "123456";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();



        // 创建 flyway_schema_history 表

		flyway.baseline();



        // 删除 flyway_schema_history 表中失败的记录

//		flyway.repair();



        // 检查 sql 文件

		flyway.validate();



        // 执行数据迁移

        flyway.migrate();



        // 删除当前 schema 下所有表

//		flyway.clean();

    }

}