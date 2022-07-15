package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import static javax.xml.bind.JAXB.unmarshal;

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

//    Marshalling:Writing java objects into XML
    public static void marshal() throws JAXBException{
        Book book = new Book();
        book.setId(1L);
        book.setName("Learning everyday");
        book.setAuthor("Annalis");
        book.setDate(new Date());

        JAXBContext context = JAXBContext.newInstance(Book.class);
//        provides a client's entry point to JAXB API
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        To have JAXB format the output
        marshaller.marshal(book, new File("./book.xml"));
//        output file to store the generated XML as parameters.
    }
//    Unmarshalling: read book.xml back to java objects
public Book unmarshall() throws JAXBException, IOException {
    JAXBContext context = JAXBContext.newInstance(Book.class);
    return (Book) context.createUnmarshaller()
            .unmarshal(new FileReader("E:\\Graduate_program\\Basics\\demo\\book.xml"));
}

    @GetMapping("/marshall")
    public void returnMarshall() throws JAXBException {
        marshal();

    }
    @GetMapping(value = "/unmarshall", produces = "application/xml")
    public void returnUnMarshall() throws JAXBException, IOException {
        unmarshall();
    }
}
