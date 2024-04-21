package com.embedded.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORDS")
public class Word {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name="WORD")
    private String Word;

    @Override
    public String toString() {
        return "Word [Word=" + Word + "]";
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }


    
}
