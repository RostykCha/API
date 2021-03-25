package tests.tests;

import models.base.dto.AddressDto;
import models.base.dto.CompanyDto;
import models.base.dto.GeoDto;
import models.base.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import service.Services;
import tests.base.TestBase;

public class VerifyTheAbilityToUpdateUserValidId extends TestBase {
    private  String idOld = "13";
    private  String idNew = "8";
    private  String name = "Ros";
    private  String username = "Cha";
    private  String email = "roma@dfd.com";
    private  GeoDto geo = new GeoDto("-37.3159","81.1496");
    private  AddressDto addressDto = new AddressDto("Shevchenka", "Ukr", "Lviv", "45454",geo);
    private  String phone = "+38073098734";
    private  String website = "realty.com";
    private  CompanyDto companyDto = new CompanyDto("Soft", "Salary", "bs");

    @Test
    public void verifyUpdatingUser() {
        UserDto userDto = new UserDto()
                .setUserName(name)
                .setEmail(email)
                .setAddress(addressDto)
                .setPhone(phone)
                .setId(idOld);
        UserDto response = Services.jsonPlaceHolderApi().user().updateUSer(userDto, idNew);
        //Verification
        Assertions.assertThat(response.getId()).isEqualTo(idNew);
    }
}
