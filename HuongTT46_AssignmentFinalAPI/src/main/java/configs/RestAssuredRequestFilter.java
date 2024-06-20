package configs;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class RestAssuredRequestFilter implements Filter {
    private static final Log log = LogFactory.getLog(RestAssuredRequestFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification reqSpec, FilterableResponseSpecification resSpec, FilterContext ctx) {
        Response response = ctx.next(reqSpec, resSpec);
        if (response.statusCode() !=200){
            log.error(reqSpec.getMethod() + " " + reqSpec.getURI() + " => "+ resSpec.getStatusCode() + " " + resSpec.getStatusLine() );

        }

        log.info(reqSpec.getMethod()+ " " + reqSpec.getURI() + "Request body => " + reqSpec.getBody()+ "\n Response status => "+
                response.getStatusCode() + " " + response.getStatusLine() + " Response body => "+ response.getBody().prettyPrint());

        Allure.addAttachment("INFORMATION: ", reqSpec.getMethod()+ " " + reqSpec.getURI() + "Request body => " + reqSpec.getBody()+ "\n Response status => "+
                response.getStatusCode() + " " + response.getStatusLine() + " Response body => "+ response.getBody().prettyPrint());

        return response;
    }
}
