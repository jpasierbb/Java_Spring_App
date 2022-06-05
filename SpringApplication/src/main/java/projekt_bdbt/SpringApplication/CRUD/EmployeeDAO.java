package projekt_bdbt.SpringApplication.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Employee> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Employee> listEmployee = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return listEmployee;
    }

    /* Create – wstawianie nowego wiersza do bazy */
    public void save(projekt_bdbt.SpringApplication.CRUD.Employee emp) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRACOWNICY").usingColumns("IMIE", "DRUGIE_IMIE", "NAZWISKO", "PESEL", "PLEC","DATA_ZATRUDNIENIA","NUMER_TELEFONU","ID_ADRESU","ID_STANOWISKA");
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        emp.DATA_ZATRUDNIENIA = sqlDate.toString();
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(emp);

        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public projekt_bdbt.SpringApplication.CRUD.Employee get(int id) {
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        Object[] args = {id};
        Employee employee = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Employee.class));
        return employee;
    }

    /* Update – aktualizacja danych */
    public void update(projekt_bdbt.SpringApplication.CRUD.Employee sale) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }


}