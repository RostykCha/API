package models.base.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.base.dto.UserDto;
import service.AbstractWebEndpoint;
import service.Endpoints;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserClient extends AbstractWebEndpoint {

    public static Response createNewUSer(UserDto userDto) {
        return given().body(userDto).post(Endpoints.USER);
    }

    public static Response updateUSer(UserDto userDto, String id) {
        return given().body(userDto).put(Endpoints.USER + "/" + id);
    }

    public static UserDto getUSer(String id) {
        return given().get(Endpoints.USER + "/" + id).then().statusCode(200).extract().as(UserDto.class);
    }

    public static List<UserDto> getAllUsers() {
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
