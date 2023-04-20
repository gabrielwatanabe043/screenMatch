package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.excecao.anoInvalidoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        String busca = "";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();


        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite um filme para busca");
            busca = leitura.nextLine();
            System.out.println("Deseja procurar mais filmes \n" + "Digite SAIR para não buscar");

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=963f39fa";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String resposta = response.body();

                TituloOmdb meuTituloOmd = gson.fromJson(resposta, TituloOmdb.class);
                System.out.println(meuTituloOmd);
                //try {
                Titulo meuTitilo = new Titulo(meuTituloOmd);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitilo);
                titulos.add(meuTitilo);
            }catch (NumberFormatException e){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Aconteceu um erro na busca, verifique URI");
                System.out.println(e.getMessage());
            }catch (anoInvalidoException e){
                System.out.println(e.getMessage());
            }

        }
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println(titulos);

    }
}
