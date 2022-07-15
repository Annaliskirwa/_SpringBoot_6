package com.example.demo.Entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"id","name","date"})
public class Book {
    private Long id;
    private String name;
    private String author;
    private Date date;
}
