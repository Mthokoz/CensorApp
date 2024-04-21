package com.embedded.test.controller;

import java.util.ArrayList;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embedded.test.services.WordService;
import com.embedded.test.model.Word;
import com.embedded.test.repository.WordRepository;
import com.embedded.test.repository.WordRepository;
import com.embedded.test.util.Message;
import com.fasterxml.jackson.annotation.JacksonInject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController

public class WordController {

    
    private WordService wordService;
    private WordRepository wordRepository;
    private Message payloadMessage;

    
    public WordController( WordRepository wordRepository,  WordService wordService, Message payloadMessage){
        this.wordRepository = wordRepository;
        this.wordService = wordService;
        this.payloadMessage = payloadMessage;

    }
    
    @RequestMapping(path = "/censor" ,method=RequestMethod.POST)
    public String postWords(@RequestParam String message) {
        this.payloadMessage = new Message();
        this.payloadMessage.setInputSring(message);
        ArrayList<Word> s = this.payloadMessage.prepareWords();

        this.wordService = new WordService(s, wordRepository);

        
        return "Sent: "+s.toString() ;    
    }

    @RequestMapping(path = "/result" ,method=RequestMethod.GET)
    public String getWords() {
        String r = new String(this.wordService.censorWords().toString());
        
        return  "Response: "+r;
    }

    @RequestMapping(path ="/create/{newWord}", method=RequestMethod.POST)
    public String requestCreateWord(@RequestParam String word) {
        return this.wordService.createWord(word);
    }

    @RequestMapping(path="/{oldWord}/{newWord}", method=RequestMethod.PUT)
    public String requestUpdateWord(@PathVariable String oldWord, @PathVariable String newWord) {
        String r = this.wordService.updateWord(oldWord, newWord);
        return r;
    }

    @RequestMapping(path="/delete/{word}", method=RequestMethod.DELETE)
    public String requestDeleteWord(@RequestParam String param) {
        return wordService.deleteWord(param);
    }

    @RequestMapping(path="word/{word}", method=RequestMethod.GET)
    public String requestGetWord(@RequestParam String word) {
        if(this.wordService.getWord(word) != null)
            return this.wordService.getWord(word).getWord();
        return word+" Not found";
    }
    
    
    @RequestMapping(path ="all", method=RequestMethod.GET)
    public String requestMethodName() {
        Iterable<Word> words = this.wordService.getAllWords()
        return words.toString();
    }
    
    
    

}
