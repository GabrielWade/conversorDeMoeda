package com.conversorDeMoeda;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Request {
    public static void RequestApi(String moeda1, String moeda2, double valor) {
        String moedaImicial = moeda1;
        String moedaConvercao = moeda2;
        double valorConvertido = valor;
        String url = "https://v6.exchangerate-api.com/v6/da050943fb945ebeaa73c3b8/pair";
        Gson gson = new Gson();

        List<String> responses = new ArrayList<>();

        HttpClient client = CreateHttpClient();
        HttpRequest request = CreateRequest(url, moedaImicial, moedaConvercao, valorConvertido);
        SendRequest(client, request, responses);

        MoedaConvertida moedaConvertida = gson.fromJson(responses.get(0), MoedaConvertida.class);
        System.out.println(moedaConvertida);
    }

    private static HttpClient CreateHttpClient() {
        return HttpClient.newHttpClient();
    }

    private static HttpRequest CreateRequest(String url, String moedaImicial, String moedaConvercao, double valorConvertido) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + moedaImicial + "/" + moedaConvercao + "/" + valorConvertido))
                .build();
    }

    private static void SendRequest(HttpClient client, HttpRequest request, List<String> responses) {
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(responseBody -> {
                    responses.add(responseBody);
                })
                .join();
    }
}