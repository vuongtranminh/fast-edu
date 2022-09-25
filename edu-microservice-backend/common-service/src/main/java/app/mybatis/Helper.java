package app.mybatis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static app.mybatis.MySQLDataType.*;
import static app.mybatis.MybatisConfig.FILE_SEPARATOR;

public class Helper {
    public static String snakeToCamel(String str) {

        // Convert to StringBuilder
        StringBuilder builder = new StringBuilder(str);

        // Traverse the string character by
        // character and remove underscore
        // and capitalize next letter
        for (int i = 0; i < builder.length(); i++) {

            // Check char is underscore
            if (builder.charAt(i) == '_') {

                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }

        // Return in String type
        return builder.toString();
    }

    public static String className(String str) {
        str = snakeToCamel(str);
        // Capitalize first letter of string
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        return str;
    }

    public static JavaType convertJavaType(String datatype) {
        JavaType javaType = null;
        switch (datatype) {
            case BIGINT:
                javaType = new JavaType("Long", null);
                break;
            case INT:
                javaType = new JavaType("Integer", null);
                break;
            case DECIMAL:
                javaType = new JavaType("BigDecimal", "java.math.BigDecimal");
                break;
            case TINYINT:
                javaType = new JavaType("Byte", null);
                break;
            case VARCHAR:
            case LONGTEXT:
                javaType = new JavaType("String", null);
                break;
            case DATE:
                javaType = new JavaType("Date", "java.util.Date");
                break;
            case BIT:
                javaType = new JavaType("Boolean", null);
                break;
            case TIMESTAMP:
                javaType = new JavaType("Date", "java.util.Date");
                break;
            case CHAR:
                javaType = new JavaType("char", "null");
                break;
            default:
                System.out.println("note");
                System.out.println(datatype);
//                throw new RuntimeException();
        }
        return javaType;
    }

    public static String generatePagination(String packaje) {
        StringBuilder sb = new StringBuilder();

        sb.append("package ").append(packaje).append(";\n\n");
        sb.append("public class Pagination {\n\n");
        sb.append("\tprivate Long offset;\n");
        sb.append("\tprivate int limit;\n\n");
        sb.append("\tpublic Pagination(Long offset, int limit) {\n");
        sb.append("\t\tthis.offset = offset;\n");
        sb.append("\t\tthis.limit = limit;\n");
        sb.append("\t}\n\n");
        sb.append("\tpublic Long getOffset() { return offset; }\n");
        sb.append("\tpublic void setOffset(Long offset) { this.offset = offset; }\n");
        sb.append("\tpublic int getLimit() { return limit; }\n");
        sb.append("\tpublic void setLimit(int limit) { this.limit = limit; }\n");
        sb.append("}");

        return sb.toString();
    }

    public static String generateBaseDao(String packaje) {
        StringBuilder sb = new StringBuilder();

        sb.append("package ").append(packaje).append(";\n\n");
        sb.append("import java.util.List;\n");
        sb.append("import ").append(packaje).append(".Pagination;\n\n");
        sb.append("public interface BaseDao<T> {\n\n");
        sb.append("\tList<T> findAll();\n");
        sb.append("\tT getById(Long id);\n");
        sb.append("\tint save(T t);\n");
        sb.append("\tint updateById(T t);\n");
        sb.append("\tList<T> pagination(Pagination pagination);\n");
        sb.append("\tLong countAll();\n");
        sb.append("\n}");

        return sb.toString();
    }

    public static void writeFile(String directory, String fileName, String content) {
        makeDir(directory);
        try(
                FileWriter fw = new FileWriter(directory + FILE_SEPARATOR + fileName);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            System.out.println("Start write " + fileName);
            bw.write(content);
            System.out.println("Write " + fileName + " successfully!");
        } catch (IOException e) {
            System.err.println("[ERROR]: Write " + fileName + " fail! [" + e.getMessage() + "]");
        }
    }

    public static void makeDir(String directory) {
        Path path = Paths.get(directory);
        if(!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("Create directory " + path + " success.");
            } catch (IOException e) {
                System.err.println("[ERROR]: Create directory " + path + " fail: " + e.getMessage());
            }
        } else {
            System.out.println("Path = " + path + " is existed!");
        }
    }

}
