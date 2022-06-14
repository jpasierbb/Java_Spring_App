package projekt_bdbt.SpringApplication.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ContractDAOTest extends Object {

    private ContractDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        datasource.setUsername("OPERATOR");
        datasource.setPassword("operator");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new ContractDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Contract> listContract = dao.list();
        System.out.println(listContract);
        int index = listContract.size();
        int maxID = listContract.get(index-1).getID_KLIENTA() + 1;
        System.out.println(maxID);

        assertTrue(!listContract.isEmpty());
    }

    @Test
    void save() {
        Contract contract = new Contract(0,3,"22-01-01","22-10-10",16);
        dao.save(contract);
    }

    @Test
    void get() {
        int id = 3;
        Contract contract = dao.get(id);
        System.out.println(contract);

        assertNotNull(contract);
    }

    @Test
    void getContracts(){
        int id = 6;
        List<Contract> emp = dao.getContracts(id);
        System.out.println(emp);

        assertNotNull(emp);
    }

    @Test
    void update() {
        Contract contract = new Contract();
        contract.setID_UMOWY(5);
        contract.setID_USLUGI(1);
        contract.setDATA_ZAWARCIA("16-16-16");
        contract.setDATA_ZAKONCZENIA("20-12-20");
        contract.setID_KLIENTA(6);

        dao.update(contract);
    }

    @Test
    void delete() {
        int id = 6;
        dao.delete(id);
    }
}