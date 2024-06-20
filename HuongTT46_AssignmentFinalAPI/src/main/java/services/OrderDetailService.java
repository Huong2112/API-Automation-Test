package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import objects.response.orderDetail.DataOrderDetailResponse;

public class OrderDetailService extends BaseRestService{
    public OrderDetailService(){
        this.setProtocol("https");
        this.setHost("rawal-admin.themes-coder.net");
    }

    public DataOrderDetailResponse getOrderDetailData(){
        DataOrderDetailResponse dataOrderDetailResponse;
        getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/order/990")
                .queryParam("orderDetail", 1)
                .queryParam("productDetail", 1)
                .queryParam("currency", 1)
                .queryParam("billing_country", 1)
                .queryParam("billing_state", 1)
                .queryParam("delivery_country", 1)
                .queryParam("delivery_state", 1)
                .queryParam("customer", 1);
        Response response = this.dispatchServiceRequest(requestSpecification, Method.GET);
        ObjectMapper objectMapper = new ObjectMapper();
        String responseString = response.body().asString();
        try {
            dataOrderDetailResponse = objectMapper.readValue(responseString, DataOrderDetailResponse.class);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

        return dataOrderDetailResponse;
    }

    public boolean verifyOrderId(String expId){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualId = dataOrderDetailResponse.getData().getOrderId();
        return  actualId.equalsIgnoreCase(expId);
    }

    public boolean verifyFirstName(String expFName){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualFName = dataOrderDetailResponse.getData().getCustomer().getFirstName();
        return  actualFName.equalsIgnoreCase(expFName);
    }


    public boolean verifyLastName(String expLName){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualLName = dataOrderDetailResponse.getData().getCustomer().getLastName();
        return  actualLName.equalsIgnoreCase(expLName);
    }

    public boolean verifyCustomerStatus(String expStatus){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualStatus = dataOrderDetailResponse.getData().getCustomer().getCustomerStatus();
        return  actualStatus.equalsIgnoreCase(expStatus);
    }

    public boolean verifyCountryName(String expCName){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualCName = dataOrderDetailResponse.getData().getCustomer().getCustomerAddress().get(0).getCountry().getCountryName();
        return  actualCName.equalsIgnoreCase(expCName);
    }

    public boolean verifyStateName(String expSName){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualSName = dataOrderDetailResponse.getData().getCustomer().getCustomerAddress().get(0).getState().getStateName();
        return  actualSName.equalsIgnoreCase(expSName);
    }

    public boolean verifyOrderFrom(String expOrderFrom){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualOrderFrom = dataOrderDetailResponse.getData().getOrderFrom();
        return  actualOrderFrom.equalsIgnoreCase(expOrderFrom);
    }

    public boolean verifyShippingMethod(String expShippingMethod){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualShippingMethod = dataOrderDetailResponse.getData().getShippingMethod();
        return  actualShippingMethod.equalsIgnoreCase(expShippingMethod);
    }

    public boolean verifyOrderStatus(String expOrderStatus){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualOrderStatus = dataOrderDetailResponse.getData().getOrderStatus();
        return  actualOrderStatus.equalsIgnoreCase(expOrderStatus);
    }


    public boolean verifyOrderIdInProductDetail(String expProductId){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualProductId = dataOrderDetailResponse.getData().getOrderDetail().get(0).getProduct().getProductId();
        return  actualProductId.equalsIgnoreCase(expProductId);
    }

    public boolean verifyOrderSkuInProductDetail(String expProductSku){
        DataOrderDetailResponse dataOrderDetailResponse = scenarioContext.getData("DataOrderDetailResponse");
        String actualProductSku = dataOrderDetailResponse.getData().getOrderDetail().get(0).getProduct().getProductSku();
        return  actualProductSku.equalsIgnoreCase(expProductSku);
    }









}
