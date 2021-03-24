package service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class AbstractWebEndpoint {

    protected RequestSpecification specification;

    public AbstractWebEndpoint() {

    }

    public AbstractWebEndpoint(RequestSpecification specification) {
        this.specification = specification;
    }

    public ValidatableResponse post(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return given()
                .spec(specBuilder.build())
                .when()
                .post(path, pathParams)
                .then();
    }

    public ValidatableResponse get(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return given()
                .spec(specBuilder.build())
                .when()
                .get(path, pathParams)
                .then();
    }

    public ValidatableResponse put(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return given()
                .spec(specBuilder.build())
                .when()
                .put(path, pathParams)
                .then();
    }

}
