package com.salesianostriana.dam.restquery.search.spec;

import com.salesianostriana.dam.restquery.model.Person;
<<<<<<< HEAD
import com.salesianostriana.dam.restquery.search.util.QueryableEntity;
=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

public class PersonSpecificationBuilder extends GenericSpecificationBuilder<Person> {
    public PersonSpecificationBuilder(List<SearchCriteria> params) {
        super(params, Person.class);
    }


    /*private List<SearchCriteria> params;
=======

public class PersonSpecificationBuilder {

    private List<SearchCriteria> params;
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b

    public PersonSpecificationBuilder(List<SearchCriteria> params) {
        this.params = params;
    }

    public Specification<Person> build() {
<<<<<<< HEAD

        List<SearchCriteria> checkedParams = params.stream().filter(p -> QueryableEntity.checkQueryParam(Person.class, p.getKey())).collect(Collectors.toList());
        //List<SearchCriteria> checkedParams = params.stream().filter(p -> Person.checkQueryParam(p.getKey())).collect(Collectors.toList());

        if (checkedParams.isEmpty()) {
            return null;
        }

        Specification<Person> result = new PersonSpecification(checkedParams.get(0));

        for(int i = 1; i < checkedParams.size(); i++) {
            result = result.and(new PersonSpecification(checkedParams.get(i)));
=======
    //public PersonSpecification build() {

        if (params.isEmpty()) {
            return null;
        }

        Specification<Person> result = new PersonSpecification(params.get(0));

        for(int i = 1; i < params.size(); i++) {
            result = result.and(new PersonSpecification(params.get(i)));
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
        }

        return result;


<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b


}
