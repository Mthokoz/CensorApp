package com.embedded.test.services;

import java.util.ArrayList;
import java.util.List;

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
           
            if(!this.wordRepository.findByWord(w.getWord().toUpperCase()).isEmpty()){
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

    public String createWord(String word){
        if(this.wordRepository.findByWord(word.trim().toUpperCase()).isEmpty()){
            Word w = new Word();
            w.setWord(word.toUpperCase());
            w.setID((int)(this.wordRepository.count()+1));
             
            return this.wordRepository.save(w).getWord()+" is created";
        }
        else{
            return word+" already exist";
        }
    }

    public String deleteWord(String word){
        if(!this.wordRepository.findByWord(word.trim().toUpperCase()).isEmpty()){
            
            this.wordRepository.delete(this.wordRepository.findByWord(word.trim().toUpperCase()).get(0));
            return word+" has been deleted";
        }else{
            return word+" does not exist";
        }
    }

    public String updateWord(String oldWord, String newWord){
        Word wordToUpdate = this.wordRepository.findByWord(oldWord.trim().toUpperCase()).get(0);
        if(wordToUpdate != null){
            wordToUpdate.setWord(newWord.toUpperCase());
            return this.wordRepository.save(wordToUpdate).toString()+ " has be updated";
        }else{
            return oldWord+" does not exist";
        }
    }

    public Word getWord(String word){
        if(!this.wordRepository.findByWord(word.trim().toUpperCase()).isEmpty()){
            return this.wordRepository.findByWord(word.trim().toUpperCase()).get(0);
        }
        return null;
    } 

    public List<Word> getAllWords(){
        return this.wordRepository.findAll();
    }

}
