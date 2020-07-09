import company.name.pages.AuthorizationPage;
import company.name.pages.DriverManager;
import org.testng.annotations.Test;

public class AuthenticationClientTest {

    String login = "asdfg@1secmail.net";
    String password = "X1lWrA";

    private AuthorizationPage step = new AuthorizationPage(DriverManager.getDriver());

    @Test
    public void authentication(){
        step.testStandOpen();
        step.openWindowAuthorization();
        step.inputEmail(login);
        step.inputPassword(password);
        step.clickLogIn();
        step.clickLogOut();
        DriverManager.quit();
    }
}
