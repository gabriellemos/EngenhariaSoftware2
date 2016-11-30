package atividade2.gabriel.model;

/**
 * Created by gamer on 29/11/2016.
 */
public class NotaFiscal {

    public enum Imposto {
        CONSULTORIA(0.25f), TREINAMENTO(0.15f), OUTRO(0.06f);

        private float valorImposto;
        Imposto(float valorImposto) {
            this.valorImposto = valorImposto;
        }

        public float getValorImposto() {
            return valorImposto;
        }
    }

    private String nomeCliente;
    private float valorNotaFiscal;
    private Imposto imposto;

    public NotaFiscal() {}
    public NotaFiscal(Fatura fatura) {
        setNomeCliente(fatura.getNomeCliente());
        setValorNotaFiscal(fatura.getValorTotal());
        setImposto(fatura.getTipoServico());
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(float valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }

    private void setImposto(Fatura.TipoServico tipoServico) {
        if (Fatura.TipoServico.CONSULTORIA.equals(tipoServico)) {
            setImposto(Imposto.CONSULTORIA);
        } else if (Fatura.TipoServico.TREINAMENTO.equals(tipoServico)) {
            setImposto(Imposto.TREINAMENTO);
        } else {
            setImposto(Imposto.OUTRO);
        }
    }

}
