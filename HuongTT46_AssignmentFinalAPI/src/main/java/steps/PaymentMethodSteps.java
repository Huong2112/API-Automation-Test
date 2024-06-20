package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.response.paymentMethod.PaymentMethodListResponse;
import org.testng.Assert;
import services.PaymentMethodService;
import java.util.Arrays;
import java.util.List;

public class PaymentMethodSteps extends BaseStep{
    PaymentMethodService paymentMethodService = new PaymentMethodService();
    @When("I click to Payment Method")
    public void iClickToPaymentMethod() {
        PaymentMethodListResponse listPaymentMethod = paymentMethodService.getListPaymentMethod();
        scenarioContext.setContext("ListPaymentMethod", listPaymentMethod);
    }

    @Then("The payment method list should be display:  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void thePaymentMethodListShouldBeDisplay(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        List<String> expectedMethod = Arrays.asList(new String[]{arg0, arg1, arg2, arg3, arg4, arg5,arg6,arg7, arg8});
        boolean verifyListMethod = paymentMethodService.verifyPaymentMethodDisplay(expectedMethod);
        Assert.assertTrue(verifyListMethod, "List payment method is not display all!");
    }

    @And("Payment method {string} should be have {int} payment setting: {string}, {string} and {string}")
    public void paymentMethodShouldBeHavePaymentSettingAnd(String name, int arg1, String arg2, String arg3, String arg4) {
        List<String> expectedKey = Arrays.asList(new String[]{arg2, arg3, arg4});
        boolean verifySetting = paymentMethodService.verifySettingOfPaymentMethod(name, expectedKey, arg1);
        Assert.assertTrue(verifySetting, "Method setting is not display all!");
    }

    @And("Response body should be return status ={string}, message={string} and status_code = {string}")
    public void responseBodyShouldBeReturnStatusMessageAndStatus_code(String status, String message, String statusCode) {
            boolean verifyResponseBody = paymentMethodService.verifyResponseBody(status, message, statusCode);
            Assert.assertTrue(verifyResponseBody, "Response body not match!");
    }



}
