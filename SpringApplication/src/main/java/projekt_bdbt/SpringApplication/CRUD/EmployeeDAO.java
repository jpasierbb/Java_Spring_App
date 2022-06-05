package projekt_bdbt.SpringApplication.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */

    public List<projekt_bdbt.SpringApplication.CRUD.Employee> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<projekt_bdbt.SpringApplication.CRUD.Employee> listEmployee = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(projekt_bdbt.SpringApplication.CRUD.Employee.class));
        return listEmployee;
    }

    /* Create – wstawianie nowego wiersza do bazy */
    public void save(projekt_bdbt.SpringApplication.CRUD.Employee sale) {
    }

    /* Read – odczytywanie danych z bazy */
    public projekt_bdbt.SpringApplication.CRUD.Employee get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(projekt_bdbt.SpringApplication.CRUD.Employee sale) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }


}