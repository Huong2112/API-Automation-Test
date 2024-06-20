package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import objects.response.orderProduct.ProductOrderListResponse;
import org.testng.Assert;
import services.ProductOrderService;

public class OrderSteps extends BaseStep{

    ProductOrderService productOrderService = new ProductOrderService();

    @Then("Verify number of total order from {string} \\(order_from = pos) should be equal {int}")
    public void verifyNumberOfTotalOrderFromOrder_fromPosShouldBeEqual(String value, int numberOfOrder) {
        ProductOrderListResponse productOrderListResponse = productOrderService.getListOrders();
        scenarioContext.setContext("ProductOrderListResponse", productOrderListResponse);
        Assert.assertTrue(productOrderService.verifyNumberOfOrder(value, numberOfOrder), "Number order from pos is different!");
    }


    @And("Verify order id should be order by DESC")
    public void verifyOrderIdShouldBeOrderByDESC() {
        Assert.assertTrue(productOrderService.verifyOrderIdDESC(), "The order is not DESC");
    }

    @And("Verify order id = {string} should have currency = {string}, exchange_rate = {string}, country = {string}, country_code = {string}")
    public void verifyOrderIdShouldHaveCurrencyExchange_rateCountryCountry_code(String id, String title, String exRate, String cName, String cCode) {
        boolean verifyOrder = productOrderService.verifyOrderWithId(id, title, exRate, cName, cCode);
        Assert.assertTrue(verifyOrder, "Order information with given ID is not match!");
    }
}
