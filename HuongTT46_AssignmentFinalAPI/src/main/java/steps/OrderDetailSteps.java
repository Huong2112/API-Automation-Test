package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.response.orderDetail.DataOrderDetailResponse;
import org.testng.Assert;
import services.OrderDetailService;


public class OrderDetailSteps extends BaseStep {

    OrderDetailService orderDetailService = new OrderDetailService();
    @When("Click to order Detail of id {string}")
    public void clickToOrderDetailOfId(String id) {
        DataOrderDetailResponse dataOrderDetailResponse = orderDetailService.getOrderDetailData();
        System.out.println("Display: "+dataOrderDetailResponse.getData().getOrderId());
        scenarioContext.setContext("DataOrderDetailResponse", dataOrderDetailResponse);

    }

    @Then("Order id should be display {string}")
    public void orderIdShouldBeDisplay(String orderId) {
        Assert.assertTrue(orderDetailService.verifyOrderId(orderId), "Order id not match!");
    }


    @And("Customer first_name and last_name should be: {string} {string}")
    public void customerFirst_nameAndLast_nameShouldBe(String expFirstName, String expLastName) {
        Assert.assertTrue(orderDetailService.verifyFirstName(expFirstName), "First name not match!");
        Assert.assertTrue(orderDetailService.verifyLastName(expLastName), "Last name  not match!");
    }


    @And("Customer_status = {string}")
    public void customer_status(String expCustomerStatus) {
        Assert.assertTrue(orderDetailService.verifyCustomerStatus(expCustomerStatus), "Customer status not match!");
    }


    @And("country_name = {string}")
    public void country_name(String expCountryName) {
        Assert.assertTrue(orderDetailService.verifyCountryName(expCountryName), "Country name not match!");
    }


    @And("state name = {string}")
    public void stateName(String epxSName) {
        Assert.assertTrue(orderDetailService.verifyStateName(epxSName), "State name not match");
    }


    @And("order_from = {string}")
    public void order_from(String expOrderFrom) {
        Assert.assertTrue(orderDetailService.verifyOrderFrom(expOrderFrom), "Order from not match");
    }


    @And("shipping_method = {string}")
    public void shipping_method(String expShippingMethod) {
        Assert.assertTrue(orderDetailService.verifyShippingMethod(expShippingMethod), "Shipping method not match!");
    }


    @And("order_status = {string}")
    public void order_status(String expOrderStatus) {
        Assert.assertTrue(orderDetailService.verifyOrderStatus(expOrderStatus), "Order status not match!");
    }


    @And("order_detail : product_id = {string}")
    public void order_detailProduct_id(String expProductId) {
        Assert.assertTrue(orderDetailService.verifyOrderIdInProductDetail(expProductId), "Product id not match!");
    }


    @And("order_detail : product_sku = {string}")
    public void order_detailProduct_sku(String expSku) {
        Assert.assertTrue(orderDetailService.verifyOrderSkuInProductDetail(expSku), "Product sku not match");
    }
}
