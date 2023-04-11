package com.zahid.person.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zahid.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,UUID>, JpaSpecificationExecutor<Person> {
    @Query(value = "SELECT * FROM person p ORDER BY updated_at DESC", nativeQuery = true)
    List<Person> findAllEntities();

    @Query(value = "SELECT * FROM person p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name ,'%')) ", nativeQuery = true)
    List<Person> findAllByName(@Param("name") String name);
}
