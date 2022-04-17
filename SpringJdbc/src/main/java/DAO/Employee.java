package DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Employee {
    //тексты запросов
    public static final String fullSelect = "SELECT NAME, AGE, SALARY FROM EMPLOYEES";
    public static final String salaryFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE SALARY > :salary";// слово :salay - именованый параметр
    //который заполяется значением из перемменной правильного типа (соответствующего столбцу SALARY)
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME like \'?%\'";//символ ? - это параметр
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME = ?";
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME LIKE '?%'";//ошибка в одинарных кавычках
    public static final String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME LIKE ?";
    //методы получения сотрудников

    public static List<Employee> getAll(JdbcTemplate jdbcTemplate)
    {
        List<Employee> results = jdbcTemplate.
                query(Employee.fullSelect, //текст запрос
                        new EmployeeRowMapper()
                );
        return results;
    }
    public static List<Employee> getFilteredByName(JdbcTemplate jdbcTemplate)
    {

        List<Employee> results = jdbcTemplate.
                query(Employee.nameFilter, //текст запрос
                        new Object[]{"I%"}  , //массив параметров для запроса, если они нужны

                        new EmployeeRowMapper()

                );
        return results;
    }
    //
    public static List<Employee> getSalaryGreaterThen(JdbcTemplate jdbcTemplate, double salary )
    {
        SqlParameterSource params = new MapSqlParameterSource().addValue("salary",salary);
        List<Employee> results = jdbcTemplate.
                query(Employee.salaryFilter, //текст запрос
                        // params,
                        // new SqlParameterSource[]{params},
                        new Object[]{salary}  ,
                        new EmployeeRowMapper()
                );
        return results;
    }
    //описание таблицы в базе данных
    //количество столбцов их названия - все определяет таблица
    //сам класс Employee - описывает одну строку в таблице Employees
    public float salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String name;
    public int age;
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Employee() {
    }
    public Employee(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "DAO.Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
