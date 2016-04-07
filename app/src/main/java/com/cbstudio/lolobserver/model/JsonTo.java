package com.cbstudio.lolobserver.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Colabear on 2016-04-07.
 */
public class JsonTo {

    public static Summoner summoner(String json, String userName) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(json, JsonNode.class);

        return mapper.treeToValue(node.get(userName), Summoner.class);
    }
}
