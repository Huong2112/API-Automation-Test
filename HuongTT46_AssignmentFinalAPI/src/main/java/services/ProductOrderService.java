package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.orderProduct.ProductOrderListResponse;
import objects.response.orderProduct.ProductOrderResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderService extends BaseRestService{
        public ProductOrderService(){
            this.setProtocol("https");
            this.setHost("rawal-admin.themes-coder.net");
        }

        public ProductOrderListResponse getListOrders(){
            ProductOrderListResponse productOrderListResponse;
            getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
            RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/order")
                    .queryParam("limit", 10)
                    .queryParam("searchParameter", "")
                    .queryParam("sortBy", "id")
                    .queryParam("sortType", "DESC");
            Response response = this.dispatchServiceRequest(requestSpecification, Method.GET);
            String responseString = response.body().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                productOrderListResponse= objectMapper.readValue(responseString, ProductOrderListResponse.class);

            }catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }
            return productOrderListResponse;
        }

        private int getNumberOfOrderFrom(String name){
            ProductOrderListResponse productOrderListResponse = scenarioContext.getContext("ProductOrderListResponse");
            List<ProductOrderResponse> productOrderResponses = productOrderListResponse.getData();
            List<ProductOrderResponse> orderFromPos = new ArrayList<>();
            for (ProductOrderResponse p : productOrderResponses){
                if (p.getOrderFrom().equalsIgnoreCase(name)){
                    orderFromPos.add(p);
                }
            }
            return orderFromPos.size();
        }

        public boolean verifyNumberOfOrder(String name, int expectedNumber){
            System.out.println("Số lượng cái pos mà nó lấy được "+getNumberOfOrderFrom(name));
            return getNumberOfOrderFrom(name) == expectedNumber;
        }

        public boolean verifyOrderIdDESC(){
            ProductOrderListResponse productOrderListResponse = scenarioContext.getContext("ProductOrderListResponse");
            List<ProductOrderResponse> productOrderResponses = productOrderListResponse.getData();
            for (int i = 0; i < productOrderResponses.size() - 1; i++){
                int formerNumber = Integer.parseInt(productOrderResponses.get(i).getOrderId());
                int latterNumber = Integer.parseInt(productOrderResponses.get(i+1).getOrderId());
                if (formerNumber <= latterNumber){
                    return false;
                }
            }
            return true;
        }

        public boolean verifyOrderWithId(String expId, String expTitle, String expExchange, String expCountryName, String expCountryCode){
            ProductOrderListResponse productOrderListResponse = scenarioContext.getContext("ProductOrderListResponse");
            List<ProductOrderResponse> productOrderResponses = productOrderListResponse.getData();
            ProductOrderResponse orderResponse = null;
            for (ProductOrderResponse p : productOrderResponses){
                if (p.getOrderId().equals(expId)){
                    orderResponse = p;
                    break;
                }
            }
            if (orderResponse == null){
                System.out.println("Id not match any order!");
                return false;
            }else {
                boolean title = orderResponse.getCurrencyId().getTitle().equals(expTitle);
                System.out.println(title);
                boolean exchangeRate = orderResponse.getCurrencyId().getExchangeRate().equals(expExchange);
                System.out.println(exchangeRate);
                boolean cName = orderResponse.getCurrencyId().getCountry().getCountryName().equals(expCountryName);
                System.out.println(cName);
                boolean cCode = orderResponse.getCurrencyId().getCountry().getCountryCode().equals(expCountryCode);
                System.out.println(cCode);
                return  title && exchangeRate && cName && cCode;
            }
        }

}
