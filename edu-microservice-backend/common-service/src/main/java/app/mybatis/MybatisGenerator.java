package app.mybatis;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static app.mybatis.Helper.*;
import static app.mybatis.MybatisConfig.*;

public class MybatisGenerator {

    private static Scanner sc = new Scanner(System.in);
    private static String schema = "";
    private static String WORKING = System.getProperty("user.dir");
    private static String WORKING_DIRECTORY = WORKING + WORKING_FOLDER;
    private static String WORKING_MAPPER_XML = WORKING + WORKING_RESOURCES;

    public static void main(String[] args) {
        program();
    }

    public static void program() {
        try (Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD)) {

            // get DatabaseMetaData object
            DatabaseMetaData dbmd = conn.getMetaData();

            System.out.println("Connect to [" + schema + "] successfully!");
            System.out.println("+++ PLEASE CHOOSE FUNC +++");
            System.out.println("1. Show info DB");
            System.out.println("2. Generate table");
            System.out.println("0. Exit");

            String input = "";
            while (input.trim().isEmpty()) {
                System.out.println("Your choose: ");
                input = sc.nextLine();
                if(!input.trim().isEmpty()) {
                    try {
                        int chooseFunc = Integer.parseInt(input);
                        switch (chooseFunc) {
                            case 1:
                                System.out.println("SHOW INFO DB");
                                showInfoDB(dbmd);
                                break;
                            case 2:
                                System.out.println("GENERATE TABLE");
                                generateTable(dbmd);
                                break;
                            case 0:
                                System.out.println("=> Exit!");
                                return;
                            default:
                                System.err.println("[ERROR]: Your choose is a number [0, 1, 2]!");
                                input = "";
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("[ERROR]: Your choose is a number [0, 1, 2]!");
                        input = "";
                    }
                } else {
                    System.err.println("[ERROR]: Your choose is valid!");
                }
            }
        } catch (Exception ex) {
            System.err.println("[ERROR]: Connect to [" + schema + "] failure!");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String urlDB, String userName, String password) {
        Connection conn = null;
        while(schema.trim().isEmpty() || conn == null) {
            System.out.println("Please enter schema: ");
            schema = sc.nextLine();
            if(!schema.trim().isEmpty()) {
                try {
                    // connect to database
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(urlDB + "/" + schema, userName, password);
                    // get DatabaseMetaData object
                } catch (SQLException e) {
                    System.err.println("[ERROR]: " + e.getMessage());
                    conn = null;
                } catch (ClassNotFoundException e) {
                    System.err.println("[ERROR]: " + e.getMessage());
                    conn = null;
                }
            } else {
                System.err.println("[ERROR]: Scheme is valid!");
            }
        }
        return conn;
    }

    public static void showInfoDB(DatabaseMetaData dbmd) throws SQLException {
        System.out.println("Driver Name: " + dbmd.getDriverName());
        System.out.println("Driver Version: " + dbmd.getDriverVersion());
        System.out.println("UserName: " + dbmd.getUserName());
        System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
        System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
    }

    public static void generateTable(DatabaseMetaData dbmd) throws SQLException {

        // writeBaseDao
        writeFile(DIRECTORY_COMMAND_DATA_DAO, "BaseMapper.java", generateBaseMapper(PACKAGE_COMMAND_DATA_DAO));

        // writePagination
        writeFile(WORKING_DIRECTORY, "Pagination.java", generatePagination(PACKAGE));

        Table tableInfo;
        Map<String, Field> fieldsInfo;
        Map<String, Table> tablesInfo = new HashMap<>();

        String table[] = { "TABLE" };
        ResultSet tables = dbmd.getTables(schema, null, "%", table);

        while (tables.next()) {
            String catalog = tables.getString("TABLE_CAT");
            String schema = tables.getString("TABLE_SCHEM");
            String tableName = tables.getString("TABLE_NAME");
            System.out.println("Start generate table: " + tableName);

            ResultSet primaryKeys = dbmd.getPrimaryKeys(catalog, schema, tableName);

            String primaryKeyColumnName = "";
            String primaryKeyName = "";

            while(primaryKeys.next()){
                primaryKeyColumnName = primaryKeys.getString("COLUMN_NAME");
                primaryKeyName = primaryKeys.getString("PK_NAME");
            }

//            System.out.println(catalog);
//            System.out.println(schema);

            ResultSet columns = dbmd.getColumns(catalog, schema, tableName, null);

            Field field;
            fieldsInfo = new HashMap<>();
            while(columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnSize = columns.getString("COLUMN_SIZE");
                String datatypeName = columns.getString("TYPE_NAME");
                String datatype = columns.getString("DATA_TYPE");
                String isNullable = columns.getString("IS_NULLABLE");
                String isAutoIncrement = columns.getString("IS_AUTOINCREMENT");
                Boolean isPrimaryKey = columnName.equals(primaryKeyColumnName);
                field = new Field(columnName, columnSize, datatypeName, datatype, isNullable, isAutoIncrement, isPrimaryKey);
//                System.out.println(field.toString());
                fieldsInfo.put(columnName, field);

            }

            tableInfo = new Table(tableName, primaryKeyColumnName, fieldsInfo);

//            System.out.println(tableInfo.toString());
//            System.out.println(tableInfo.generatePo(PACKAGE));
//            System.out.println(tableInfo.generateMapper(PACKAGE));

            // writePo
            writeFile(DIRECTORY_COMMAND_DATA_ENTITY, tableInfo.getClassName() + "Po.java", tableInfo.generatePo(PACKAGE_COMMAND_DATA_ENTITY));
            // writeDao
            writeFile(DIRECTORY_COMMAND_DATA_DAO, tableInfo.getClassName() + "Mapper.java", tableInfo.generateMapper(PACKAGE_COMMAND_DATA_DAO));
            // wirteMapper.xml
            writeFile(WORKING_MAPPER_XML, tableInfo.getClassName() + "Mapper.xml", tableInfo.generateMapperXML(PACKAGE_COMMAND_DATA_DAO));
            // wirteRequestModel
            writeFile(DIRECTORY_COMMAND_MODEL, tableInfo.getClassName() + "RequestModel.java", tableInfo.generateRequestModel(PACKAGE_COMMAND_MODEL));
            // writeCreatedEvent
            writeFile(DIRECTORY_COMMAND_EVENTS, tableInfo.getClassName() + "CreatedEvent.java", tableInfo.generateCreatedEvent(PACKAGE_COMMAND_EVENTS));
            // writeUpdatedEvent
            writeFile(DIRECTORY_COMMAND_EVENTS, tableInfo.getClassName() + "UpdatedEvent.java", tableInfo.generateUpdatedEvent(PACKAGE_COMMAND_EVENTS));
            // writeDeletedEvent
            writeFile(DIRECTORY_COMMAND_EVENTS, tableInfo.getClassName() + "DeletedEvent.java", tableInfo.generateDeletedEvent(PACKAGE_COMMAND_EVENTS));
            // writeCreateCommand
            writeFile(DIRECTORY_COMMAND_COMMANDS, "Create" + tableInfo.getClassName() + "Command.java", tableInfo.generateCreateCommand(PACKAGE_COMMAND_COMMANDS));
            // writeUpdateCommand
            writeFile(DIRECTORY_COMMAND_COMMANDS, "Update" + tableInfo.getClassName() + "Command.java", tableInfo.generateUpdateCommand(PACKAGE_COMMAND_COMMANDS));
            // writeDeleteCommand
            writeFile(DIRECTORY_COMMAND_COMMANDS, "Delete" + tableInfo.getClassName() + "Command.java", tableInfo.generateDeleteCommand(PACKAGE_COMMAND_COMMANDS));


            // writeGetAll
            writeFile(DIRECTORY_QUERY_QUERIES, "Get" + tableInfo.getClassName() + "sQuery.java", tableInfo.generateGetAllQuery(  PACKAGE_QUERY_QUERIES));
            // writeGet
            writeFile(DIRECTORY_QUERY_QUERIES, "Get" + tableInfo.getClassName() + "Query.java", tableInfo.generateGetQuery(PACKAGE_QUERY_QUERIES));
            // writeResponseModel
            writeFile(DIRECTORY_QUERY_MODEL, tableInfo.getClassName() + "ResponseModel.java", tableInfo.generateResponseModel(PACKAGE_QUERY_MODEL));

            tablesInfo.put(tableName, tableInfo);
        }
    }

}
