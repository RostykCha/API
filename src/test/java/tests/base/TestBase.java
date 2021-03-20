package tests.base;

import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import models.base.assertions.UserAssert;
@Slf4j
public class TestBase {
public UserAssert userAssert ;
    public TestBase() {
        userAssert = new UserAssert();
        setUpRestAssured();
    }

    private void setUpRestAssured() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }
}
