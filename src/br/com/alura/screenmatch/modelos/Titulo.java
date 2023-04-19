package br.com.alura.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{
    private String nome;
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
}
