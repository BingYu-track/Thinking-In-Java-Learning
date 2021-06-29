package annotations.database;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/27
 */
public class TableCreator { //读取一个类文件，检查其上的数据库注解，并生成用来创建数据库的sql命令

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class); //获取类中的DBTable注解
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase(); //如果dbTable注解里没有名字，就用类的名字
            }
            List<String> columnDefs = new ArrayList<String>(); //用来存储后面的数据库字段
            Field[] declaredFields = cl.getDeclaredFields();
            for (Field field : declaredFields) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations(); //获取字段上的所有注解实例
                if (anns.length < 1) {
                    continue; // Not a db table column
                }
                if (anns[0] instanceof SQLInteger) { //判断该注解实例是否是SQLInteger注解类型
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Use field name if name not specified
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // Use field name if name not specified.
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "("); //表语句
                for (String columnDef : columnDefs) {
                    createCommand.append("\n " + columnDef + ",");
                }
                // Remove trailing comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);

            } //for (Field field : cl.getDeclaredFields()) {

        }//for (String className : args) {


    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if(!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if(con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if(con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
