package services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.orderDetail.DataOrderDetailResponse;
import objects.response.quotations.DataQuotationResponse;
import objects.response.quotations.QuotationResponse;
import objects.response.quotations.SupplierResponse;
import objects.response.quotations.WarehouseResponse;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuotationsService extends BaseRestService{
    public QuotationsService(){
        this.setProtocol("https");
        this.setHost("rawal-admin.themes-coder.net");
    }

    public DataQuotationResponse getDataQuotationsResponse(){
        DataQuotationResponse dataQuotationResponse ;
        getHeaders().put("Authorization", "Bearer "+ scenarioContext.getContext("TOKEN"));
        RequestSpecification requestSpecification = this.getDefaultRequestBuilder("/api/admin/quotation")
                .queryParam("limit", 10)
                .queryParam("searchParameter", "")
                .queryParam("sortBy", "id")
                .queryParam("sortType", "ASC")
                .queryParam("getSupplier", 1)
                .queryParam("getCustomer", 1)
                .queryParam("getWarehouse", 1);

        Response response = this.dispatchServiceRequest(requestSpecification, Method.GET).then().log().body().extract().response();
        ObjectMapper objectMapper = new ObjectMapper();
        String responseString = response.body().asString();
        try {
            dataQuotationResponse = objectMapper.readValue(responseString, DataQuotationResponse.class);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

        return dataQuotationResponse;
    }

    public boolean verifyWarehouseName(String expName1, String expName2){
        DataQuotationResponse dataQuotationResponse = scenarioContext.getContext("DataQuotationResponse");
        List<QuotationResponse> quotationResponses = dataQuotationResponse.getData();
        for (QuotationResponse q : quotationResponses){
            String actualName = q.getWarehouse().getWarehouse_Name();
            if (!(actualName.equalsIgnoreCase(expName1) || actualName.equalsIgnoreCase(expName2))){
                return false;
            }
        }
        return true;
    }

    public void extractAllWarehouseInResponseBody(){
        DataQuotationResponse dataQuotationResponse = scenarioContext.getContext("DataQuotationResponse");
        List<QuotationResponse> quotationResponses = dataQuotationResponse.getData();
        for (QuotationResponse q : quotationResponses){
            WarehouseResponse warehouseResponse = q.getWarehouse();
            System.out.println(warehouseResponse.toString());
        }
    }

    public boolean verifySupplierAsc(int expNumber){
        DataQuotationResponse dataQuotationResponse = scenarioContext.getContext("DataQuotationResponse");
        List<QuotationResponse> quotationResponses = dataQuotationResponse.getData();
        List<SupplierResponse> supplierNotNull = new ArrayList<>();
        int numberSupplier = 0;
        for (QuotationResponse q : quotationResponses){
            SupplierResponse supplierResponse = q.getSupplier();
            numberSupplier++;
            if (supplierResponse != null){
                supplierNotNull.add(supplierResponse);
            }
        }
        boolean isAsc = true;
        for (int i = 0; i < supplierNotNull.size() - 1; i++){
            int formerId = Integer.parseInt(supplierNotNull.get(i).getSupplierID());
            int latterId = Integer.parseInt(supplierNotNull.get(i+1).getSupplierID());
            if (formerId > latterId){
                isAsc = false;
                break;
            }
        }

        return numberSupplier == expNumber && isAsc;
    }
}
