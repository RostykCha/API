package tests.tests;

import io.restassured.response.Response;
import models.base.clients.UserClient;
import models.base.dto.AddressDto;
import models.base.dto.CompanyDto;
import models.base.dto.GeoDto;
import models.base.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import service.Services;
import tests.base.TestBase;

public class VerifyAbilityToCreateANewUSer2 extends TestBase {
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
    public void verifyCreatingNewUser() {
        UserDto userDto = new UserDto()
                .setUserName(name)
                .setEmail(email)
                .setAddress(addressDto)
                .setPhone(phone);

        UserDto createdUserResponse = Services.jsonPlaceHolderApi().user().createNewUSer(userDto);
        //Verification
        Assertions.assertThat(createdUserResponse)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .ignoringFields("id")
                .isEqualTo(userDto);

        Response response = UserClient.createNewUSer(userDto);
        userAssert.verifyCreatingUserResponseCodeIs201(response);
    }


}
