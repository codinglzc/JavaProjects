package annotation.ASimpleDB;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 它将读取一个类文件，检查其上的数据库注解，并生成用来创建数据库的SQL命令。
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
public class TableCreator
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        String[] clss = {"ASimpleDB.Member"};
        for (String className : clss)
        {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null)
            {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.length() < 1)
                tableName = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields())
            {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) continue; // Not a db table column
                if (anns[0] instanceof SQLInteger)
                {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Use field name if name not specified
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString)
                {
                    SQLString sStr = (SQLString) anns[0];
                    // Use field name if name not specified
                    if (sStr.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sStr.name();
                    columnDefs.add(columnName + " VARCHAR(" + sStr.value() + ")" + getConstraints(sStr.constraints()));
                }
                StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs)
                    sb.append("\n   " + columnDef + ",");
                // Remove trailing comma
                String tableCreate = sb.substring(0, sb.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constrains con)
    {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
