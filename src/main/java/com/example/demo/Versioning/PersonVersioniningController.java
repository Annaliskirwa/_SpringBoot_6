package com.example.demo.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioniningController {
//    Versioning using basic uris: URI Versioning
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Annalis Kirwa");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }
    //Another versioning method using params:Request parameter versioning
    @GetMapping(value = "/person/param", params ="version=1" )
    public PersonV1 paramV1(){
        return new PersonV1("Annalis Kirwa");
    }
    @GetMapping(value = "/person/param",params ="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }
    //Header versioning
    @GetMapping(value = "/person/header", headers ="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Annalis Kirwa");
    }
    @GetMapping(value = "/person/header",headers ="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }

//    Versioning using producers: Accept header versioning/MIME TYPE VERSIONING
    @GetMapping(value = "/person/produces", produces ="application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
    return new PersonV1("Annalis Kirwa");
}
    @GetMapping(value = "/person/produces",produces ="application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Annalis","Kirwa"));
    }
}
