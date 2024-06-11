package com.nogo.EgarSchool.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "documents")
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "when_created")
    @CreationTimestamp
    private LocalDateTime whenCreated;
    @Column(name = "number")
    private Long number;
    @Column(name = "type")
    private String type;
    @Column(columnDefinition = "text", name = "content_of_doc")
    private String contentOfDoc;


//    public Document(String title, Long number, String type, String contentOfDoc) {
//        this.title = title;
//        this.number = number;
//        this.type = type;
//        this.contentOfDoc = contentOfDoc;
//    }
}
