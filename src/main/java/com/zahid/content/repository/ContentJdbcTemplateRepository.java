package com.zahid.content.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zahid.content.model.Content;
import com.zahid.content.model.ContentType;
import com.zahid.content.model.StatusType;

@Repository
@SuppressWarnings("all")
public class ContentJdbcTemplateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Content mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        UUID id = UUID.fromString(resultSet.getString("id"));
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        ContentType type = ContentType.valueOf(resultSet.getString("type"));
        StatusType status = StatusType.valueOf(resultSet.getString("status"));
        String url = resultSet.getString("url");
        Integer version = resultSet.getInt("version");
    
        Content content = new Content(title, description, type, status, url);
        content.setId(id); // set the ID field of the Content object
        content.setVersion(version);
    
        return content;
    }
    

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    public void createContent(String title, String description, ContentType type, StatusType status, String url) {
        String sql = "INSERT INTO content (title, description, type, status, created_at, url) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, description, type, status, url);
    }

    public void updateContent(UUID id, String title, String description, ContentType type, StatusType status,
            String url) {
        String sql = "UPDATE content SET title=?, description=?, type=?, status=?, updated_at=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, description, type, status, url, id);
    }

    public void deleteContent(UUID id) {
        String sql = "DELETE FROM content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content getContent(UUID id) {
        String sql = "SELECT * FROM content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[] { id }, ContentJdbcTemplateRepository::mapRow);
        return content;
    }
}
