package com.verificador.fraude.application.useCase;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ValidarEnderecoUC {

    private static final String URL = "https://api.opencagedata.com/geocode/v1/json";
    private static final String API_KEY = System.getenv("API_KEY_OPENCAGE_PESSOAL");

    public boolean validarEndereco(String endereco) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", endereco)
                .queryParam("key", API_KEY)
                .queryParam("language", "pt")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MeuAppJava/1.0 (meuemail@example.com)");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            String responseBody = response.getBody();

            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray results = jsonResponse.getJSONArray("results");

            if (results.length() == 0) {
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}