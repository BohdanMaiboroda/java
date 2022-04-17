package Helpers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Creater {
    public static SimpleDriverDataSource createDataSource()
    {
        Properties props = Creater.getLoadedProperties();
        System.out.println(props);
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //было Class.forName("org.sqlite.JDBC");//ШАГ 1
        //стало
        dataSource.setDriverClass(org.sqlite.JDBC.class);
        // String dbFile = "C:\\MyData\\test.db";
        String dbFile = props.getProperty("sql.dbpath");
        dataSource.setUrl("jdbc:sqlite:" + dbFile);
        /*
        String connTxt = "jdbc:sqlite:C:\\MyData\\test.db";
            conn = DriverManager.getConnection(connTxt);
         */
        // dataSource.setUsername(); //имя пользователя в кодировке EN (Utf8)
        // dataSource.setPassword(); //имя пользователя в кодировке EN
        return dataSource;
    }

    protected static Properties getLoadedProperties()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("file:src/main/resources/db.properties");
        Properties prop = new Properties();
        //
        String path = "";
        try {
            path = resource.getFile().getPath();
            prop.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        return prop;
    }

}
