package br.com.restwithspringboot.services;

import br.com.restwithspringboot.converter.DozerConverter;
import br.com.restwithspringboot.converter.custom.PersonConverter;
import br.com.restwithspringboot.data.model.Person;
import br.com.restwithspringboot.data.vo.PersonVO;
import br.com.restwithspringboot.data.vo.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.restwithspringboot.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonConverter converter;

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person){
        var entity = converter.convertVOToEntity(person);
        var vo = converter.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public List<PersonVO> findAll(){

        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity = repository.findById(id).orElseThrow();
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){

        var entity = repository.findById(person.getId()).orElseThrow();

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(entity, PersonVO.class);
        return  vo;
    }


    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
    }
}
