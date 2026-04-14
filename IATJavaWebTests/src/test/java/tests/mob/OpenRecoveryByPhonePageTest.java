package tests.mob;

import core.base.MobBaseTest;
import core.pages.mob.HelloPageMob;
import core.pages.mob.LoginPageMob;
import core.pages.mob.RecoveryByPhonePageMob;
import core.pages.mob.RecoveryStartPageMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenRecoveryByPhonePageTest extends MobBaseTest {
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
    public void OpenRecoveryByPhonePageTest(){
        helloPageMob.clickLoginButton();

        loginPageMob = new LoginPageMob();
        loginPageMob.openRecoveryStartPage();

        recoveryStartPageMob = new RecoveryStartPageMob();
        recoveryStartPageMob.goToPhoneRecovery();

        recoveryByPhonePageMob = new RecoveryByPhonePageMob();
        recoveryByPhonePageMob.getCodeButton.shouldBe(visible);
        assertThat(recoveryByPhonePageMob.pageSubTitle.getText()).isEqualTo("Телефон");

    }

}
