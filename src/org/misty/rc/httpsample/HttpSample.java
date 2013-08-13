package org.misty.rc.httpsample;

import net.arnx.jsonic.JSON;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: arai
 * Date: 13/08/12
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class HttpSample {

    public static void main(String[] args) throws Exception {
        testGet();
    }

    public enum RequestMethod {
        POST,
        GET,
        PUT,
        DELETE
    }

    public class Request {
        private RequestMethod _method;

        public Request(RequestMethod method) {
            this._method = method;
        }
    }

    private void testMethod() throws Exception {
        Request request = new Request(RequestMethod.GET);
    }

    private static void testGet2() throws Exception {
        String apibase = "https://qiita.com/api/v1";
        URL url = new URL(apibase);
        HttpsURLConnection https = (HttpsURLConnection) url.openConnection();

    }

    private static void testGet() throws IOException {
        URL url = new URL("https://qiita.com/api/v1/auth");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.connect();

        String postdata = "url_name=misty_rc&password=Qtqvd8ki";
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(postdata);
        ps.close();

        InputStream is = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuffer buf = new StringBuffer();
        String tmp;

        while ((tmp = reader.readLine()) != null) {
            buf.append(tmp);
        }

        JSON json = new JSON();
        Map<String, ?> map = json.parse(buf);

        String token = (String) map.get("token");
        System.out.println(map.get("token"));
        reader.close();

        conn.disconnect();


        //test
        String apibase = "https://qiita.com/api/v1";

        //user info
        String userinfo = apibase + "/user" + "?token=" + token;
//        String userinfo = apibase + "/user";
        URL url2 = new URL(userinfo);
        HttpsURLConnection conn2 = (HttpsURLConnection) url2.openConnection();
        conn2.setRequestMethod("GET");
        conn2.setDoOutput(true);
        conn2.connect();

/*        String postdata2 = "token=" + token;
        PrintStream ps2 = new PrintStream(conn2.getOutputStream());
        ps2.print(postdata2);
        ps2.close();*/

        InputStream is2 = conn2.getInputStream();
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(is2));

        StringBuffer buf2 = new StringBuffer();
        String tmp2;

        while((tmp2 = reader2.readLine()) != null) {
            buf2.append(tmp2);
        }

        System.out.println(buf2);


    }
}
