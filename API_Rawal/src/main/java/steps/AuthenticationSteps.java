package steps;

import io.cucumber.java.en.Given;
import objects.request.authenticate.LoginRequest;
import org.testng.Assert;
import services.LoginService;
import steps.BaseSteps;

public class AuthenticationSteps  extends BaseSteps {

    LoginService loginService = new LoginService();
    @Given("Login to Rawal using email: {string} and password: {string}")
    public void loginToRawalUsingEmailAndPassword(String email, String password) {
        LoginRequest loginRequest = new LoginRequest(email, password);
        String token = loginService.getTokem(loginRequest);
        scenarioContext.setContext("TOKEN", token);
        boolean verifyToken = loginService.verifyToken(token);
        Assert.assertTrue(verifyToken, "Token invalid!");
    }
}
