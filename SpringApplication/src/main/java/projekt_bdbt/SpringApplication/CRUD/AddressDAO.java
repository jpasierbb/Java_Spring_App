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
public class AddressDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AddressDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Address> list(){
        String sql = "SELECT * FROM ADRESY";

        List<Address> listAddress = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Address.class));
        return listAddress;
    }

    public void save(projekt_bdbt.SpringApplication.CRUD.Address addr) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADRESY").usingColumns("MIEJSCOWOSC","ULICA","NUMER_BUDYNKU","NUMER_LOKALU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(addr);

        insertActor.execute(param);
    }

    public projekt_bdbt.SpringApplication.CRUD.Address get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ADRESY WHERE ID_ADRESU = ?";
        Address addr = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Address.class));
        return addr;
    }

    public void update(projekt_bdbt.SpringApplication.CRUD.Address addr) {
        String sql = "UPDATE ADRESY SET MIEJSCOWOSC=:MIEJSCOWOSC, ULICA=:ULICA, NUMER_BUDYNKU=:NUMER_BUDYNKU, NUMER_LOKALU=:NUMER_LOKALU WHERE ID_ADRESU=:ID_ADRESU";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(addr);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ADRESY WHERE ID_ADRESU = ?";
        jdbcTemplate.update(sql, id);
    }
}