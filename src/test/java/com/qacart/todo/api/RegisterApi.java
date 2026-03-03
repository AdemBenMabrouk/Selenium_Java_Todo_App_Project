package com.qacart.todo.api;

import com.github.dockerjava.transport.DockerHttpClient;
import com.qacart.todo.config.Endpoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RegisterApi {
    private Cookies restAssuredCookies;
    private String accessToken;
    private String UserId;
    private String firstName;

    public Cookies getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
    public String getUserId() {
        return this.UserId;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void register(){
        User user = new UserUtils().generateRandomUser();
        //for unique emails
        user.setEmail("test+" + System.currentTimeMillis() + "@example.com");
        Response response=
                given()
                  .baseUri("https://todo.qacart.com")
                  .header("Content-type","application/json")
                  .body(user)
                .when()
                  .post(Endpoint.API_REGISTER_ENDPOINT)
                .then()
                  .extract().response();
        if(response.getStatusCode()!=201){
            throw  new RuntimeException("Something went wrong");

        }
        restAssuredCookies =response.detailedCookies();
        accessToken = response.path("access_token");
        UserId = response.path("userId");
        firstName = response.path("firstName");
    }
}
