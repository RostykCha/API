package service.mainService;

import io.restassured.specification.RequestSpecification;
import models.base.clients.UserEndpoint;

public class JsonPlaceHolderApi extends AbstractWebsService {

    private RequestSpecification defaultRequestSpecification;
    private UserEndpoint userEndpoint;

    private JsonPlaceHolderApi(){
        initEndpoints();
    }

    public static JsonPlaceHolderApi jsonPlaceHolderApi() {
        return new JsonPlaceHolderApi();
    }

    protected void initEndpoints(){
        RequestSpecification requestSpecification = getDefaultRequestSpecification();
        initUserEndpoint(requestSpecification);
    }

    private void initUserEndpoint(RequestSpecification requestSpecification) {
        userEndpoint = new UserEndpoint(requestSpecification);
    }

    public UserEndpoint user(){
        return userEndpoint;
    }
}
