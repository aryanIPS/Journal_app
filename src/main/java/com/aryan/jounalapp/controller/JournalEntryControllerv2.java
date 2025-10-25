package com.aryan.jounalapp.controller;

import com.aryan.jounalapp.entity.JournalEntry;
import com.aryan.jounalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {  //@request body says like pls take the data from the request and and turn it into java object that i can use  in my code
      try {
          myEntry.setDate(LocalDateTime.now());
          journalEntryService.saveEntry( myEntry );
          return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
      }
      catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("id/{myid}")  //get specific id by url method
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myid) {
         Optional<JournalEntry> JournalEntry = journalEntryService.findById(myid);
         if(JournalEntry.isPresent()) {
             return new ResponseEntity<>(JournalEntry.get(), HttpStatus.OK);
         }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myid}")      //get specific id by url method
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myid) {
        journalEntryService.deleteById(myid);
        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myid}")
    public ResponseEntity<?> updateJournalbyId(@PathVariable ObjectId myid, @RequestBody JournalEntry newEntry) {
//        myEntry.setDate(LocalDateTime.now());
        JournalEntry old = journalEntryService.findById(myid).orElse(null);
        if(old != null){
            old.setContent(newEntry.getContent() !=null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            old.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : old.getName());
            journalEntryService.saveEntry( old );
            return   new ResponseEntity<>( HttpStatus.OK);
        }
        return  new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
 }
