package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement(name = "book")
//The name of the root XML element is derived from the class name
@XmlType(propOrder = {"id","name","date"})
//the order in which the fields are written in the XML file
public class Book {
    private Long id;
    private String name;
    private String author;
    private Date date;

    @XmlAttribute
//    the id field is mapped as an attribute instead of an element
    public void setId(Long id){
        this.id = id;
    }
    @XmlElement(name = "title")
//    the actual XML element name that will be used
    public void setName(String name){
        this.name = name;
    }
    @XmlTransient
//    annotate fields that we don't want to be included in XML
    public void setAuthor(String author){
        this.author = author;
    }
    public void marshal() {
        Book book = new Book();
        book.setId(1L);
        book.setName("Learning everyday");
        book.setAuthor("Annalis");
        book.setDate(new Date());
    }
}
