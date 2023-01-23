package com.salesianostriana.dam.restquery.controller;


import com.salesianostriana.dam.restquery.model.Person;
import com.salesianostriana.dam.restquery.repos.PersonRepository;
<<<<<<< HEAD
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import com.salesianostriana.dam.restquery.search.util.SearchCriteriaExtractor;
=======
import com.salesianostriana.dam.restquery.search.util.GetParams;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
import com.salesianostriana.dam.restquery.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    //private final PersonRepository repository;
    private final PersonService service;
<<<<<<< HEAD
=======
    private final GetParams getParams;
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b

    @GetMapping("/")
    public ResponseEntity<Page<Person>> search(
            @RequestParam(value = "search", defaultValue = "") String search,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

<<<<<<< HEAD
        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);
=======

        List<SearchCriteria> params = getParams.getParams(search);



        /*
        List<SearchCriteria> params = new ArrayList<>();

        //search=k1:v1,k2<v2,k3>v3
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        while(matcher.find()) {
            String key = matcher.group(1); // k1:v1 => k1
            String operator = matcher.group(2); // k1:v1 => :
            Object value = matcher.group(3); // k1:v1 => v1

            params.add(new SearchCriteria(key, operator, value));

        }
        */

>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b

        Page<Person> result = service.search(params, pageable);

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

}
