package models.base.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.base.dto.UserDto;
import service.AbstractWebEndpoint;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserEndpoint extends AbstractWebEndpoint {
    private static final String USERS_END = "/users";
    private static final String USERS_RES_END = "/users/{userID}";

    public UserEndpoint(RequestSpecification specification) {
        super(specification);
    }


    public UserDto createNewUSer(UserDto userDto) {
        ValidatableResponse response = post(this.specification, USERS_END, userDto);
        response.statusCode(201);
        return response.extract().as(UserDto.class);
    }

    public ValidatableResponse createNewUSer(UserDto userDto, int statusCode) {
        ValidatableResponse response = post(this.specification, USERS_END, userDto, null);
        response.statusCode(statusCode);
        return response;
    }


    public UserDto updateUSer(UserDto userDto, String id) {
        ValidatableResponse response = put(this.specification, USERS_RES_END, userDto, id);
        response.statusCode(200);
        return response.extract().as(UserDto.class);
    }

    public ValidatableResponse updateUSer(UserDto userDto, String id, int statusCode) {
        ValidatableResponse response = put(this.specification, USERS_RES_END, userDto, id);
        response.statusCode(statusCode);
        return response;
    }

    public UserDto getUSer(String id) {
        ValidatableResponse response = get(this.specification, USERS_RES_END, id);
        response.statusCode(200);
        return response.extract().as(UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        Response response = given().get(USERS_END);
        response.then().statusCode(200);
        ObjectMapper mapper = new ObjectMapper();
        List<UserDto> myObjects = null;
        try {
            myObjects = mapper.readValue(response.asString(), new TypeReference<List<UserDto>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObjects;
    }
}
