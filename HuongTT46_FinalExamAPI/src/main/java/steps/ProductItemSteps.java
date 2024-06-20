package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.request.productItemCompare.CompareRequest;
import objects.response.productItemCompare.ProductComparedResponse;
import objects.response.productItems.ProductItemsResponse;
import services.ProductItemCompareService;
import services.ProductItemService;


public class ProductItemSteps extends BaseStep{
    ProductItemService productItemService = new ProductItemService();
    ProductItemCompareService productItemCompareService = new ProductItemCompareService();

    @Given("Call API product-items to get all products of ban-phim")
    public void callAPIProductItemsToGetAllProductsOfBanPhim() {
        ProductItemsResponse productItemsResponse = productItemService.getProductItemsResponse();
        scenarioContext.setContext("ProductItemsResponse", productItemsResponse);
        String body = productItemCompareService.makerRequestBody();
        scenarioContext.setContext("body", body);
        System.out.println(body);
    }

    @When("Extract all product items with some information \\(product_id, category_id, slug, name, brand id, brand name, price).")
    public void extractAllProductItemsWithSomeInformationProduct_idCategory_idSlugNameBrandIdBrandNamePrice() {
        productItemService.extractResponse();
    }

    @And("Call API product-items compare to compare random {int} products in list already extract at above step")
    public void callAPIProductItemsCompareToCompareRandomProductsInListAlreadyExtractAtAboveStep(int number) {
        CompareRequest compareRequest = new CompareRequest(scenarioContext.getContext("body"));
        ProductComparedResponse productComparedResponse = productItemCompareService.getProductComparedResponse(compareRequest);
        scenarioContext.setContext("ListProductOfCompareResult", productComparedResponse.getData());

    }

    @Then("Verify API product-items compare should be return two products and product information must be correct for product_id, category_id, slug, name, brand id, brand name, price")
    public void verifyAPIProductItemsCompareShouldBeReturnTwoProductsAndProductInformationMustBeCorrectForProduct_idCategory_idSlugNameBrandIdBrandNamePrice() {
        productItemCompareService.compareProducts();
    }
}
