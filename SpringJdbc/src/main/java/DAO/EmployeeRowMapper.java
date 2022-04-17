package DAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
        return new Employee(rs.getString("NAME"),
                rs.getInt("AGE"),
                rs.getFloat("SALARY"));
    }
}
