package kz.datcom.pricetag.service.integration;

import java.net.HttpURLConnection;
import java.net.URL;


public class ZkongAPI {

    private String address = "http://esl.zkong.com:9999";

    public String connectURL () throws Exception{
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return "";
    }

}
