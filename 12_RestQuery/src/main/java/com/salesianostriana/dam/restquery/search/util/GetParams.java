package com.salesianostriana.dam.restquery.search.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@NoArgsConstructor
@RequiredArgsConstructor
public class GetParams {

    public List<SearchCriteria> getParams(String search) {

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


        return params;
    }
}
