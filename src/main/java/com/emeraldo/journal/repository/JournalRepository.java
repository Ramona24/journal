package com.emeraldo.journal.repository;

import com.emeraldo.journal.models.JournalDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("JournalRepository")
public class JournalRepository {
    private final JdbcTemplate jdbcTemplate;

    public JournalRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(JournalDTO journalDTO){
        String insertQuery = "INSERT INTO journal(title, description) values (?, ?)";
        jdbcTemplate.update(insertQuery,journalDTO.getTitle(), journalDTO.getDescription() );
        System.out.println("Saved");
    }

    public final List<Map<String, Object>> findAll(){
        String searchQuery = "SELECT * FROM journal";
        List<Map<String, Object>> allJournals = jdbcTemplate.queryForList(searchQuery);
        System.out.println("Found");
        return allJournals;
    }

//    public void findJournal(String title) {
//        String searchQuery = "SELECT * FROM journal WHERE title = ?";
//        Object journal  = jdbcTemplate.queryForObject(
//                searchQuery, new String[]{title}, new BeanPropertyRowMapper(JournalDTO.class));
//        //return null;
//    }

    public void updateJournal(JournalDTO journal){
        String sql = "Update journal set description = ? where title = ?";
        jdbcTemplate.update(sql, journal.getDescription(), journal.getTitle());
        System.out.println("Updated");
    }

    public void deleteJournalById(Integer id){
        String sql = "DELETE FROM journal where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Deleted");
    }

}
