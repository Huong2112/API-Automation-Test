package objects.request.productItemCompare;

import objects.Request;

public class CompareRequest implements Request {
    private String body;

    public CompareRequest(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
