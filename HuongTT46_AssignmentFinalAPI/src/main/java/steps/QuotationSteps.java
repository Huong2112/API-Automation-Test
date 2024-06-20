package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.response.quotations.DataQuotationResponse;
import org.testng.Assert;
import services.QuotationsService;

public class QuotationSteps extends BaseStep{
    QuotationsService quotationsService = new QuotationsService();
    @When("Click to purchase quotation")
    public void clickToPurchaseQuotation() {
        DataQuotationResponse dataQuotationResponse = quotationsService.getDataQuotationsResponse();
        scenarioContext.setContext("DataQuotationResponse", dataQuotationResponse);
    }

    @Then("Extract all warehouse in response body")
    public void extractAllWarehouseInResponseBody() {
        quotationsService.extractAllWarehouseInResponseBody();
    }

    @Then("Verify warehouse_name should be display: {string}, {string}")
    public void verifyWarehouse_nameShouldBeDisplay(String name1, String name2) {
        boolean verifyName = quotationsService.verifyWarehouseName(name1, name2);
        Assert.assertTrue(verifyName, "Out of 2 name");
    }

    @And("Verify response should be display {int} supplier with supplier_id order by ASC")
    public void verifyResponseShouldBeDisplaySupplierWithSupplier_idOrderByASC(int number) {
        boolean verifySupplierId  = quotationsService.verifySupplierAsc(number);
        Assert.assertTrue(verifySupplierId, "id is not asc or not equal number expected!");
    }


}
