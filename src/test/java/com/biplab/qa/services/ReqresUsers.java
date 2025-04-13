package com.biplab.qa.services;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresUsers {
    public static final String BASE_URL = "https://reqres.in";
    public static final String API_URL = BASE_URL + "/api";
    public static final String USER_URL = API_URL + "/users";

    public static Response getUsers() {
        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().get(USER_URL); // without when also works
        return response;
    }


    public static Response delayedResponse() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(USER_URL)
                .queryParam("delay=10")
                .get(); // without when also works
        return response;
    }
}
