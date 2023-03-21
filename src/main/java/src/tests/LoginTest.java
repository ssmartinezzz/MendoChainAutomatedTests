package src.tests;

import org.testng.annotations.Test;
import src.core.BaseTest;
import src.pages.LoggedUserPage;
import src.pages.LoginPage;

public class LoginTest extends BaseTest {

    /**
     * This test url can be modified to point to MendoChain's deploy url
     */
    @Test
    public void loginUserToMendoChainFail() {
        page.goTo("http://localhost:3000/");
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedUserPage  loggedUserPage = loginPage.loginUser("localtest","12345678");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void loginUserToMendoChainSuccess() {
        page.goTo("http://localhost:3000/");
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedUserPage  loggedUserPage = loginPage.loginUser("localtest","1597534682sS");
    }


}
