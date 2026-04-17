package tests.web;

import core.pages.web.AnonymRecoveryPageWeb;
import core.base.WebBaseTest;
import core.pages.web.RecoveryByEmailPageWeb;
import core.pages.web.RecoveryByPhonePageWeb;
import core.pages.web.LoginPageWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryTests extends WebBaseTest {

    private static LoginPageWeb loginPage;
    private static AnonymRecoveryPageWeb anonymRecoveryPage;
    private static RecoveryByPhonePageWeb recoveryByPhonePage;
    private static RecoveryByEmailPageWeb recoveryByEmailPage;


    @BeforeEach
    public void prepare(){
        loginPage = new LoginPageWeb();
    }

    @Test
    public void anonymRecoveryByPhoneErrorMessageTest(){

        loginPage.accessToPageWithCaptchaAppearsLogic();
        anonymRecoveryPage = new AnonymRecoveryPageWeb();
        anonymRecoveryPage.goToPhoneRecovery();

        recoveryByPhonePage = new RecoveryByPhonePageWeb();
        recoveryByPhonePage.verifyPageElements();
        String countryCode = recoveryByPhonePage.selectCountryByName("Малайзия");
        assertEquals("+60", countryCode, "Код страны не совпадает с ожидаемым");

        String actualErrorMessage = recoveryByPhonePage.checkErrorAndErrorMessage();
        assertEquals("Неправильный номер телефона.", actualErrorMessage);


    }

    @Test
    public void anonymRecoveryByEmailTest(){
        loginPage.accessToPageWithCaptchaAppearsLogic();
        anonymRecoveryPage = new AnonymRecoveryPageWeb();
        anonymRecoveryPage.goToEmailRecovery();

        recoveryByEmailPage = new RecoveryByEmailPageWeb();
        recoveryByEmailPage.verifyPageElements();


    }
}
