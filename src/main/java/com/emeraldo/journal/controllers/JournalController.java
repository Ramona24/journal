package com.emeraldo.journal.controllers;

import com.emeraldo.journal.models.JournalDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class JournalController {

    @PostMapping("journals")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody JournalDTO journal){

       System.out.println("Received");
       System.out.println("" + journal.getTitle() + journal.getDescription());
        if (!journal.getTitle().isEmpty() && !journal.getDescription().isEmpty()) {
            System.out.println("Saved");
        }
    }

}
