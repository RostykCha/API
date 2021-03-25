package tests.tests;

import models.base.dto.UserDto;
import org.testng.annotations.Test;
import service.Services;
import tests.base.TestBase;

import java.util.List;

public class VerifyCountOfUsersList extends TestBase {
    private final int MIN_SIZE = 1;

    @Test
    public void verifyCountOfUsersList() {
        List<UserDto> actualList = Services.jsonPlaceHolderApi().user().getAllUsers();
        userAssert.verifyUserDtoSizeIsGreaterThan(actualList.size(), MIN_SIZE);

    }
}
