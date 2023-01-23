package com.salesianostriana.dam.restquery.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salesianostriana.dam.restquery.search.util.QueryableEntity;
=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
=======
import java.time.LocalDate;
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Person {

    @Id @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate hireDate;
    private boolean isMarried;
    private String gender;
<<<<<<< HEAD
    private LocalDateTime dateTime;


    // Versión 1 de cómo garantizar la búsqueda solamente sobre campos de la entidad
    // Versión 2 -> Ver el método estático de la interfaz QueryableEntity.

    /*
        Lo ideal es que la interfaz definiera un método estático y que la clase
        implementara la interfaz, pero entonces es imposible saber dinámicamente
        el tipo de la entidad.

        Y si se implementan como métodos por defecto, a la hora de comprobar necesitamos
        una instancia de la entidad, y no podemos usar métodos estáticos.
     */

    //@JsonIgnore
//    public static String[] getQueryFields() {
//        return Arrays.stream(Person.class.getDeclaredFields()).map(Field::getName).toArray(String[]::new);
//    }
//
//    public static boolean checkQueryParam(String fieldName) {
//        //return Arrays.stream(Person.class.getDeclaredFields()).map(Field::getName).filter(n -> n.equalsIgnoreCase(fieldName)).count() > 0;
//        return Arrays.stream(Person.getQueryFields()).anyMatch(n -> n.equalsIgnoreCase(fieldName));
//    }




=======
>>>>>>> 8c6dcff0262f85375aaeb94e3fe45b84d7eb188b

}
