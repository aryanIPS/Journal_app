package com.aryan.jounalapp.entity;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
//controller-->Service-->repo
@Data
@Document              //This map below collection in mongo
public class JournalEntry {

    @Id             //This use as a primary key
    private ObjectId id;
    private String name;
    private String content;
    private LocalDateTime date;





}
