package com.emeraldo.journal.controllers;

import com.emeraldo.journal.models.JournalDTO;
import com.emeraldo.journal.repository.JournalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class JournalController {

    private final JournalRepository journalRepository;

    public JournalController(JournalRepository journalRepository){
        this.journalRepository = journalRepository;
    }

    @PostMapping("journals")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody JournalDTO journal){

       System.out.println("Received");
       System.out.println("" + journal.getTitle() + journal.getDescription());
        if (!journal.getTitle().isEmpty() && !journal.getDescription().isEmpty()) {
           this.journalRepository.save(journal);
        }

    }

    @GetMapping (value = "/journals")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Map<String, Object>> getJournals(){
        System.out.println("Found");
        return this.journalRepository.findAll();
    }

//    @GetMapping (value = "/journals/title")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Map<String, Object>> getJournal(@RequestBody String title){
//        System.out.println("Found");
//        this.journalRepository.findJournal(title);
//        return TODO;
//
//    }

    @PutMapping("/journals/{title}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody JournalDTO journal){
        System.out.println("Received");
        if (!journal.getTitle().isEmpty() && !journal.getDescription().isEmpty()) {
            this.journalRepository.updateJournal(journal);
        }
    }

    @DeleteMapping("/journals/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public void removeJournal(@PathVariable int id){
           this.journalRepository.deleteJournalById(id);
    }

}
