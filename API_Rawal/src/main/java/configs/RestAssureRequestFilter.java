package configs;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RestAssureRequestFilter implements Filter {

    private static final Log log = LogFactory.getLog(RestAssureRequestFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpecification, FilterableResponseSpecification responseSpecification, FilterContext filterContext) {
        Response response = filterContext.next(requestSpecification, responseSpecification);
        if (response.getStatusCode() != 200){
            System.out.println("Lỗi thì in ra dòng này");
            log.error(requestSpecification.getMethod() + " " + requestSpecification.getURI() +" Body => " + responseSpecification.getStatusCode() + responseSpecification.getStatusLine());
        }
        System.out.println("Lỗi hay không thì vẫn in ra dòng này");
        log.info(requestSpecification.getMethod() +" "+ requestSpecification.getURI() + " Request body => " + requestSpecification.getBody()+
                "\n Response status =>  "+ responseSpecification.getStatusCode()+" "+ responseSpecification.getStatusLine() +  " Response body => " + response.getBody().prettyPrint());

        Allure.addAttachment("REPORT: ",requestSpecification.getMethod() +" "+ requestSpecification.getURI() + " Request body => " + requestSpecification.getBody()+
                "\n Response status =>  "+ responseSpecification.getStatusCode()+" "+ responseSpecification.getStatusLine() +  " Response body => " + response.getBody().prettyPrint());
    return response;
    }
}
