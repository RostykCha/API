package tests.tests;

import io.restassured.response.Response;
import models.base.clients.UserClient;
import models.base.dto.AddressDto;
import models.base.dto.CompanyDto;
import models.base.dto.GeoDto;
import models.base.dto.UserDto;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyTheAbilityToUpdateUserValidId extends TestBase {
    private final String id = "13";
    private final String name = "Ros";
    private final String username = "Cha";
    private final String email = "roma@dfd.com";
    private final GeoDto geo = new GeoDto("-37.3159","81.1496");
    private final AddressDto addressDto = new AddressDto("Shevchenka", "Ukr", "Lviv", "45454",geo);
    private final String phone = "+38073098734";
    private final String website = "realty.com";
    private final CompanyDto companyDto = new CompanyDto("Soft", "Salary", "bs");

    @Test
    public void verifyUpdatingUser() {
        UserDto userDto = new UserDto(id, name, username, email, addressDto, phone, website, companyDto);
        Response response = UserClient.updateUSer(userDto,"8");
        userAssert.verifyUpdatingUserResponseCodeIs200(response);
    }
}
