package com.embedded.test.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embedded.test.services.WordService;
import com.embedded.test.model.Word;
import com.embedded.test.repository.WordRepository;
import com.embedded.test.util.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;



@RestController
@Api(value = "Sensitive words censoring service", description = "CRUD operations and word censoring functionality")
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
    @ApiOperation(value = "Send a string to be processed and censored", response = String.class)
    public String postWords(@RequestParam String message) {
        this.payloadMessage = new Message();
        this.payloadMessage.setInputSring(message);
        ArrayList<Word> s = this.payloadMessage.prepareWords();

        this.wordService = new WordService(s, wordRepository);

        return "Sent: "+s.toString() ;    
    }

    @RequestMapping(path = "/result" ,method=RequestMethod.GET)
    @ApiOperation(value = "Fetch results of censored string", response = String.class)
    public String getWords() {
        String r = new String(this.wordService.censorWords().toString());
        
        return  "Response: "+r;
    }

    @RequestMapping(path ="/create/{word}", method=RequestMethod.POST)
    @ApiOperation(value = "Create and add new word into the table", response = String.class)
    public String requestCreateWord(@PathVariable String word) {
        return this.wordService.createWord(word);
    }

    @RequestMapping(path="update/{oldWord}/{newWord}", method=RequestMethod.PUT)
    @ApiOperation(value = "Update an already existing word with a new word", response=String.class)
    public String requestUpdateWord(@PathVariable String oldWord, @PathVariable String newWord) {
        String r = this.wordService.updateWord(oldWord, newWord);
        return r;
    }

    @RequestMapping(path="/delete/{word}", method=RequestMethod.DELETE)
    @ApiOperation(value = "Delete a word by its value", response = String.class)
    public String requestDeleteWord(@PathVariable String word) {
        return wordService.deleteWord(word);
    }

    @RequestMapping(path="word/{word}", method=RequestMethod.GET)
    @ApiOperation(value = "Get a word by its value", response = String.class)
    public String requestGetWord(@PathVariable String word) {
        if(this.wordService.getWord(word) != null)
            return this.wordService.getWord(word).getWord();
        return word+" Not found";
    }
    
    
    @RequestMapping(path ="words", method=RequestMethod.GET)
    @ApiOperation(value="List all the words in the database", response = Iterable.class)
    public String requestMethodName() {
        Iterable<Word> words = this.wordService.getAllWords();
        return words.toString();
    }
    
    
    

}
