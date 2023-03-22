package mendochain.tests.log;

import org.testng.annotations.Test;
import mendochain.core.BaseTest;
import mendochain.pages.LoggedUserPage;
import mendochain.pages.LoginPage;

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

    @Test
    public void logInAndLogOut() {
        page.goTo("http://localhost:3000/");
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedUserPage  loggedUserPage = loginPage.loginUser("localtest","1597534682sS");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginPage loginPage2 = loggedUserPage.logOut();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
