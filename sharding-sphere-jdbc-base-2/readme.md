## 项目排错
1.项目使用HikariDataSource的时候发现postgres驱动出现了`这个 org.postgresql.jdbc.PgDatabaseMetaData.getRowIdLifetime() 方法尚未被实作`的错误，
2.不支持spring boot 3.x
3.要添加依赖jaxb-api的实现
4.发现Sharding value must implements Comparable--使用了主键生成策略不能使用自增
5.报错ested exception is org.apache.ibatis.exceptions.PersistenceException:
### Error updating database.  Cause: java.lang.reflect.InaccessibleObjectException: Unable to make field private static final long java.lang.Number.serialVersionUID accessible: module java.base does not "opens java.lang" to unnamed module @1324409e
这是由于jdk版本太高，一种解决方法是直接换jdk 1.8，不过既然是学习，就是要折腾，只需要在启动参数上添加--add-opens=java.base/java.lang=ALL-UNNAMED就可以了


https://www.cnblogs.com/code-blog/p/16710282.html