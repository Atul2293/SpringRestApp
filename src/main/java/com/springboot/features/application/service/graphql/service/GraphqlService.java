package com.springboot.features.application.service.graphql.service;

import com.springboot.features.application.service.graphql.service.datafetcher.AllPlayersDataFetcher;
import com.springboot.features.application.service.graphql.service.datafetcher.AllTeamDataFetcher;
import com.springboot.features.application.service.graphql.service.datafetcher.GetTeamPlayersDataFetcher;
import com.springboot.features.application.service.graphql.service.datafetcher.SaveTeamDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphqlService {

    @Value("classpath:graphqlSchema.graphql")
    private Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllTeamDataFetcher allTeamDataFetcher;

    @Autowired
    private GetTeamPlayersDataFetcher getTeamPlayersDataFetcher;

    @Autowired
    private AllPlayersDataFetcher allPlayersDataFetcher;

    @Autowired
    private SaveTeamDataFetcher saveTeamDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        //get all schema
        File schemaFile = resource.getFile();

        //parse schema
        TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(registry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allTeam", allTeamDataFetcher)
                        .dataFetcher("getTeamById", getTeamPlayersDataFetcher)
                        .dataFetcher("allPlayers", allPlayersDataFetcher)
                        .dataFetcher("saveTeam", saveTeamDataFetcher)
                )
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
