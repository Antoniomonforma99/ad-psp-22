package com.salesianostriana.dam.restquery.service;

import com.salesianostriana.dam.restquery.model.Person;
import com.salesianostriana.dam.restquery.repos.PersonRepository;
<<<<<<< HEAD
import com.salesianostriana.dam.restquery.search.spec.GenericSpecificationBuilder;
=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
import com.salesianostriana.dam.restquery.search.spec.PersonSpecification;
import com.salesianostriana.dam.restquery.search.spec.PersonSpecificationBuilder;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Page<Person> search(List<SearchCriteria> params, Pageable pageable) {
        PersonSpecificationBuilder personSpecificationBuilder =
                new PersonSpecificationBuilder(params);
<<<<<<< HEAD
        //GenericSpecificationBuilder<Person> personSpecificationBuilder =
        //        new GenericSpecificationBuilder<>(params, Person.class);
=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
        Specification<Person> spec =  personSpecificationBuilder.build();
        return personRepository.findAll(spec, pageable);
    }


}
