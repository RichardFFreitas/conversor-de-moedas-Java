package Modulos;


import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeAPI {

    public static JsonObject buscarTaxas(String moedaBase) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/196f2351135ea4bac80a61ee/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject resposta = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject taxas = resposta.getAsJsonObject("conversion_rates");

        return taxas;
    }
}
