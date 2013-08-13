package org.misty.rc.httpsample;

/**
 * Created with IntelliJ IDEA.
 * User: arai
 * Date: 13/08/13
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public class Request {

    private final RequestMethod method;
    private final String url;
    private final Parameter[] params;
    private static final Parameter[] NULL_PARAMS = new Parameter[0];

    public Request(RequestMethod method, String url, Parameter[] params) {

        this.method = method;
        if(method != RequestMethod.POST && params != null && params.length != 0) {
            //GET
            this.url = url + "?"; //TODO: encode parameter to url-strings
            this.params = NULL_PARAMS;
        } else {
            //POST
            this.url = url;
            this.params = params;
        }

    }

    public RequestMethod method() {
        return this.method;
    }

    public String url() {
        return this.url;
    }

    public Parameter[] params() {
        return this.params;
    }
}
