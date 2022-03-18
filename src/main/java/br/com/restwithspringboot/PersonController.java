package br.com.restwithspringboot;

import br.com.restwithspringboot.data.model.Person;
import br.com.restwithspringboot.data.vo.PersonVO;
import br.com.restwithspringboot.data.vo.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.restwithspringboot.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    PersonServices service;

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public PersonVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return service.createV2(person);
    }

    @PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
    public PersonVO update(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
