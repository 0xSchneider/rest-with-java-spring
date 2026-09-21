package _xSchneider.com.github.rest_with_java_spring.Services;

import _xSchneider.com.github.rest_with_java_spring.dataDTO.PersonDTO;
import _xSchneider.com.github.rest_with_java_spring.exception.ResourceNotFoundException;
import static _xSchneider.com.github.rest_with_java_spring.mapper.ObjectMapper.parseListObjects;
import static _xSchneider.com.github.rest_with_java_spring.mapper.ObjectMapper.parseObject;
import _xSchneider.com.github.rest_with_java_spring.model.Person;
import _xSchneider.com.github.rest_with_java_spring.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll() {

        logger.info("Finding all persons");
        return parseListObjects(repository.findAll(), PersonDTO.class);

    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person with id " + person.getId());
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found"));
        repository.deleteById(id);
    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDTO.class);

    }
}
