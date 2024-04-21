package com.embedded.test.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.embedded.test.model.Word;
import com.embedded.test.repository.WordRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final WordRepository wordRepository;

    public AppStartupEvent(WordRepository wordRepository){
        this.wordRepository =wordRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // TODO Auto-generated method stub
        //Printring all words
        Iterable<Word> words = this.wordRepository.findAll();
        words.forEach(System.out::println);
        System.out.println("Done printing");
    }
    
}
