package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ZkongAPI {

    private static String address = "http://esl.zkong.com:9999";
    private static HttpURLConnection connection = null;
    private static String urlParameters;

    public static ZkongResponceDTO getPublicKey() throws Exception {
        //Create connection
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponceDTO();
    }

    public static ZkongResponceDTO logIn(AuthDTO authDTO) throws Exception {
        //Create connection
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponceDTO();
    }

    public static ZkongResponceDTO importItem (ImportItemDTO importItemDTO) throws Exception {
        //Create connection
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponceDTO();
    }

    public static ZkongResponceDTO deleteItem (DeleteItemDTO deleteItemDTO) throws Exception {
        //Create connection
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponceDTO();
    }

    public static ZkongResponceDTO bindItemWithTag (TagsItemsBindDTO tagsItemsBindDTO) throws Exception {
        //Create connection
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponceDTO();
    }

    private static String doConnect () {
            try {
                //Send request

                DataOutputStream wr = new DataOutputStream (
                        connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.close();

                //Get Response
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
    }
}
