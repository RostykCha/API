package tests.tests;

import models.base.dto.AddressDto;
import models.base.dto.CompanyDto;
import models.base.dto.GeoDto;
import models.base.dto.UserDto;
import org.testng.annotations.Test;
import service.Services;
import tests.base.TestBase;

public class VerifyValidationUpdatingInvalidId extends TestBase {
    private final String name = "Ros";
    private final String email = "roma@dfd.com";
    private final GeoDto geo = new GeoDto("-37.3159", "81.1496");
    private final AddressDto addressDto = new AddressDto("Shevchenka", "Ukr", "Lviv", "45454", geo);
    private final String phone = "+38073098734";
    private final String idOld = "3";
    private final String idNewWrong = "26";

    @Test
    public void verifyUpdatingUserInvalidId() {
        UserDto userDto = new UserDto()
                .setUserName(name)
                .setEmail(email)
                .setAddress(addressDto)
                .setPhone(phone)
                .setId(idOld);
        //Verify response
        Services.jsonPlaceHolderApi().user().updateUSer(userDto, idNewWrong, 500);
    }
}
