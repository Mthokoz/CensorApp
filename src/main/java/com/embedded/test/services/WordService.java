package com.embedded.test.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.embedded.test.model.Word;
import com.embedded.test.repository.WordRepository;
@Service
public class WordService {
    private  ArrayList<Word> messageWords;

    private final WordRepository wordRepository;

    public WordService(ArrayList<Word> messageWords, WordRepository wordRepository){
        this.messageWords = messageWords;
        this.wordRepository = wordRepository;
    }

    public ArrayList<Word> censorWords(){
        for(Word w: messageWords){
            System.out.println("Query: "+ this.wordRepository.findByWord(w.getWord()));
            if(!this.wordRepository.findByWord(w.getWord()).isEmpty()){
                w.setWord(blopper(w.getWord()));
            }
           ;
        }

        return messageWords;
    }

    private String blopper(String word){
        StringBuilder asterik = new StringBuilder();
       for (int i = 0 ; i< word.length(); i++){
            asterik.append("*");
       }
        return asterik.toString();
    }

}
