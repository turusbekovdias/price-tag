package kz.datcom.pricetag.service.integration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import kz.datcom.pricetag.dto.*;
import kz.datcom.pricetag.factory.EncryptionPassword;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class ZkongAPI {

    private static String address = "http://esl.zkong.com:9999";
    private static HttpRequest httpRequest;
    private static HttpClient httpClient;


    public static String getPublicKey() throws Exception {
        //Create connection
        try {
            httpClient = HttpClient.newHttpClient();
            httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(address + "/user/getErpPublicKey"))
                    .build();

            HttpResponse response = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue((String) response.body(), Map.class);

            if (map.get("success").equals(true)) {
                return map.get("data").toString();
            } else {
                throw new Exception(map.get("message").toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static ZkongResponseDTO logIn(AuthDTO authDTO) throws Exception {
        //Create connection
        try {

            String publicKey = getPublicKey();

            HttpClient client = HttpClient.newHttpClient();

            Map<String, Object> formData = new HashMap<>();
            formData.put("account", authDTO.getAccount());
            formData.put("loginType", authDTO.getLoginType());
            formData.put("password", EncryptionPassword.encryptByPublicKey(publicKey, authDTO.getPassword()));

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(formData);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address + "/user/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            ZkongResponseDTO map = mapper.readValue((String) response.body(), ZkongResponseDTO.class);

            return map;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ZkongResponseDTO();
    }


    public static ZkongResponseDTO importItem (ImportItemDTO importItemDTO, String token) throws Exception {
        //Create connection
        try {
            HttpClient client = HttpClient.newHttpClient();

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(importItemDTO);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address + "/item/batchImportItem"))
                    .headers("Content-Type", "application/json", "Authorization", token)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            ZkongResponseDTO map = mapper.readValue((String) response.body(), ZkongResponseDTO.class);

            return map;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static ZkongResponseDTO deleteItem (DeleteItemDTO deleteItemDTO, String token) throws Exception {
        //Create connection
        try {
            HttpClient client = HttpClient.newHttpClient();

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(deleteItemDTO);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address + "/item/batchDeleteItem"))
                    .headers("Content-Type", "application/json", "Authorization", token)
                    .method("DELETE", HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            ZkongResponseDTO map = mapper.readValue((String) response.body(), ZkongResponseDTO.class);

            return map;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static ZkongResponseDTO bindItemWithTag (TagsItemsBindDTO tagsItemsBindDTO, String token) throws Exception {
        //Create connection
        try {
            HttpClient client = HttpClient.newHttpClient();

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(tagsItemsBindDTO);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address + "/bind/batchBind"))
                    .headers("Content-Type", "application/json", "Authorization", token)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            ZkongResponseDTO map = mapper.readValue((String) response.body(), ZkongResponseDTO.class);

            return map;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
