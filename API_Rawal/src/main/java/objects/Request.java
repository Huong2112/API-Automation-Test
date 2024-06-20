package objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public interface Request {
    default String converObjecToJSONString(){
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
}
