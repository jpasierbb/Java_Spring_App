package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AddressDAOTest extends Object {

    private AddressDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        datasource.setUsername("OPERATOR");
        datasource.setPassword("operator");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AddressDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Address> listAddress = dao.list();
        System.out.println(listAddress);
        assertTrue(!listAddress.isEmpty());
    }

    @Test
    void save() {
        Address addr = new Address(0,"Warszawa","Koniuszki","36","69");
        dao.save(addr);
    }

    @Test
    void get() {
        int id = 22;
        Address address = dao.get(id);
        System.out.println(address);

        assertNotNull(address);
    }

    @Test
    void update() {
        Address addr = new Address();
        addr.setID_ADRESU(22);
        addr.setMIEJSCOWOSC("Rzeszow");
        addr.setNUMER_BUDYNKU("22");
        addr.setULICA("Kwiatkowskiego");
        addr.setNUMER_LOKALU("3");

        dao.update(addr);
    }

    @Test
    void delete() {
        int id = 30;
        dao.delete(id);
    }
}