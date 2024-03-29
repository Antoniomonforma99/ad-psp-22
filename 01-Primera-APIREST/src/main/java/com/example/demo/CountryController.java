package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository repo;

    @GetMapping("/country/")
    //public List<Country> findAll() {
    public ResponseEntity<List<Country>> findAll() {
        //return repo.findAll();
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<Country> findByCode(
            @PathVariable String code
    ) {
        return ResponseEntity.of(repo.findFirstByCode(code));
    }

    @PostMapping("/coutry/")
    public ResponseEntity<Country> addCountry(Country country){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repo.save(country));
    }

}
