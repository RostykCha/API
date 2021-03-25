package tests.tests;

import models.base.dto.UserDto;
import org.testng.annotations.Test;
import service.Services;
import tests.base.TestBase;

public class VerifyGettingUser extends TestBase {
    private final String id = "1";
    private final String expectedName = "Leanne Graham";
    private final String expectedUserName = "Bret";
    private final String expectedCity = "Gwenborough";

    @Test
    public void verifyGettingUser() {
        UserDto userDto = Services.jsonPlaceHolderApi().user().getUSer(id);
        userAssert.verifyUserDto(expectedName, expectedUserName, expectedCity, userDto);
    }
}
