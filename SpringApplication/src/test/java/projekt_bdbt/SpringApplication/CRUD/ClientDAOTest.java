package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest extends Object {

    private ClientDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:bdbt");
        datasource.setUsername("ANDRZEJ");
        datasource.setPassword("bdbt");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new ClientDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Client> listClient = dao.list();
        System.out.println(listClient);
        int index = listClient.size();
        int maxID = listClient.get(index-1).getID_KLIENTA() + 1;
        System.out.println(maxID);

        assertTrue(!listClient.isEmpty());
    }

    @Test
    void save() {
        Client client = new Client(0,"Jan", "Januszek", "09876543212", "098765432",1);
        dao.save(client);
    }

    @Test
    void get() {
        int id = 2;
        Client client = dao.get(id);
        System.out.println(client);

        assertNotNull(client);
    }

    @Test
    void update() {
        Client client = new Client();
        client.setID_KLIENTA(17);
        client.setID_ADRESU(21);
        client.setNUMER_TELEFONU("147852369");
        client.setIMIE("Tomek");
        client.setNAZWISKO("Bonk");
        client.setPESEL("12365478999");

        dao.update(client);
    }

    @Test
    void delete() {
        int id = 18;
        dao.delete(id);
    }
}