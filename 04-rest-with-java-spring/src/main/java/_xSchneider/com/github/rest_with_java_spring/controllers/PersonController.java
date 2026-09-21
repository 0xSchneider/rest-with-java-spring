package _xSchneider.com.github.rest_with_java_spring.controllers;

import _xSchneider.com.github.rest_with_java_spring.Services.PersonServices;
import _xSchneider.com.github.rest_with_java_spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);

    }


    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll() {
        return service.findAll();
    }


    @RequestMapping(
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable String id){

    service.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }
}
