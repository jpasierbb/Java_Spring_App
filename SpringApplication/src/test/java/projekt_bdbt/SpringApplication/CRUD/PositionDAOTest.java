package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PositionDAOTest extends Object {

    private PositionDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        datasource.setUsername("OPERATOR");
        datasource.setPassword("operator");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PositionDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Position> listPosition = dao.list();
        System.out.println(listPosition);
        assertTrue(!listPosition.isEmpty());
    }

    @Test
    void save() {
        Position pos = new Position(0,"wojownik","woj_mental");
        dao.save(pos);
    }

    @Test
    void get() {
        int id = 23;
        Position pos = dao.get(id);
        System.out.println(pos);

        assertNotNull(pos);
    }

    @Test
    void update() {
        Position pos = new Position();
        pos.setID_STANOWISKA(23);
        pos.setNAZWA("Wojownik Jinno");
        pos.setOPIS("woj mental albo body");

        dao.update(pos);
    }

    @Test
    void delete() {
        int id = 30;
        dao.delete(id);
    }
}