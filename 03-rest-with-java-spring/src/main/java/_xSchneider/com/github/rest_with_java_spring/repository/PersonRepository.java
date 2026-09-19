package _xSchneider.com.github.rest_with_java_spring.repository;

import _xSchneider.com.github.rest_with_java_spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
