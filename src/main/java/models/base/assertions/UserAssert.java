package models.base.assertions;

import io.restassured.response.Response;
import models.base.dto.UserDto;
import org.testng.Assert;

import static utils.UserLogger.logInfo;

public class UserAssert {

    public void verifyCreatingUserResponseCodeIs201(Response response) {
        String id = response.then().extract().as(UserDto.class).id;
        logInfo.info("Verify that that user with ID : " + id + " is created");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    public void verifyUpdatingUserResponseCodeIs200(Response response) {
        String id = response.then().extract().as(UserDto.class).id;
        logInfo.info("Verify that that user with ID : " + id + " was Updated");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    public void verifyUpdatingUserInvalidIdResponseCodeIs404(Response response, String id) {
        logInfo.info("Verify validating for updating user with wrong ID : " + id);
        int statusCode = response.getStatusCode();
        Assert.assertTrue(response.getStatusLine().contains("Invalid User Id Provided"));
        Assert.assertEquals(statusCode, 404);

    }

    public void verifyUserDto(String expectedName, String expectedUserName, String expectedCity, UserDto actualUserDto) {
        Assert.assertEquals(actualUserDto.name, expectedName);
        Assert.assertEquals(actualUserDto.username, expectedUserName);
        Assert.assertEquals(actualUserDto.address.city, expectedCity);

    }

    public void verifyUserDtoSizeIsGreaterThan(int actualSize, int expectedMinSize) {
        Assert.assertTrue(actualSize > expectedMinSize);

    }
}
