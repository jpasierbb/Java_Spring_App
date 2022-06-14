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
public class ContractDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ContractDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Contract> list(){
        String sql = "SELECT k.ID_UMOWY, k.ID_USLUGI, o.TYP_USLUGI, k.DATA_ZAWARCIA, k.DATA_ZAKONCZENIA, k.ID_KLIENTA FROM UMOWY k\n" +
                "INNER JOIN USLUGI o\n" +
                "ON k.ID_USLUGI=o.ID_USLUGI";

        List<Contract> listContract = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contract.class));
        return listContract;
    }

    public List<Contract> getContractsByPage(int pageid, int total){
        String sql = "SELECT k.ID_UMOWY, k.ID_USLUGI, o.TYP_USLUGI, k.DATA_ZAWARCIA, k.DATA_ZAKONCZENIA, k.ID_KLIENTA FROM UMOWY k\n" +
                "INNER JOIN USLUGI o\n" +
                "ON k.ID_USLUGI=o.ID_USLUGI\n" +
                "ORDER BY ID_UMOWY OFFSET\n" +
                (pageid-1)+" ROWS FETCH NEXT "+total+" ROWS ONLY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contract.class));
    }
    public int getSize(){
        String sql = "SELECT COUNT(*) FROM UMOWY";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    public void save(Contract contract) {
        String sql = "SELECT Max(ID_KLIENTA) FROM KLIENCI";
        int maxID = jdbcTemplate.queryForObject(sql, int.class);
        //contract.ID_KLIENTA = maxID + 1;

        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date sqlDate2 = new java.sql.Date(System.currentTimeMillis());
        contract.DATA_ZAWARCIA = sqlDate.toString();
        contract.DATA_ZAKONCZENIA = sqlDate2.toString();

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("UMOWY").usingColumns("ID_USLUGI","DATA_ZAWARCIA","DATA_ZAKONCZENIA","ID_KLIENTA");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(contract);
        insertActor.execute(param);
    }

    public Contract get(int id) {
        //Object[] args = {id};
        String sql = "SELECT k.ID_UMOWY, k.ID_USLUGI, o.TYP_USLUGI, k.DATA_ZAWARCIA, k.DATA_ZAKONCZENIA, k.ID_KLIENTA FROM UMOWY k\n" +
                "INNER JOIN USLUGI o\n" +
                "ON k.ID_USLUGI=o.ID_USLUGI WHERE k.ID_UMOWY = " + id;
        Contract contract = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Contract.class));
        return contract;
    }

    public List<Contract> getContracts(int id){
        Object[] args = {id};
        String sql = "SELECT u.ID_UMOWY,s.TYP_USLUGI, u.DATA_ZAWARCIA, u.DATA_ZAKONCZENIA FROM KLIENCI k\n" +
                "INNER JOIN UMOWY u\n" +
                "ON k.ID_KLIENTA=u.ID_KLIENTA\n" +
                "INNER JOIN USLUGI s\n" +
                "ON s.ID_USLUGI=u.ID_USLUGI\n" +
                "WHERE k.ID_KLIENTA = " + id;

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contract.class));
    }

    public void update(Contract contract) {


        String sql = "UPDATE UMOWY SET ID_USLUGI=:ID_USLUGI, DATA_ZAWARCIA=:DATA_ZAWARCIA, DATA_ZAKONCZENIA=:DATA_ZAKONCZENIA, ID_KLIENTA=:ID_KLIENTA WHERE ID_UMOWY=:ID_UMOWY";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(contract);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM UMOWY WHERE ID_UMOWY = ?";
        jdbcTemplate.update(sql, id);
    }
}
