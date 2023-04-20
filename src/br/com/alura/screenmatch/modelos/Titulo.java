package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.anoInvalidoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracao;


    public  Titulo(){

    }
    public Titulo(String nome, int anoLancamento){
        if(anoLancamento > 2023){
            System.out.println("Erro");
        }else{
            this.nome = nome;
            this.anoLancamento = anoLancamento;
        }

    }

    public Titulo(TituloOmdb meuTituloOmd) {
        this.nome = meuTituloOmd.title();
        if(meuTituloOmd.year().length() > 4){
            throw new anoInvalidoException("Não consegui convertar ano, porque tem mais de 4 caracteres");
        }
        this.anoLancamento = Integer.valueOf(meuTituloOmd.year());
        this.duracao = Integer.valueOf(meuTituloOmd.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String movieName) {
        this.nome = movieName;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }


    public void fichaTecnica(){
        System.out.println(this.nome);
        System.out.println(this.anoLancamento);
    }

    public void avaliar(double notas){
        this.somaAvaliacoes += notas;
        totalDeAvaliacoes++;
    }

    public double mediaAvaliacao(){
        return this.somaAvaliacoes / this.totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {

        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", duracao=" + duracao +
                '}';
    }
}
