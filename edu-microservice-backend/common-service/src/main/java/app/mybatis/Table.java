package app.mybatis;

import java.util.Map;

import static app.mybatis.Helper.className;
import static app.mybatis.MySQLDataType.LONGTEXT;

public class Table {

    private String tableName;
    private String className;
    private String primaryKeyColumnName;
    private Field primaryKeyInfo;
    private Map<String, Field> columnInfo;

    public Table(String tableName, String primaryKeyColumnName, Map<String, Field> columnInfo) {
        this.tableName = tableName;
        this.className = className(tableName);
        this.primaryKeyColumnName = primaryKeyColumnName;
        this.primaryKeyInfo = columnInfo.get(primaryKeyColumnName);
        this.columnInfo = columnInfo;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPrimaryKeyColumnName() {
        return primaryKeyColumnName;
    }

    public void setPrimaryKeyColumnName(String primaryKeyColumnName) {
        this.primaryKeyColumnName = primaryKeyColumnName;
    }

    public Field getPrimaryKeyInfo() {
        return primaryKeyInfo;
    }

    public void setPrimaryKeyInfo(Field primaryKeyInfo) {
        this.primaryKeyInfo = primaryKeyInfo;
    }

    public Map<String, Field> getColumnInfo() {
        return columnInfo;
    }

    public void setColumnInfo(Map<String, Field> columnInfo) {
        this.columnInfo = columnInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {\n");
        sb.append("\tHash: ").append(hashCode()).append(", \n");
        sb.append("\ttableName: ").append(tableName).append(", \n");
        sb.append("\tprimaryKeyColumnName: ").append(primaryKeyColumnName).append(", \n");
        sb.append("\tcolumnInfo: [\n");
        columnInfo.forEach((columnName, column) -> {
            sb.append("\t\t").append(columnName).append(": ").append(column.toString()).append(", \n");
        });
        sb.append("\t], \n");
        sb.append("}");
        return sb.toString();
    }

//    public String generatePo(String packaje) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sbImport = new StringBuilder();
//        StringBuilder sbInstance = new StringBuilder();
//        StringBuilder sbConstructor = new StringBuilder();
//        StringBuilder sbAccessors  = new StringBuilder();
//
//        sbImport.append("import java.io.Serializable;\n");
//
//        columnInfo.forEach((columnName, column) -> {
//            if(sbImport.indexOf(column.generateImport()) == -1) {
//                sbImport.append(column.generateImport());
//            }
//            sbInstance.append(column.generateInstance());
//            sbAccessors.append(column.generateAccessor());
//        });
//
//        sb.append("package " + packaje + ";\n\n");
//        sb.append(sbImport);
//        sb.append("\n");
//        sb.append("public class " + className + "Po implements Serializable {\n\n");
//        sb.append("\tprivate static final long serialVersionUID = 1L;\n");
//        sb.append(sbInstance);
//        sb.append("\n");
//        sb.append(sbConstructor);
//        sb.append("\n");
//        sb.append(sbAccessors);
//        sb.append("\n");
//        sb.append("}");
//
//        return sb.toString();
//    }

    public String generateMapper(String packaje) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbBaseResultMap = new StringBuilder();
        StringBuilder sbResultMapWithBLOBs = new StringBuilder();
        StringBuilder sbBaseColumnList = new StringBuilder();
        StringBuilder sbBlobColumnList = new StringBuilder();

        columnInfo.forEach((columnName, column) -> {
            if(columnName.equals(primaryKeyColumnName)) {
                sbBaseResultMap.insert(0, column.generateResult());
                sbBaseColumnList.insert(0, column.getColumnName() + ", ");
            } else {
                if((LONGTEXT).equals(column.getDatatype())) {
                    sbResultMapWithBLOBs.append(column.generateResult());
                    sbBlobColumnList.append(column.getColumnName()).append(", ");
                } else {
                    sbBaseResultMap.append(column.generateResult());
                    sbBaseColumnList.append(column.getColumnName()).append(", ");
                }
            }
        });

        boolean isBlob = sbBlobColumnList.length() != 0;

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        sb.append("<mapper namespace=\"" + packaje + "." + className + "Mapper\">\n");

        sb.append("\t<resultMap id=\"BaseResultMap\" type=\"" + packaje + "." + className + "Po\">\n");
        sb.append(sbBaseResultMap);
        sb.append("\t</resultMap>\n");

        if(isBlob) {
            sb.append("\t<resultMap extends=\"BaseResultMap\" id=\"ResultMapWithBLOBs\" type=\"" + packaje + "." + className + "Po\">\n");
            sb.append(sbResultMapWithBLOBs);
            sb.append("\t</resultMap>\n");
        }

        sb.append("\t<sql id=\"Base_Column_List\">\n");
        sb.append("\t\t").append(sbBaseColumnList.delete(sbBaseColumnList.length() - 2, sbBaseColumnList.length())).append("\n"); // remove ", "
        sb.append("\t</sql>\n");

        if(isBlob) {
            sb.append("\t<sql id=\"Blob_Column_List\">\n");
            sb.append("\t\t").append(sbBlobColumnList.delete(sbBlobColumnList.length() - 2, sbBlobColumnList.length())).append("\n"); // remove ", "
            sb.append("\t</sql>\n");
        }

        sb.append(generateBaseFunc(isBlob, packaje));

        sb.append("</mapper>");

        return sb.toString();
    }

    public String generateBaseFunc(boolean isBlob, String packaje) {
        StringBuilder sb = new StringBuilder();
        StringBuilder columnList = new StringBuilder();
        StringBuilder columnListUpdate = new StringBuilder();

        columnInfo.forEach((columnName, column) -> {
            String columnType = column.generateColumnType();
            columnList.append(columnType).append(", ");
            columnListUpdate.append("\t\t\t\t<if test=\"").append(column.getColumnNameWithCamel()).append(" != null\">\n");
            columnListUpdate.append("\t\t\t\t\t").append(column.getColumnName()).append(" = ").append(columnType).append(", \n");
            columnListUpdate.append("\t\t\t\t</if>\n");
        });

        columnList.delete(columnList.length() - 2, columnList.length());

        if(isBlob) {
            // findAll
            sb.append("\t<select id=\"findAll\" resultMap=\"ResultMapWithBLOBs\">\n");
            sb.append("\t\tselect <include refid=\"Base_Column_List\" />, <include refid=\"Blob_Column_List\" /> from ")
                    .append(tableName).append("\n");
            sb.append("\t</select>\n");

            // selectById
            sb.append("\t<select id=\"getById\"");
            if(primaryKeyInfo.getJavaImport() != null) {
                sb.append(" parameterType=\"" + primaryKeyInfo.getJavaImport() + "\"");
            }
            sb.append(" resultMap=\"ResultMapWithBLOBs\">\n");
            sb.append("\t\tselect <include refid=\"Base_Column_List\" />, <include refid=\"Blob_Column_List\" /> from ")
                    .append(tableName).append(" where ").append(primaryKeyColumnName).append(" = ")
                    .append(primaryKeyInfo.generateColumnType()).append("\n");
            sb.append("\t</select>\n");
        } else {
            // findAll
            sb.append("\t<select id=\"findAll\" resultMap=\"BaseResultMap\">\n");
            sb.append("\t\tselect <include refid=\"Base_Column_List\" /> from ")
                    .append(tableName).append("\n");
            sb.append("\t</select>\n");

            // selectById
            sb.append("\t<select id=\"getById\"");
            if(primaryKeyInfo.getJavaImport() != null) {
                sb.append(" parameterType=\"" + primaryKeyInfo.getJavaImport() + "\"");
            }
            sb.append(" resultMap=\"BaseResultMap\">\n");
            sb.append("\t\tselect <include refid=\"Base_Column_List\" /> from ")
                    .append(tableName).append(" where ").append(primaryKeyColumnName).append(" = ")
                    .append(primaryKeyInfo.generateColumnType()).append("\n");
            sb.append("\t</select>\n");
        }

        // save
        sb.append("\t<insert id=\"save\" parameterType=\"" + packaje + "." + className + "Po\">\n");
        sb.append("\t\tinsert into ").append(tableName).append(" (<include refid=\"Base_Column_List\" />, <include refid=\"Blob_Column_List\" />) \n\t\tvalues (")
                .append(columnList).append(")\n");
        sb.append("\t</insert>\n");

        // updateById
        sb.append("\t<update id=\"updateById\" parameterType=\"" + packaje + "." + className + "Po\">\n");
        sb.append("\t\tupdate ").append(tableName).append("\n\t\t\t<set>\n").append(columnListUpdate).append("\n\t\t\t</set> \n")
                .append("\t\twhere " ).append(primaryKeyColumnName).append(" = ").append(primaryKeyInfo.generateColumnType())
                .append("\n").append("\t</update>\n");

        // deleteById
        sb.append("\t<delete id=\"deleteById\"");
        if(primaryKeyInfo.getJavaImport() != null) {
            sb.append(" parameterType=\"" + primaryKeyInfo.getJavaImport() + "\"");
        }
        sb.append(">\n");
        sb.append("\t\tdelete from ").append(tableName).append(" where " ).append(primaryKeyColumnName).append(" = ")
                .append(primaryKeyInfo.generateColumnType()).append("\n");
        sb.append("\t</delete>\n");

        if(isBlob) {
            // pagination
            sb.append("\t<select id=\"pagination\" parameterType=\"").append(packaje).append(".Pagination\" resultMap=\"ResultMapWithBLOBs\">\n")
                    .append("\t\tselect <include refid=\"Base_Column_List\" />, <include refid=\"Blob_Column_List\" /> from ")
                    .append(tableName).append(" \n").append("\t\torder by id desc \n").append("\t\tlimit #{offset, jdbcType=BIGINT} ,#{limit,jdbcType=INTEGER}\n")
                    .append("\t</select>\n");
        } else {
            // pagination
            sb.append("\t<select id=\"pagination\" parameterType=\"").append(packaje).append(".Pagination\" resultMap=\"BaseResultMap\">\n")
                    .append("\t\tselect <include refid=\"Base_Column_List\" /> from ")
                    .append(tableName).append(" \n").append("\t\torder by id desc \n").append("\t\tlimit #{offset, jdbcType=BIGINT} ,#{limit,jdbcType=INTEGER}\n")
                    .append("\t</select>\n");
        }

        // countAll
        sb.append("\t<select id=\"countAll\" resultType=\"java.lang.Long\">\n").append("\t\tselect count(*) from ").append(tableName)
                .append("\n").append("\t</select>\n");

        return sb.toString();
    }

    public String generateDao(String packaje) {
        StringBuilder sb = new StringBuilder();

        sb.append("package ").append(packaje).append(";\n\n");
        sb.append("import java.util.List;\n");
        sb.append("import org.apache.ibatis.annotations.Mapper;\n");
        sb.append("import ").append(packaje).append(".").append(className).append("Po;\n\n");
        sb.append("@Mapper\n");
        sb.append("public interface ").append(className).append("Dao extends BaseDao<").append(className).append("Po> {\n\n");
        sb.append("}");

        return sb.toString();
    }

    public String generateClass(String pkg, String className, boolean isGenerateAllArgsConstructor, boolean isGenerateBuilder, boolean isGenerateCommand) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbImport = new StringBuilder();
        StringBuilder sbInstance = new StringBuilder();
        StringBuilder sbAccessors  = new StringBuilder();

        sbImport.append("import java.io.Serializable;\n");

        if(isGenerateCommand) {
            sbImport.append("import org.axonframework.modelling.command.TargetAggregateIdentifier;\n");
        }

        columnInfo.forEach((columnName, column) -> {
            if(sbImport.indexOf(column.generateImport()) == -1) {
                sbImport.append(column.generateImport());
            }
            if(columnName.equals(primaryKeyColumnName)) {
                if(isGenerateCommand) {
                    sbInstance.insert(0, "\t@TargetAggregateIdentifier\n" + column.generateInstance());
                } else {
                    sbInstance.insert(0, column.generateInstance());
                }
                sbAccessors.insert(0, column.generateAccessor());
            } else {
                sbInstance.append(column.generateInstance());
                sbAccessors.append(column.generateAccessor());
            }
        });

        sb.append("package " + pkg + ";\n\n");
        sb.append(sbImport);
        sb.append("\n");
        sb.append("public class " + className + " implements Serializable {\n\n");
        sb.append("\tprivate static final long serialVersionUID = 1L;\n\n");
        sb.append(sbInstance);
        sb.append("\n");
        if(isGenerateAllArgsConstructor || isGenerateBuilder) {
            String sbConstructor = generateAllArgsConstructor(className);
            sb.append(sbConstructor);
            sb.append("\n");
        }
        sb.append(sbAccessors);
        sb.append("\n");
        if(isGenerateBuilder) {
            String sbBuilder = generateBuider(className);
            sb.append(sbBuilder);
            sb.append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

    public String generatePo(String pkg) {
        return generateClass(pkg, className + "Po", false, false, false);
    }

    public String generateRequestModel(String pkg) {
        return generateClass(pkg, className + "RequestModel", true, true, false);
    }

    public String generateCreatedEvent(String pkg) {
        return generateClass(pkg, className + "CreatedEvent", true, true, false);
    }

    public String generateUpdatedEvent(String pkg) {
        return generateClass(pkg, className + "UpdatedEvent", true, true, false);
    }

    public String generateDeletedEvent(String pkg) {
        return generateDeleteClass(pkg, className + "DeletedEvent", false);
    }

    public String generateCreateCommand(String pkg) {
        return generateClass(pkg, "Create" + className + "Command", true, true, true);
    }

    public String generateUpdateCommand(String pkg) {
        return generateClass(pkg, "Update" + className + "Command", true, true, true);
    }

    public String generateDeleteCommand(String pkg) {
        return generateDeleteClass(pkg, "Delete" + className + "Command", true);
    }

    public String generateDeleteClass(String pkg, String className, boolean isGenerateCommand) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbImport = new StringBuilder();
        StringBuilder sbInstance = new StringBuilder();
        StringBuilder sbAccessors  = new StringBuilder();

        sbImport.append("import java.io.Serializable;\n");
        if(isGenerateCommand) {
            sbImport.append("import org.axonframework.modelling.command.TargetAggregateIdentifier;\n");
        }

        sb.append("package " + pkg + ";\n\n");
        sb.append(sbImport.append(primaryKeyInfo.generateImport()));
        sb.append("\n");
        sb.append("public class " + className + " implements Serializable {\n\n");
        sb.append("\tprivate static final long serialVersionUID = 1L;\n\n");
        if(isGenerateCommand) {
            sbInstance.append("\t@TargetAggregateIdentifier\n");
        }
        sb.append(sbInstance.append(primaryKeyInfo.generateInstance()));
        sb.append("\n");
        sb.append(sbAccessors.append(primaryKeyInfo.generateAccessor()));
        sb.append("\n");
        sb.append("}");

        return sb.toString();
    }

    public String generateBuider(String className) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbInstance = new StringBuilder();
        StringBuilder sbAccessorsBuilder  = new StringBuilder();
        StringBuilder sbBuilder = new StringBuilder();

        sbBuilder.append("\t\tpublic " + className + " build() {\n")
                        .append("\t\t\treturn new " + className + "(");

        columnInfo.forEach((columnName, column) -> {
            sbInstance.append("\t").append(column.generateInstance());
            sbAccessorsBuilder.append(column.generateAccessorBuilder(className + "Builder"));
            sbBuilder.append("this." + column.getColumnNameWithCamel() + ", ");
        });

        sbBuilder.delete(sbBuilder.length() - 2, sbBuilder.length());
        sbBuilder.append(");\n\t\t}\n");

        sb.append("\tpublic static " + className + "Builder builder() {\n\t\treturn new " + className + "Builder();\n\t}\n");

        sb.append("\tpublic static class " + className + "Builder {\n\n");
        sb.append(sbInstance);
        sb.append("\n");
        sb.append(sbAccessorsBuilder);
        sb.append("\n");
        sb.append(sbBuilder);
        sb.append("\n\t}");

        return sb.toString();
    }

    public String generateAllArgsConstructor(String className) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbInnerConstructor = new StringBuilder();

        sb.append("\tpublic " + className + "(");
        columnInfo.forEach((columnName, column) -> {
            sb.append(column.getJavaType() + " " + column.getColumnNameWithCamel() + ", ");
            sbInnerConstructor.append("\t\tthis." + column.getColumnNameWithCamel() + " = " + column.getColumnNameWithCamel() + ";\n");
        });
        sb.delete(sb.length() - 2, sb.length());
        sb.append(") {\n");
        sb.append(sbInnerConstructor);
        sb.append("\t}");
        return sb.toString();
    }

}
