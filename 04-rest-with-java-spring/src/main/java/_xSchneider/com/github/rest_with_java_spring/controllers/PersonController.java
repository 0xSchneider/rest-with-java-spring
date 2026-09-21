package _xSchneider.com.github.rest_with_java_spring.controllers;

import _xSchneider.com.github.rest_with_java_spring.Services.PersonServices;
import _xSchneider.com.github.rest_with_java_spring.dataDTO.PersonDTO;
import _xSchneider.com.github.rest_with_java_spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);

    }
    
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDTO> findAll() {
        return service.findAll();
    }


    @PostMapping(
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @DeleteMapping(value = "/{id}"
    )
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }
}
