package service.mainService;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.TestProperties;

public abstract class AbstractWebsService {

    protected RequestSpecification getDefaultRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(TestProperties.getBaseUrl())
                .setContentType(ContentType.JSON)
                .build();
    }
}
