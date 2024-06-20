package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import objects.request.authentication.LoginRequest;
import objects.response.authentication.VerifyTokenResponse;
import org.testng.Assert;
import services.LoginService;

public class AuthenticationSteps extends BaseStep {
    LoginService loginService = new LoginService();

    @Given("Login to rawal using email: {string} and password:{string}")
    public void loginToRawalUsingEmailAndPassword(String email, String password) throws JsonProcessingException {
        LoginRequest loginRequest = new LoginRequest(email, password);
        String token = loginService.getToken(loginRequest);
        scenarioContext.setContext("TOKEN", token);
        Assert.assertTrue(loginService.verifyToken(token), "Not authenticate");
    }
}
