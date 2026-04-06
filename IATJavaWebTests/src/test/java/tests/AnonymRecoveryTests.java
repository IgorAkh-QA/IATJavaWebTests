package tests;

import core.base.AnonymRecoveryPage;
import core.base.BaseTest;
import core.base.RecoveryByEmailPage;
import core.base.RecoveryByPhonePage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryTests extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;
    private static RecoveryByEmailPage recoveryByEmailPage;


    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneErrorMessageTest(){

        loginPage.accessToPageWithCaptchaAppearsLogic();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToPhoneRecovery();

        recoveryByPhonePage = new RecoveryByPhonePage();
        recoveryByPhonePage.verifyPageElements();
        String countryCode = recoveryByPhonePage.selectCountryByName("Малайзия");
        assertEquals("+60", countryCode, "Код страны не совпадает с ожидаемым");

        String actualErrorMessage = recoveryByPhonePage.checkErrorAndErrorMessage();
        assertEquals("Неправильный номер телефона.", actualErrorMessage);


    }

    @Test
    public void anonymRecoveryByEmailTest(){
        loginPage.accessToPageWithCaptchaAppearsLogic();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToEmailRecovery();

        recoveryByEmailPage = new RecoveryByEmailPage();
        recoveryByEmailPage.verifyPageElements();


    }
}
