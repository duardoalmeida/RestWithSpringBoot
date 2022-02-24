package services;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        return person;
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Person update(Person person){
        Person entity = repository.findById(person.getId()).orElseThrow();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }


    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
    }
}
