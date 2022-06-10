package projekt_bdbt.SpringApplication.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeJoinedDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeeJoinedDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EmployeeJoined> list(){
        String sql = "SELECT p.*, s.*, a.* FROM PRACOWNICY p\n" +
                "INNER JOIN STANOWISKA s\n" +
                "ON p.ID_STANOWISKA = s.ID_STANOWISKA\n" +
                "INNER JOIN ADRESY a\n" +
                "ON p.ID_ADRESU = a.ID_ADRESU";

        List<EmployeeJoined> listEmployeeJoined = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeeJoined.class));
        return listEmployeeJoined;
    }

    public void save(EmployeeJoined pos) {
        SimpleJdbcInsert insertActor2 = new SimpleJdbcInsert(jdbcTemplate);
        insertActor2.withTableName("ADRESY").usingColumns("MIEJSCOWOSC","ULICA","NUMER_BUDYNKU","NUMER_LOKALU");
        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(pos);
        insertActor2.execute(param2);

        String sqlAddr = "SELECT Max(ID_ADRESU) FROM ADRESY";
        int maxIDAdrr = jdbcTemplate.queryForObject(sqlAddr, int.class);
        pos.ID_ADRESU = maxIDAdrr;


        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRACOWNICY").usingColumns("IMIE", "DRUGIE_IMIE", "NAZWISKO", "PESEL", "PLEC","DATA_ZATRUDNIENIA","NUMER_TELEFONU","ID_ADRESU","ID_STANOWISKA");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pos);
        insertActor.execute(param);

    }

    public EmployeeJoined get(int id) {
        Object[] args = {id};
        String sql = "SELECT p.*, s.*, a.* FROM PRACOWNICY p\n" +
                "INNER JOIN STANOWISKA s\n" +
                "ON p.ID_STANOWISKA = s.ID_STANOWISKA\n" +
                "INNER JOIN ADRESY a\n" +
                "ON p.ID_ADRESU = a.ID_ADRESU WHERE P.ID_PRACOWNIKA = ?";
        EmployeeJoined employee = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(EmployeeJoined.class));
        return employee;
    }

    public void update(EmployeeJoined emp) {
        String sql2 = "UPDATE ADRESY SET MIEJSCOWOSC=:MIEJSCOWOSC, ULICA=:ULICA, NUMER_BUDYNKU=:NUMER_BUDYNKU, NUMER_LOKALU=:NUMER_LOKALU WHERE ID_ADRESU=:ID_ADRESU";
        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(emp);
        NamedParameterJdbcTemplate template2 = new NamedParameterJdbcTemplate(jdbcTemplate);
        template2.update(sql2, param2);

        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        emp.DATA_ZATRUDNIENIA = sqlDate.toString();
        String sql = "UPDATE PRACOWNICY SET IMIE=:IMIE, DRUGIE_IMIE=:DRUGIE_IMIE, NAZWISKO=:NAZWISKO, PESEL=:PESEL, PLEC=:PLEC, DATA_ZATRUDNIENIA=:DATA_ZATRUDNIENIA, NUMER_TELEFONU=:NUMER_TELEFONU, ID_ADRESU=:ID_ADRESU, ID_STANOWISKA=:ID_STANOWISKA WHERE ID_PRACOWNIKA=:ID_PRACOWNIKA";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(emp);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);

    }

    public void delete(int id) {
        String sql2 = "DELETE FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        jdbcTemplate.update(sql2, id);
    }
}
