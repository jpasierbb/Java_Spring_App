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
public class PositionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PositionDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Position> list(){
        String sql = "SELECT * FROM STANOWISKA";

        List<Position> listPosition = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Position.class));
        return listPosition;
    }

    public void save(projekt_bdbt.SpringApplication.CRUD.Position pos) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("STANOWISKA").usingColumns("NAZWA","OPIS");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pos);

        insertActor.execute(param);
    }

    public projekt_bdbt.SpringApplication.CRUD.Position get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM STANOWISKA WHERE ID_STANOWISKA = ?";
        Position addr = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Position.class));
        return addr;
    }

    public void update(projekt_bdbt.SpringApplication.CRUD.Position pos) {
        String sql = "UPDATE STANOWISKA SET NAZWA=:NAZWA, OPIS=:OPIS WHERE ID_STANOWISKA=:ID_STANOWISKA";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pos);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM STANOWISKA WHERE ID_STANOWISKA = ?";
        jdbcTemplate.update(sql, id);
    }
}
