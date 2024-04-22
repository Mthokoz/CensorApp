package com.embedded.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.embedded.test.model.Word;
import java.util.List;

// repository for accessing data
public interface WordRepository extends JpaRepository <Word , Integer> {
    @Query("SELECT w FROM Word w WHERE w.Word = :word")
    List<Word> findByWord(@Param("word") String wordString);

}
