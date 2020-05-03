package com.springboot.features.application.controller.graphql.resource;

import com.springboot.features.application.service.graphql.service.GraphqlService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("graphql/cricket")
public class CricketResource {

    @Autowired
    private GraphqlService graphqlService;

    @PostMapping
    public ResponseEntity cricket(@RequestBody String query) {
        ExecutionResult result = graphqlService.getGraphQL().execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

}

