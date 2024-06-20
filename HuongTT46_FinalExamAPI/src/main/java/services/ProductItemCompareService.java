package services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import objects.request.productItemCompare.CompareRequest;
import objects.response.productItemCompare.ProductCompare;
import objects.response.productItemCompare.ProductComparedResponse;
import objects.response.productItems.ProductItemsResponse;
import objects.response.productItems.ProductResponse;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductItemCompareService extends BaseRestService{

    public ProductItemCompareService(){
        this.setProtocol("https");
        this.setHost("thinkpro.vn");
    }

    public ProductComparedResponse getProductComparedResponse(CompareRequest compareRequest){
        ProductComparedResponse productComparedResponse;
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/front-store/v2/product-items/compare")
                .body(compareRequest.getBody());
        System.out.println(compareRequest);
        Response response = this.dispatchServiceRequest(requestSpecification, Method.POST);
        String responseString = response.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productComparedResponse = objectMapper.readValue(responseString, ProductComparedResponse.class);

        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return  productComparedResponse;
    }

    public void compareProducts(){
        List<ProductResponse> randomList = scenarioContext.getContext("ListProductFromRandom");
        List<ProductCompare> comparedList = scenarioContext.getContext("ListProductOfCompareResult");
        System.out.println("Random: " +randomList);
        System.out.println("Compared: " +comparedList);
        SoftAssert softAssert = new SoftAssert();
        for (ProductResponse random : randomList){
            for (ProductCompare compare : comparedList){
                if (compare.getProductId().equals(random.getProductId())){
                    System.out.println("Compare 2 product with ID : "+ compare.getProductId());
                    softAssert.assertEquals(compare.getCategoryId(), random.getCategoryId());
                    softAssert.assertEquals(compare.getName(), random.getName());
                    softAssert.assertEquals(compare.getSlug(), random.getSlug());
                    softAssert.assertEquals(compare.getBrand().getBrandId(), random.getBrand().getBrandId());
                    softAssert.assertEquals(compare.getBrand().getBrandName(), random.getBrand().getBrandName());
                    softAssert.assertEquals(compare.getPrice(), random.getPrice());

                }
            }
        }
        softAssert.assertAll();
    }
    public String makerRequestBody(){
        List<ProductResponse> random2Products = getRandomElements( 2);
        String slug1 = random2Products.get(0).getSlug();
        String slug2 = random2Products.get(1).getSlug();
        return String.format("{\"slugs\":[\"%s\",\"%s\"]}", slug1, slug2);
    }
    public  List<ProductResponse> getRandomElements( int numItems) {
        ProductItemsResponse productItemsResponse = scenarioContext.getContext("ProductItemsResponse");
        List<ProductResponse> list = productItemsResponse.getData();
        List<ProductResponse> randomElements = new ArrayList<>();
        Random random = new Random();
        int listSize = list.size();
        if (numItems > listSize) {
            throw new IllegalArgumentException("size is less than "+numItems);
        }
        List<Integer> chosenIndices = new ArrayList<>();
        while (randomElements.size() < numItems) {
            int randomIndex = random.nextInt(listSize);
            if (!chosenIndices.contains(randomIndex)) {
                chosenIndices.add(randomIndex);
                randomElements.add(list.get(randomIndex));
            }
        }
        scenarioContext.setContext("ListProductFromRandom", randomElements);
        return randomElements;
    }
}
