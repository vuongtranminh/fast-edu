package app.mybatis;

import java.io.File;

public class MybatisConfig {

    public static String WORKING = System.getProperty("user.dir");

    public static final String FILE_SEPARATOR = File.separator;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "TranMinhVuong@10052000";

    public static final String SERVICE = "course-service";


    public static String createDirectory(String pkg) {
        StringBuilder sb = new StringBuilder();
        return sb.append(WORKING)
                .append(FILE_SEPARATOR)
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
                .append(pkg)
                .toString();
    }

    public static String createPackageImport(String pkg) {
        return "app.command.api." + pkg;
    }

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

    public static final String DIRECTORY_DATA = createDirectory("data");
    public static final String DIRECTORY_MODEL = createDirectory("model");
    public static final String DIRECTORY_EVENTS = createDirectory("events");
    public static final String DIRECTORY_CONTROLLER = createDirectory("controller");
    public static final String DIRECTORY_COMMANDS = createDirectory("commands");
    public static final String DIRECTORY_AGGREGATE = createDirectory("aggregate");

    public static final String PACKAGE = createPackageImport("data");
    public static final String PACKAGE_DATA = createPackageImport("data");
    public static final String PACKAGE_MODEL = createPackageImport("model");
    public static final String PACKAGE_EVENTS = createPackageImport("events");
    public static final String PACKAGE_CONTROLLER = createPackageImport("controller");
    public static final String PACKAGE_COMMANDS = createPackageImport("commands");
    public static final String PACKAGE_AGGREGATE = createPackageImport("aggregate");

}
