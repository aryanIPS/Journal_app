package com.aryan.jounalapp.repository;
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.bson.types.ObjectId;
import com.aryan.jounalapp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//POJO-----> Plain old java object
//ORM--> object relational mapping

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}