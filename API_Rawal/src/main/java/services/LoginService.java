package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.cy_gb.Ond;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.request.authenticate.LoginRequest;
import objects.response.authenticate.LoginResponse;
import objects.response.authenticate.VerifyTokenResponse;

public class LoginService extends BaseRestService{
    public LoginService(){
        this.setProtocol("https");
        this.setHost("rawal-admin.themes-coder.net");
    }

    public String getTokem(LoginRequest loginRequest){
        String token = "";
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/login")
                .body(loginRequest.converObjecToJSONString());
        Response response = this.dispatchServiceRequest(requestSpecification, Method.POST);
        String responseString = response.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        LoginResponse loginResponse = new LoginResponse();
        try {
            loginResponse = objectMapper.readValue(responseString, LoginResponse.class);
        } catch (Exception e) {

        }

        return loginResponse.getToken();
    }

    public boolean verifyToken(String token){
        boolean checkToken = false;
        getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/token-validate").body("{}");
        Response response = this.dispatchServiceRequest(requestSpecification, Method.POST);
        String responseString = response.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        VerifyTokenResponse verifyTokenResponse = new VerifyTokenResponse();
        try {
            verifyTokenResponse = objectMapper.readValue(responseString, VerifyTokenResponse.class);
        } catch (Exception e) {

        }
        checkToken = verifyTokenResponse.getMessage().equals("Token is valid!");
        return  checkToken;
    }
}
