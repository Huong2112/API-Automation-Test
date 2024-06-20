package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.paymentMethod.PaymentMethodListResponse;
import objects.response.paymentMethod.PaymentMethodResponse;
import objects.response.paymentMethod.PaymentSettingResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodService extends BaseRestService{
    public PaymentMethodService(){
        this.setHost("rawal-admin.themes-coder.net");
        this.setProtocol("https");
    }

    public PaymentMethodListResponse getListPaymentMethod(){
        PaymentMethodListResponse  paymentMethodListResponse;
        getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/payment_method")
                .queryParam("limit", 10)
                .queryParam("searchParameter", "")
                .queryParam("getPaymentMethodSetting", 1)
                .queryParam("sortBy", "id")
                .queryParam("sortType", "ASC");
        Response response = this.dispatchServiceRequest(requestSpecification, Method.GET);
        String responseString = response.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            paymentMethodListResponse = objectMapper.readValue(responseString, PaymentMethodListResponse.class);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return paymentMethodListResponse;
    }

    public boolean verifyPaymentMethodDisplay(List<String> expectedPaymentMethod){
        // gọi ở bước verify
        List<PaymentMethodResponse> paymentMethodResponses = getPaymentMethods();
        List<String> actualPaymentMethod = new ArrayList<>();
        for (PaymentMethodResponse p : paymentMethodResponses){
            actualPaymentMethod.add(p.getName());
        }
        boolean isDisplayAll = compareToListString(actualPaymentMethod, expectedPaymentMethod);
        return isDisplayAll;
    }

    private List<PaymentMethodResponse> getPaymentMethods(){
        PaymentMethodListResponse paymentMethodListResponse = scenarioContext.getContext("ListPaymentMethod");
        List<PaymentMethodResponse> paymentMethodResponses = paymentMethodListResponse.getData();
        return paymentMethodResponses;
    }

    public boolean verifySettingOfPaymentMethod(String name, List<String> expectedKey, int expectedNumber){
        List<PaymentSettingResponse> paymentSetting = new ArrayList<>();
        List<PaymentMethodResponse> paymentMethodResponses = getPaymentMethods();
        for (PaymentMethodResponse p : paymentMethodResponses){
            if ((p.getName()).equalsIgnoreCase(name)){
                paymentSetting = p.getPaymentSetting();
                break;
            }
        }
        List<String> actualKey = new ArrayList<>();
        for (PaymentSettingResponse ps : paymentSetting){
            actualKey.add(ps.getKey());
        }

        return compareToListString(actualKey, expectedKey) && actualKey.size() == expectedNumber;
    }
    public boolean verifyResponseBody(String expectedStatus, String expectedMessage, String expectedStatusCode){
        PaymentMethodListResponse paymentMethodListResponse = scenarioContext.getContext("ListPaymentMethod");
        boolean verifyResponse = paymentMethodListResponse.getStatus().equals(expectedStatus)
                && paymentMethodListResponse.getMessage().equals(expectedMessage)
                && paymentMethodListResponse.getStatusCode().equals(expectedStatusCode);
        return verifyResponse;
    }
}
