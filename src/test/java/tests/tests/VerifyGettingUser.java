package tests.tests;

import models.base.clients.UserClient;
import models.base.dto.UserDto;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyGettingUser extends TestBase {
    private final String id = "1";
    private final String expectedName = "Leanne Graham";
    private final String expectedUserName = "Bret";
    private final String expectedCity = "Gwenborough";

    @Test
    public void verifyUpdatingUser() {
        UserDto userDto = UserClient.getUSer(id);
        userAssert.verifyUserDto(expectedName, expectedUserName, expectedCity, userDto);
    }
}
