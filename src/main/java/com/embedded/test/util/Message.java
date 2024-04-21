package com.embedded.test.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.embedded.test.model.Word;



@Component("messageBean")
public class Message {
    private ArrayList<Word> messagePrepared;

    private String inputString;

    public Message(){
        messagePrepared = new ArrayList<>();
    }

    
    @Override
    public String toString() {
        return "Message [messagePrepared=" + messagePrepared + "]";
    }

    public String getInputSring() {
        return inputString;
    }


    public void setInputSring(String inputString) {
        this.inputString = inputString;
    }


    


    public ArrayList<Word> prepareWords(){
        String[] words = inputString.split(" ");
       
        for (String w: words){
            Word word = new Word();
            word.setWord(w.trim());
            messagePrepared.add(word);
        }

        return messagePrepared;
        
    }
}
