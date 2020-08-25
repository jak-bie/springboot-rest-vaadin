package com.jakbie.springbootrestvaadin.repo;

import com.jakbie.springbootrestvaadin.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query(value = "SELECT AUTHOR.NAME AS AuthorName, AUTHOR.SURNAME AS AuthorSurname, COUNT(AUTHOR.NAME) AS CategoryCount, BOOK.CATEGORY AS Category\n" +
            "FROM AUTHOR, BOOK\n" +
            "GROUP BY BOOK.CATEGORY", nativeQuery = true)
    List<AuthorDto> getCategoryCount();

}
