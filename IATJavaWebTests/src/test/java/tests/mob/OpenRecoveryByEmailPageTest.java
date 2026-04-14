package tests.mob;

import core.base.MobBaseTest;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenRecoveryByEmailPageTest extends MobBaseTest {
    private static HelloPageMob helloPageMob;
    private static LoginPageMob loginPageMob;
    private static RecoveryStartPageMob recoveryStartPageMob;
    private static RecoveryByEmailPageMob recoveryByEmailPageMob;

    @BeforeEach
    public void prepare() {
        configure();
        helloPageMob = new HelloPageMob();
        helloPageMob.verifyPageElements();

    }

    @Test
    public void OpenRecoveryByEmailPageTest(){
        helloPageMob.clickLoginButton();

        loginPageMob = new LoginPageMob();
        loginPageMob.openRecoveryStartPage();

        recoveryStartPageMob = new RecoveryStartPageMob();
        recoveryStartPageMob.goToEmailRecovery();

        recoveryByEmailPageMob = new RecoveryByEmailPageMob();
        recoveryByEmailPageMob.getCodeButton.shouldBe(visible);
        assertThat(recoveryByEmailPageMob.pageTitle.getText()).isEqualTo("Почта");

    }

}
