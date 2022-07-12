package com.example.demo.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioniningController {
//    Versioning using basic uris
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Annalis Kirwa");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }
    //Another versioning method using params
    @GetMapping(value = "/person/param", params ="version=1" )
    public PersonV1 paramV1(){
        return new PersonV1("Annalis Kirwa");
    }
    @GetMapping(value = "/person/param",params ="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }
}
