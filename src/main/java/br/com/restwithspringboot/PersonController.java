package br.com.restwithspringboot;

import model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    PersonServices services = new PersonServices();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return services.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return services.create(person);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }

}
