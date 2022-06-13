package projekt_bdbt.SpringApplication.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ClientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> list(){
        String sql = "SELECT k.ID_KLIENTA, o.IMIE, o.NAZWISKO, o.PESEL, k.NUMER_TELEFONU, k.ID_ADRESU FROM KLIENCI k\n" +
                "INNER JOIN OSOBA_PRYWATNA o\n" +
                "ON k.ID_KLIENTA=o.ID_KLIENTA";

        List<Client> listClient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));
        return listClient;
    }

    public void save(Client pos, Contract cont) {
        String sql = "SELECT Max(ID_KLIENTA) FROM KLIENCI";
        int maxID = jdbcTemplate.queryForObject(sql, int.class);

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI").usingColumns("NUMER_TELEFONU","ID_ADRESU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pos);
        insertActor.execute(param);

        pos.ID_KLIENTA = maxID + 1;
        SimpleJdbcInsert insertActor2 = new SimpleJdbcInsert(jdbcTemplate);
        insertActor2.withTableName("OSOBA_PRYWATNA").usingColumns("ID_KLIENTA","IMIE","NAZWISKO", "PESEL");
        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(pos);
        insertActor2.execute(param2);

        cont.setID_KLIENTA(pos.ID_KLIENTA);
        SimpleJdbcInsert insertActor3 = new SimpleJdbcInsert(jdbcTemplate);
        insertActor3.withTableName("UMOWY").usingColumns("ID_USLUGI","DATA_ZAWARCIA","DATA_ZAKONCZENIA","ID_KLIENTA");
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(cont);
        insertActor3.execute(param3);

    }

    public Client get(int id) {
        Object[] args = {id};
        String sql = "SELECT k.ID_KLIENTA, o.IMIE, o.NAZWISKO, o.PESEL, k.NUMER_TELEFONU, k.ID_ADRESU FROM KLIENCI k\n" +
                "INNER JOIN OSOBA_PRYWATNA o\n" +
                "ON k.ID_KLIENTA=o.ID_KLIENTA WHERE k.ID_KLIENTA = ?";
        Client client = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Client.class));
        return client;
    }

    public void update(Client client) {
        String sql = "UPDATE KLIENCI SET NUMER_TELEFONU=:NUMER_TELEFONU, ID_ADRESU=:ID_ADRESU WHERE ID_KLIENTA=:ID_KLIENTA";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);

        String sql2 = "UPDATE OSOBA_PRYWATNA SET IMIE=:IMIE, NAZWISKO=:NAZWISKO, PESEL=:PESEL WHERE ID_KLIENTA=:ID_KLIENTA";
        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(client);
        NamedParameterJdbcTemplate template2 = new NamedParameterJdbcTemplate(jdbcTemplate);
        template2.update(sql2, param2);
    }

    public void delete(int id) {
        String sql2 = "DELETE FROM OSOBA_PRYWATNA WHERE ID_KLIENTA = ?";
        jdbcTemplate.update(sql2, id);


        String sql = "DELETE FROM KLIENCI WHERE ID_KLIENTA = ?";
        jdbcTemplate.update(sql, id);
    }
}
