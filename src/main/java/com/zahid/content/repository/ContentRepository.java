package com.zahid.content.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zahid.content.model.Content;

public interface ContentRepository extends JpaRepository<Content,UUID> {
    @Query(value = "SELECT * FROM content c ORDER BY updated_at DESC", nativeQuery = true)
    List<Content> findAllEntities();

    @Query(value = """
            SELECT * 
            FROM content c 
            WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :title ,'%'))
        """, 
        nativeQuery = true)
    List<Content> findAllByTitle(@Param("title") String title);

    // List<Content> findAllByTitleContains(String keyword);
 }
