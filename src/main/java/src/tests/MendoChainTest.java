package src.tests;

import org.testng.annotations.Test;
import src.core.BaseTest;
import src.pages.LoggedUserPage;
import src.pages.LoginPage;

public class MendoChainTest extends BaseTest {

    /**
     * This test url can be modified to point to MendoChain's deploy url
     */
    @Test
    public void loginUserToMendoChain() {
        page.goTo("http://localhost:3000/");
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedUserPage  loggedUserPage = loginPage.loginUser("localtest","1597534682sS");
    }


}
