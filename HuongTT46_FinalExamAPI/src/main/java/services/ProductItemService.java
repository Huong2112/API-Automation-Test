package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.productItems.ProductItemsResponse;
import objects.response.productItems.ProductResponse;

import java.util.List;

public class ProductItemService extends BaseRestService{
        public ProductItemService(){
            this.setProtocol("https");
            this.setHost("thinkpro.vn");
        }

        public ProductItemsResponse getProductItemsResponse(){
            ProductItemsResponse productItemsResponse;
            RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/catalog-fs/product-items")
                    .queryParam("keyword", "")
                    .queryParam("cur_page", 1)
                    .queryParam("per_page", 20)
                    .queryParam("sort", 1)
                    .queryParam("category", "ban-phim");
            Response response = this.dispatchServiceRequest(requestSpecification, Method.GET);
            String responseString = response.body().asString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                productItemsResponse = objectMapper.readValue(responseString, ProductItemsResponse.class);
            }catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }
            return  productItemsResponse;
        }

        public void extractResponse(){
            ProductItemsResponse productItemsResponse = scenarioContext.getContext("ProductItemsResponse");
            List<ProductResponse> productList = productItemsResponse.getData();
            System.out.println("Extract product data from response: ");
            for (ProductResponse p : productList){
                System.out.println(p.toString());
            }
        }
}
