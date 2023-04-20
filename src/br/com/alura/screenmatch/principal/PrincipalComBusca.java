package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca");
        String busca = leitura.nextLine();
        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=963f39fa";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String resposta = response.body();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOmdb meuTituloOmd = gson.fromJson(resposta, TituloOmdb.class);
        System.out.println(meuTituloOmd);

        Titulo meuTitilo = new Titulo(meuTituloOmd);
        System.out.println(meuTitilo);


    }
}
