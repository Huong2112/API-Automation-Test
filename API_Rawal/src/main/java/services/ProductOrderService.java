package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.orderResponse.ProductOrderListResponse;

public class ProductOrderService extends BaseRestService{
        public ProductOrderService(){
            this.setProtocol("https");
            this.setHost("rawal-admin.themes-coder.net");
        }

        public ProductOrderListResponse getListOrders(){
            ProductOrderListResponse productOrderListResponse;
            getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
            RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/order?limit=10&searchParameter=&sortBy=id&sortType=DESC");
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

        public int getNumberOfOrderFromOrderFrom(){
            ProductOrderListResponse productOrderListResponse = scenarioContext.getContext("ProductOrderListResponse");
            return productOrderListResponse.getProductOrderResponses().size();

        }


}
