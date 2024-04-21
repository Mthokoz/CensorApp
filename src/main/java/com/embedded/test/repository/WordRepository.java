package com.embedded.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embedded.test.model.Word;
// repository for accessing data
public interface WordRepository extends JpaRepository <Word , Integer> {

    
}
