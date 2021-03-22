package models.base.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.base.dto.UserDto;
import service.AbstractWebEndpoint;
import service.Endpoints;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserEndpoint extends AbstractWebEndpoint {
    private static final String USERS_END = "/users";
    private static final String USERS_RES_END = "/user/{userID}";

    public UserEndpoint(RequestSpecification specification) {
        super(specification);
        this.specification = specification;
    }



    public  UserDto createNewUSer(UserDto userDto) {
        ValidatableResponse response = post(this.specification,USERS_END,userDto);
        response.statusCode(201);
        return  response.extract().as(UserDto.class);
    }

    public  ValidatableResponse createNewUSer(UserDto userDto, int statusCode) {
        ValidatableResponse response = post(this.specification,USERS_END,userDto,null);
        response.statusCode(statusCode);
        return  response;
    }







    public  Response updateUSer(UserDto userDto, String id) {
        return given().body(userDto).put(Endpoints.USER + "/" + id);
    }

    public  UserDto getUSer(String id) {
        return given().get(Endpoints.USER + "/" + id).then().statusCode(200).extract().as(UserDto.class);
    }

    public  List<UserDto> getAllUsers() {
        Response response = given().get(Endpoints.USER);
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
