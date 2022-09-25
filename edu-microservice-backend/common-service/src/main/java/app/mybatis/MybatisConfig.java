package app.mybatis;

import java.io.File;

public class MybatisConfig {
    public static final String FILE_SEPARATOR = File.separator;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "TranMinhVuong@10052000";

    public static final String SERVICE = "course-service";

    public static final String WORKING_FOLDER = new StringBuilder(FILE_SEPARATOR)
            .append(SERVICE)
            .append(FILE_SEPARATOR)
            .append("src")
            .append(FILE_SEPARATOR)
            .append("main")
            .append(FILE_SEPARATOR)
            .append("java")
            .append(FILE_SEPARATOR)
            .append("app")
            .append(FILE_SEPARATOR)
            .append("command")
            .append(FILE_SEPARATOR)
            .append("api")
            .append(FILE_SEPARATOR)
            .append("data")
            .toString();

    public static final String WORKING_RESOURCES = new StringBuilder(FILE_SEPARATOR)
            .append(SERVICE)
            .append(FILE_SEPARATOR)
            .append("src")
            .append(FILE_SEPARATOR)
            .append("main")
            .append(FILE_SEPARATOR)
            .append("resources")
            .append(FILE_SEPARATOR)
            .append("mybatis")
            .append(FILE_SEPARATOR)
            .append("mapper")
            .toString();

    public static final String PACKAGE = "app.command.api.data";
}
