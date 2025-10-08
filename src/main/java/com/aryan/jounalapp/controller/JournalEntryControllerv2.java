package com.aryan.jounalapp.controller;

import com.aryan.jounalapp.entity.JournalEntry;
import com.aryan.jounalapp.repository.JournalEntryRepository;
import com.aryan.jounalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") //means all controller use by this journal, but if we write @get mpping or other twice without declare it w'not work becuase end point same.
public class JournalEntryControllerv2 {


    @Autowired
    private JournalEntryService journalEntryService;


//API1
    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }


//API2
    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry) {  //@request body says like pls take the data from the request and and turn it into java object that i can use  in my code
        myEntry.setId(LocalDateTime.now());
        journalEntryService.saveEntry( myEntry );
        return true;

    }

    @GetMapping("id/{myid}")  //get specific id by url method
    public JournalEntry getEntryById(@PathVariable long myid) {
        return null;
    }

    @DeleteMapping("id/{myid}")      //get specific id by url method
    public JournalEntry deleteEntryById(@PathVariable long myid) {
        return null;
    }

    @PutMapping("id/{myid}")
    public JournalEntry updateJournalbyId(@PathVariable Long myid, @RequestBody JournalEntry myEntry) {
        return null;
    }
 }
