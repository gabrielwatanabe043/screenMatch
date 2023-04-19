package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

import static java.util.Collection.*;

public class MainComLista {
    public static void main(String[] args) {
        Filme filme = new Filme("Velozes e Furiosos" , 2023);
        Filme filme2 = new Filme("Assai" , 2010);
        Serie serie = new Serie("Lost", 2008);
        Filme f1 = filme;

        List<Titulo> lista = new LinkedList<>();
        lista.add(filme);
        lista.add(filme2);
        lista.add(serie);
        System.out.println(lista);
        for (Titulo list : lista) {
            System.out.println(list);
            System.out.println(list.getNome());
        }
        f1.setNome("NOME");
        System.out.println(f1.getNome());
        System.out.println(filme.getNome());

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println(lista);
    }
}
