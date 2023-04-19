package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nomeEpisodio;
    private Serie serie;

    public int getTotalvisualizacoes() {
        return totalvisualizacoes;
    }

    public void setTotalvisualizacoes(int totalvisualizacoes) {
        this.totalvisualizacoes = totalvisualizacoes;
    }

    private int totalvisualizacoes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if(totalvisualizacoes > 100){
            return 4;

        }else{
            return 2;
        }
    }
}
