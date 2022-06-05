package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest extends Object {

    private EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        datasource.setUsername("OPERATOR");
        datasource.setPassword("operator");
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
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        Employee emp = new Employee(0,"Jakub","Jacek","Grabowski","09876512341","M", sqlDate.toString(),"567908123",21,21);
        dao.save(emp);
    }

    @Test
    void get() {
        int id = 27;
        Employee employee = dao.get(id);
        System.out.println(employee);

        assertNotNull(employee);
    }

    @Test
    void update() {
        Employee emp = new Employee();
        emp.setID_PRACOWNIKA(29);
        emp.setNUMER_TELEFONU("420692137");
        emp.setID_ADRESU(22);
        emp.setID_STANOWISKA(22);

        dao.update(emp);
    }

    @Test
    void delete() {
        int id = 30;
        dao.delete(id);
    }
}