Feature: Rawal application assignment final API
  @PaymentMethod
  Scenario: Testcase 1
    Given Login to rawal using email: "owner@email.com" and password:"123"
    When  I click to Payment Method
    Then  The payment method list should be display:  "paypal", "stripe", "banktransfer", "cod", "braintree", "authorize_net", "mollie", "sagepay", "razorpay"
    And Response body should be return status ="Success", message="Data Get Successfully!" and status_code = "200"
    And Payment method "Paypal" should be have 3 payment setting: "PAYPAL_API_SIGNATURE", "PAYPAL_API_PASSWORD" and "PAYPAL_API_USERNAME"

  @Order
  Scenario: Testcase 2
    Given Login to rawal using email: "owner@email.com" and password:"123"
    Then Verify number of total order from "POS" (order_from = pos) should be equal 10
    And Verify order id should be order by DESC
    And Verify order id = "995" should have currency = "INR", exchange_rate = "1.0000", country = "India", country_code = "91"

  @OrderDetail
  Scenario: Testcase 3
    Given Login to rawal using email: "owner@email.com" and password:"123"
    When Click to order Detail of id "990"
    Then Order id should be display "990"
    And Customer first_name and last_name should be: "malik" "bahawal"
    And Customer_status = "0"
    And country_name = "Pakistan"
    And state name = "Punjab"
    And order_from = "pos"
    And shipping_method = "shippingByWeight"
    And order_status = "Complete"
    And order_detail : product_id = "787"
    And order_detail : product_sku = "12wew"


  @Quotation
  Scenario: Testcase 4
    Given Login to rawal using email: "owner@email.com" and password:"123"
    When Click to purchase quotation
    Then Extract all warehouse in response body
    Then Verify warehouse_name should be display: "Labadi", "kuwait"
    And Verify response should be display 10 supplier with supplier_id order by ASC

