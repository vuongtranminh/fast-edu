package app.mybatis;

import java.io.File;

public class MybatisConfig {

    public static String WORKING = System.getProperty("user.dir");

    public static final String FILE_SEPARATOR = File.separator;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "TranMinhVuong@10052000";

    public static final String SERVICE = "course-service";


    public static String createDirectory(String directory, String pkg) {
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
                .append(directory)
                .append(FILE_SEPARATOR)
                .append(pkg)
                .toString();
    }

    public static String createPackageImport(String directory, String pkg) {
        return "app." + directory + pkg;
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

    public static final String DIRECTORY_COMMAND = "command" + FILE_SEPARATOR + "api";
    public static final String DIRECTORY_COMMAND_DATA_ENTITY = createDirectory(DIRECTORY_COMMAND, "data" + FILE_SEPARATOR + "entity");
    public static final String DIRECTORY_COMMAND_DATA_DAO = createDirectory(DIRECTORY_COMMAND, "data" + FILE_SEPARATOR + "dao");
    public static final String DIRECTORY_COMMAND_MODEL = createDirectory(DIRECTORY_COMMAND, "model");
    public static final String DIRECTORY_COMMAND_EVENTS = createDirectory(DIRECTORY_COMMAND, "events");
    public static final String DIRECTORY_COMMAND_CONTROLLER = createDirectory(DIRECTORY_COMMAND, "controller");
    public static final String DIRECTORY_COMMAND_COMMANDS = createDirectory(DIRECTORY_COMMAND, "commands");
    public static final String DIRECTORY_COMMAND_AGGREGATE = createDirectory(DIRECTORY_COMMAND, "aggregate");

    public static final String PACKAGE_COMMAND = "command.api.";
    public static final String PACKAGE = createPackageImport(PACKAGE_COMMAND, "data");
    public static final String PACKAGE_COMMAND_DATA = createPackageImport(PACKAGE_COMMAND, "data");
    public static final String PACKAGE_COMMAND_DATA_ENTITY = createPackageImport(PACKAGE_COMMAND, "data.entity");
    public static final String PACKAGE_COMMAND_DATA_DAO = createPackageImport(PACKAGE_COMMAND, "data.dao");
    public static final String PACKAGE_COMMAND_MODEL = createPackageImport(PACKAGE_COMMAND, "model");
    public static final String PACKAGE_COMMAND_EVENTS = createPackageImport(PACKAGE_COMMAND, "events");
    public static final String PACKAGE_COMMAND_CONTROLLER = createPackageImport(PACKAGE_COMMAND, "controller");
    public static final String PACKAGE_COMMAND_COMMANDS = createPackageImport(PACKAGE_COMMAND, "commands");
    public static final String PACKAGE_COMMAND_AGGREGATE = createPackageImport(PACKAGE_COMMAND, "aggregate");

    public static final String DIRECTORY_QUERY = "query" + FILE_SEPARATOR + "api";
    public static final String DIRECTORY_QUERY_MODEL = createDirectory(DIRECTORY_QUERY, "model");
    public static final String DIRECTORY_QUERY_QUERIES = createDirectory(DIRECTORY_QUERY, "queries");

    public static final String PACKAGE_QUERY = "query.api.";
    public static final String PACKAGE_QUERY_MODEL = createPackageImport(PACKAGE_QUERY, "model");
    public static final String PACKAGE_QUERY_QUERIES = createPackageImport(PACKAGE_QUERY, "queries");

}
