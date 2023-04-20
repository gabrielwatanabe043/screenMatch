package br.com.alura.screenmatch.excecao;

public class anoInvalidoException extends RuntimeException{
    private String mensagem;
    public anoInvalidoException(String mensagem){
        this.mensagem = mensagem;

    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
