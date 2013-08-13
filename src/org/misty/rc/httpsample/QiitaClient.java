package org.misty.rc.httpsample;

/**
 * Created with IntelliJ IDEA.
 * User: arai
 * Date: 13/08/13
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class QiitaClient {

    private boolean auth;
    private String token;

    public QiitaClient() {
        this.auth = false;
    }

    public QiitaClient(String token) {
        this.auth = true;
        this.token = token;
    }

    public void authorize() throws Exception {

    }

    public Response get(String url) throws Exception {
        return null;
    }

    public Response get(String url, Parameter[] params) throws Exception {
        return null;
    }

    public Response post(String url, Parameter[] params) throws Exception {
        return null;
    }

    private Response request(Request request) throws Exception {
        return null;
    }
}
