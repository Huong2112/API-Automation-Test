package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import services.ProductOrderService;

public class OrderSteps extends BaseSteps{

    ProductOrderService productOrderService = new ProductOrderService();
    @Then("The product order should be display {int} order")
    public void theProductOrderShouldBeDisplayOrder(int number) {
        scenarioContext.setContext("ProductOrderListResponse", productOrderService.getListOrders());
        Assert.assertEquals(productOrderService.getNumberOfOrderFromOrderFrom(), number);
    }
}
