package tests.mob;

import core.base.MobBaseTest;
import core.pages.mob.HelloPageMob;
import core.pages.mob.LoginPageMob;
import core.pages.mob.RecoveryByPhonePageMob;
import core.pages.mob.RecoveryStartPageMob;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhoneErrorMessageTest extends MobBaseTest {
    private static HelloPageMob helloPageMob;
    private static LoginPageMob loginPageMob;
    private static RecoveryStartPageMob recoveryStartPageMob;
    private static RecoveryByPhonePageMob recoveryByPhonePageMob;

    @BeforeEach
    public void prepare() {
        configure();
        helloPageMob = new HelloPageMob();
        helloPageMob.verifyPageElements();

    }

    @Test
    public void RecoveryByPhoneErrorMessageTest(){
        helloPageMob.clickLoginButton();

        loginPageMob = new LoginPageMob();
        loginPageMob.openRecoveryStartPage();

        recoveryStartPageMob = new RecoveryStartPageMob();
        recoveryStartPageMob.goToPhoneRecovery();

        recoveryByPhonePageMob = new RecoveryByPhonePageMob();
        String countryCode = recoveryByPhonePageMob.getCountryCodeByName("Япония");
        recoveryByPhonePageMob.getCodeButton.shouldBe(visible).click();

        assertEquals("+81", countryCode, "Код страны не совпадает с ожидаемым");
        String actualErrorMessage = recoveryByPhonePageMob.checkErrorAndErrorMessage();
        assertEquals("Введен неверный номер телефона", actualErrorMessage);
    }
}
