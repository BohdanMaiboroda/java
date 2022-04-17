//jdbc - general
// import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//spring for jdbc
import DAO.Employee;
import Helpers.Creater;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

//Spring
//Источнки данных - DataSource
//SimpleDriverDataSource - для всех
//желательно использовать реализацию DataSource для конкретной СУБД
//OracleDataSource, MySQLDataSource
//Источник результатов выполнения запросов = JdbcTemplate
//Обертка для конструктора запросов из имене столбцов
/*При архитектуре DAO используют SqlParametrSource, MapParametr, MapColumn */
/*Hibernate - это использует внутри*/



public class SpringJdbc {
    public static void main(String[] args)
    {
        SimpleDriverDataSource dataSource = Creater.createDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Hello from getFilteredByName");
        List<Employee> results = Employee.getFilteredByName(jdbcTemplate);
        results.forEach( e -> System.out.println(e));
        System.out.println("Hello from getAll");
        List<Employee> employees = Employee.getAll(jdbcTemplate);
        employees.forEach( e -> System.out.println(e));
        System.out.println("Hello from getSalaryGreaterThen");
        List<Employee> empls = Employee.getSalaryGreaterThen(jdbcTemplate, 1000);
        empls.forEach( e -> System.out.println(e));

        //ДЗ:
        //Все методы для выборки данных с фильтрацией должны значения
        //для фильтра в параметре

        //+Синтаксис передачи параметра в запрос
        //+введение шаблона DAO (Data Access Objects (Layer))
        //+ использование именных параметров в запросе
        //задание и заполнение именных параметров в момент вызова метода
        //+работа с файлами свойств (хранилищами настроек соединения)

    }
}
