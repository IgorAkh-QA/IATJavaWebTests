package tests.web;

import core.base.WebBaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTestWeb extends WebBaseTest {

    @Test
    public void loginTest(){
        open(getBaseUrl());

    }
}
