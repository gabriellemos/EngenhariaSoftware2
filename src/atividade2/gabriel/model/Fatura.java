package atividade2.gabriel.model;

/**
 * Created by gamer on 28/11/2016.
 */
public class Fatura {

    public enum TipoServico {CONSULTORIA, TREINAMENTO, OUTRO};

    private String nomeCliente;
    private String enderecoCliente;
    private TipoServico tipoServico;
    private float valorTotal;

    public Fatura() {}

    public Fatura(String nome, String enderecoCliente, TipoServico tipoServico, float valorTotal) {
        this.nomeCliente = nome;
        this.enderecoCliente = enderecoCliente;
        this.tipoServico = tipoServico;
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
