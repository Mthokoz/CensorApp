package com.embedded.test.controller;

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
import com.embedded.test.repository.WordRepository;
import com.embedded.test.repository.WordRepository;
import com.embedded.test.util.Message;
import com.fasterxml.jackson.annotation.JacksonInject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



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
        String s = this.payloadMessage.prepareWords().toString();

        this.wordService = new WordService(this.payloadMessage.prepareWords(), wordRepository);

        
        return "Sent: "+s ;    
    }

    @RequestMapping(path = "/result" ,method=RequestMethod.GET)
    public String getWords() {
        String r = new String(this.wordService.censorWords().toString());
        
        return  "returns strings: "+r;
    }
    

}
