package org.misty.rc.httpsample;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: arai
 * Date: 13/08/13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class Parameter implements Comparable, Serializable {

    private String key;
    private String value;

    private static final String AMPERSAND = "&";

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Parameter(String key, int value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public Parameter(String key, long value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public String key() {
        return this.key;
    }

    public String value() {
        return this.value;
    }

    public static String encodeParameters(Parameter[] params) {
        if(null == params) {
            return "";
        }

        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < params.length; i++) {
            if(i != 0) {
                buf.append(AMPERSAND);
            }
        }

        return buf.toString();
    }

    @Override
    public int compareTo(Object o) {
        int cnt;
        Parameter param = (Parameter) o;
        cnt = key.compareTo(param.key);
        if(0 == cnt) {
            cnt = value.compareTo(param.value);
        }

        return cnt;
    }
}
