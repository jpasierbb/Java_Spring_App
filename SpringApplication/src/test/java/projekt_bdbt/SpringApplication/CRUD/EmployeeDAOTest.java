package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest extends Object {

    private EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:bdbt");
        datasource.setUsername("ANDRZEJ");
        datasource.setPassword("bdbt");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new EmployeeDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Employee> listEmployee = dao.list();
        System.out.println(listEmployee);
        assertTrue(!listEmployee.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}