package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Proposal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProposalRepositorySQL implements ProposalRepository{
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProposalRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createProposal(Proposal proposal){
        String sql = "INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking)" +
                " VALUES (:point_proposal, :date_proposal, :ranking)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("pointProposal", proposal.getPointProposal());
        map.addValue("dateProposal", proposal.getDateProposal());
        map.addValue("ranking", proposal.getRanking());
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Proposal> readAll(){
        String sql = "SELECT * FROM PROPOSAL";
        List<Proposal> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Proposal.class));
        return list;
    }

    @Override
    public Proposal readById(long id){
        String sql = "SELECT * FROM PROPOSAL WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        Proposal proposal = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Proposal.class));
        return proposal;
    }

    @Override
    public void updateProposal(){
        String sql = "UPDATE PROPOSAL SET pointProposal=:pointProposal, dateProposal=:dateProposal, ranking=:ranking";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(Proposal.class);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProposal(long id){
        String sql = "DELETE FROM PROPOSAL WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, map);
    }


}
