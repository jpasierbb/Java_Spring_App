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
public class ClientJoinedDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClientJoinedDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ClientJoined> list(){
        String sql = "SELECT k.ID_KLIENTA, k.ID_Adresu, o.IMIE, o.NAZWISKO, o.PESEL, k.NUMER_TELEFONU, a.MIEJSCOWOSC, a.ULICA, a.NUMER_BUDYNKU, a.NUMER_LOKALU FROM KLIENCI k \n" +
                "INNER JOIN OSOBA_PRYWATNA o \n" +
                "ON k.ID_KLIENTA=o.ID_KLIENTA\n" +
                "INNER JOIN ADRESY a\n" +
                "on k.ID_Adresu = a.ID_Adresu";

        List<ClientJoined> listClientJoined = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ClientJoined.class));
        return listClientJoined;
    }
    public List<ClientJoined> getClientsByPage(int pageid, int total){
        String sql = "SELECT k.ID_KLIENTA, k.ID_Adresu, o.IMIE, o.NAZWISKO, o.PESEL, k.NUMER_TELEFONU, a.MIEJSCOWOSC, a.ULICA, a.NUMER_BUDYNKU, a.NUMER_LOKALU FROM KLIENCI k \n" +
                "INNER JOIN OSOBA_PRYWATNA o \n" +
                "ON k.ID_KLIENTA=o.ID_KLIENTA\n" +
                "INNER JOIN ADRESY a\n" +
                "on k.ID_Adresu = a.ID_Adresu" +" ORDER BY k.ID_KLIENTA " + "OFFSET "+(pageid-1)+" ROWS FETCH NEXT "+total+" ROWS ONLY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ClientJoined.class));
    }
    public int getSize(){
        String sql = "SELECT COUNT(*) FROM KLIENCI";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void save(ClientJoined pos, Contract cont) {
        String sql = "SELECT Max(ID_KLIENTA) FROM KLIENCI";
        int maxID = jdbcTemplate.queryForObject(sql, int.class);

        SimpleJdbcInsert insertActor4 = new SimpleJdbcInsert(jdbcTemplate);
        insertActor4.withTableName("ADRESY").usingColumns("MIEJSCOWOSC","ULICA","NUMER_BUDYNKU","NUMER_LOKALU");
        BeanPropertySqlParameterSource param4 = new BeanPropertySqlParameterSource(pos);
        insertActor4.execute(param4);

        String sqlAddr = "SELECT Max(ID_ADRESU) FROM ADRESY";
        int maxIDAdrr = jdbcTemplate.queryForObject(sqlAddr, int.class);
        pos.ID_ADRESU = maxIDAdrr;

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

    public ClientJoined get(int id) {
        Object[] args = {id};
        String sql = "SELECT k.ID_KLIENTA, k.ID_Adresu, o.IMIE, o.NAZWISKO, o.PESEL, k.NUMER_TELEFONU, a.MIEJSCOWOSC, a.ULICA, a.NUMER_BUDYNKU, a.NUMER_LOKALU FROM KLIENCI k \n" +
                "INNER JOIN OSOBA_PRYWATNA o \n" +
                "ON k.ID_KLIENTA=o.ID_KLIENTA\n" +
                "INNER JOIN ADRESY a\n" +
                "on k.ID_Adresu = a.ID_Adresu\n" +
                "WHERE k.ID_KLIENTA = ?";
        ClientJoined clientJoined = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(ClientJoined.class));
        return clientJoined;
    }

    public void update(ClientJoined clientJoined) {
        String sql3 = "UPDATE ADRESY SET MIEJSCOWOSC=:MIEJSCOWOSC, ULICA=:ULICA, NUMER_BUDYNKU=:NUMER_BUDYNKU, NUMER_LOKALU=:NUMER_LOKALU WHERE ID_ADRESU=:ID_ADRESU";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(clientJoined);
        NamedParameterJdbcTemplate template3 = new NamedParameterJdbcTemplate(jdbcTemplate);
        template3.update(sql3, param3);

        String sql = "UPDATE KLIENCI SET NUMER_TELEFONU=:NUMER_TELEFONU, ID_ADRESU=:ID_ADRESU WHERE ID_KLIENTA=:ID_KLIENTA";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(clientJoined);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);

        String sql2 = "UPDATE OSOBA_PRYWATNA SET IMIE=:IMIE, NAZWISKO=:NAZWISKO, PESEL=:PESEL WHERE ID_KLIENTA=:ID_KLIENTA";
        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(clientJoined);
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
