package atividade2.gabriel.test;

import atividade2.gabriel.model.Fatura;
import atividade2.gabriel.model.NotaFiscal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gamer on 28/11/2016.
 */
public class NotaFiscalTeste {

    private Fatura faturaConsultoria;
    private Fatura faturaTreinamento;
    private Fatura faturaOutro;

    @Before
    public void setUp() {
        faturaConsultoria = new Fatura("Fatura de uma consultoria qualquer",
                "Endereco do cliente", Fatura.TipoServico.CONSULTORIA, 10f);
        faturaTreinamento = new Fatura("Fatura de uma consultoria qualquer",
                "Endereco do cliente", Fatura.TipoServico.TREINAMENTO, 10f);
        faturaOutro = new Fatura("Fatura de outro servico qualquer",
                "Endereco do cliente", Fatura.TipoServico.OUTRO, 10f);
    }

    @Test
    public void testaImposto() {
        Assert.assertTrue(0.25f == NotaFiscal.Imposto.CONSULTORIA.getValorImposto());
        Assert.assertTrue(0.15f == NotaFiscal.Imposto.TREINAMENTO.getValorImposto());
        Assert.assertTrue(0.06f == NotaFiscal.Imposto.OUTRO.getValorImposto());
    }

    @Test
    public void TestaConstrutor() {
        NotaFiscal vazioNF = new NotaFiscal();
        Assert.assertNull(vazioNF.getNomeCliente());
        Assert.assertTrue(0.0f == vazioNF.getValorNotaFiscal());
        Assert.assertNull(vazioNF.getImposto());

        NotaFiscal NF1 = new NotaFiscal(faturaConsultoria);
        Assert.assertEquals(faturaConsultoria.getNomeCliente(), NF1.getNomeCliente());
        Assert.assertTrue(faturaConsultoria.getValorTotal() == NF1.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.CONSULTORIA, NF1.getImposto());

        NotaFiscal NF2 = new NotaFiscal(faturaTreinamento);
        Assert.assertEquals(faturaTreinamento.getNomeCliente(), NF2.getNomeCliente());
        Assert.assertTrue(faturaTreinamento.getValorTotal() == NF2.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.TREINAMENTO, NF2.getImposto());

        NotaFiscal NF3 = new NotaFiscal(faturaOutro);
        Assert.assertEquals(faturaOutro.getNomeCliente(), NF3.getNomeCliente());
        Assert.assertTrue(faturaOutro.getValorTotal() == NF3.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.OUTRO, NF3.getImposto());
    }

}
