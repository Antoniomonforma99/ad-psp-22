package com.salesianostriana.dam.restquery.search.spec;

<<<<<<< HEAD
import com.salesianostriana.dam.restquery.model.Person;
import com.salesianostriana.dam.restquery.search.util.QueryableEntity;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GenericSpecificationBuilder<T> {

    private List<SearchCriteria> params;
    private Class type;

    public Specification<T> build() {
        List<SearchCriteria> checkedParams = params.stream()
                .filter(p -> QueryableEntity.checkQueryParam(type, p.getKey()))
                .collect(Collectors.toList());

        if (checkedParams.isEmpty()) {
            return null;
        }

        Specification<T> result = new GenericSpecification<T>(params.get(0));

        for(int i = 1; i < params.size(); i++) {
            result = result.and(new GenericSpecification<T>(params.get(i)));
=======
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class GenericSpecificationBuilder<T> {

    private List<SearchCriteria> params;

    public GenericSpecificationBuilder(List<SearchCriteria> params) {
        this.params = params;
    }

    public Specification<T> build() {
        if (params.isEmpty())
            return null;

        Specification<T> result = new GenericSpecification<>(params.get(0));

        for(int i = 1; i < params.size(); i++) {
            result = result.and(new GenericSpecification<>(params.get(i)));
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
        }

        return result;
    }

<<<<<<< HEAD


=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
}
