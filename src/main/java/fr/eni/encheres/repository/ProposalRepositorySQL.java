package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.repository.rowMapper.ProposalByUserRowMapper;
import fr.eni.encheres.repository.rowMapper.ProposalRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)" +
                " VALUES (:point_proposal, :date_proposal, :ranking, :id_buyer, :id_article)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("pointProposal", proposal.getPointProposal());
        map.addValue("dateProposal", proposal.getDateProposal());
        map.addValue("ranking", proposal.getRanking());
        map.addValue("idBuyer", proposal.getBuyer());
        map.addValue("idArticle", proposal.getArticle());

        namedParameterJdbcTemplate.update(sql, map, keyHolder);
        long id = keyHolder.getKey().longValue();
        proposal.setIdProposal(id);
    }

    @Override
    public List<Proposal> readAll(){
        String sql = "SELECT * FROM PROPOSAL";
        List<Proposal> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Proposal.class));
        return list;
    }

    @Override
    public List<Proposal> readFullAll() {
        String sql = """
                SELECT p.id_proposal, p.point_proposal, p.date_proposal, p.ranking,
                       a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status, 
                       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
                       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller
                FROM PROPOSAL p
                LEFT JOIN ARTICLE a ON a.id_article = p.id_article
                LEFT JOIN [USER] ub ON ub.id_user = p.id_buyer
                LEFT JOIN [USER] us ON us.id_user = a.id_seller
            """;
        return jdbcTemplate.query(sql, new ProposalRowMapper());
    }

    @Override
    public Proposal readById(long id){
        String sql = "SELECT * FROM PROPOSAL WHERE id_proposal=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        Proposal proposal = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Proposal.class));
        return proposal;
    }

    @Override
    public void updateProposal(Proposal proposal){
        String sql = "UPDATE PROPOSAL SET point_proposal=:pointProposal, date_proposal=:dateProposal, ranking=:ranking WHERE id_proposal=:idProposal";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(Proposal.class);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProposal(long id){
        String sql = "DELETE FROM PROPOSAL WHERE id_proposal=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, map);
    }


    // Récupère la liste des propositions pour des ventes EN COURS selon l'ID user

    @Override
    public List<Proposal> readProposalECByIdUser(long id){

        String sql = "SELECT PROPOSAL.id_article, PROPOSAL.id_buyer, " +
                "       MIN(ranking) AS ranking, MAX(point_proposal) AS point_proposal, " +
                "       article.name, article.final_point, article.beginning_date, " +
                "       article.ending_date " +
                " FROM PROPOSAL " +
                " LEFT JOIN ARTICLE on PROPOSAL.id_article = ARTICLE.id_article " +
                " WHERE PROPOSAL.id_buyer=:id AND ARTICLE.status='EC' " +
                " GROUP BY PROPOSAL.id_article, PROPOSAL.id_buyer, " +
                "         article.name, article.final_point, article.ending_date, " +
                "         article.beginning_date " +
                " ORDER BY article.ending_date ";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, map, new ProposalByUserRowMapper());
    }

    // Récupère la liste des propositions pour des ventes TERMINÉES selon l'ID user

    @Override
    public List<Proposal> readProposalVDLVByIdUser(long id) {

        String sql = "SELECT PROPOSAL.id_article, PROPOSAL.id_buyer, " +
                "       MIN(ranking) AS ranking, MAX(point_proposal) AS point_proposal, " +
                "       article.name, article.final_point, article.beginning_date, " +
                "       article.ending_date " +
                " FROM PROPOSAL " +
                " LEFT JOIN ARTICLE on PROPOSAL.id_article = ARTICLE.id_article " +
                " WHERE PROPOSAL.id_buyer=:id AND (ARTICLE.status='VD' OR ARTICLE.status='LV') " +
                " GROUP BY PROPOSAL.id_article, PROPOSAL.id_buyer, " +
                "         article.name, article.final_point, article.ending_date, " +
                "         article.beginning_date " +
                "         ORDER BY article.ending_date DESC ";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, map, new ProposalByUserRowMapper());
    }

}