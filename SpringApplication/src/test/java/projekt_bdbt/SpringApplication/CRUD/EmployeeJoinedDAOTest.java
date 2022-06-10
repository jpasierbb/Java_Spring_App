package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeJoinedDAOTest extends Object {

    private EmployeeJoinedDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        datasource.setUsername("OPERATOR");
        datasource.setPassword("operator");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new EmployeeJoinedDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<EmployeeJoined> listEmployeeJoined = dao.list();
        System.out.println(listEmployeeJoined);

        assertTrue(!listEmployeeJoined.isEmpty());
    }

    @Test
    void save() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        EmployeeJoined emp = new EmployeeJoined(1,23,1,"Jakub","Jacek","Grabowski","09876512341","M", sqlDate.toString(),"567908123", "Rzeszow", "Akacjowa", "30", "");
        dao.save(emp);
    }

    @Test
    void get() {
        int id = 31;
        EmployeeJoined emp = dao.get(id);
        System.out.println(emp);

        assertNotNull(emp);
    }

    @Test
    void update() {
        EmployeeJoined emp = new EmployeeJoined();
        emp.setID_PRACOWNIKA(61);
        emp.setIMIE("Monika");
        emp.setDRUGIE_IMIE("");
        emp.setNAZWISKO("Dang");
        emp.setPESEL("25896314702");
        emp.setPLEC("K");
        emp.setDATA_ZATRUDNIENIA("06-06-2022");
        emp.setNUMER_TELEFONU("420692137");
        emp.setID_ADRESU(41);
        emp.setID_STANOWISKA(22);
        emp.setMIEJSCOWOSC("Rzeszow");
        emp.setNUMER_BUDYNKU("22");
        emp.setULICA("Kwiatkowskiego");
        emp.setNUMER_LOKALU("3");

        dao.update(emp);
    }

    @Test
    void delete() {
        int id = 31;
        dao.delete(id);
    }
}