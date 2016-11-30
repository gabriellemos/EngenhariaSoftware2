package atividade2.gabriel.test;

import atividade2.gabriel.model.Fatura;
import atividade2.gabriel.model.GeradorNotaFiscal;
import atividade2.gabriel.model.NotaFiscal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeradorNotaFiscalTest {

    private final float[] VALOR_TOTAL = {-10f, 0f, 10f};
    private final String[] NOME_FATURAS = {"Fatura Consultoria", "Fatura Treinamento", "Fatura Outro"};
    private final String[] ENDERECO_CLIENTE = {"Endereço do cliente: 01",
            "Endereço do cliente: 02", "Endereço do cliente: 03"};

    private Fatura faturaConsultoria;
    private Fatura faturaTreinamento;
    private Fatura faturaOutro;

    @Before
    public void setUp() {
        faturaConsultoria = new Fatura(NOME_FATURAS[0], ENDERECO_CLIENTE[0],
                Fatura.TipoServico.CONSULTORIA, VALOR_TOTAL[0]);
        faturaTreinamento = new Fatura(NOME_FATURAS[1], ENDERECO_CLIENTE[1],
                Fatura.TipoServico.TREINAMENTO, VALOR_TOTAL[1]);
        faturaOutro = new Fatura(NOME_FATURAS[2], ENDERECO_CLIENTE[2], Fatura.TipoServico.OUTRO, VALOR_TOTAL[2]);
    }

    @Test
    public void geraNFTest() {
        NotaFiscal consultoriaNF = GeradorNotaFiscal.geraNotaFiscal(faturaConsultoria);
        Assert.assertEquals(NOME_FATURAS[0], consultoriaNF.getNomeCliente());
        Assert.assertTrue(VALOR_TOTAL[0] == consultoriaNF.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.CONSULTORIA, consultoriaNF.getImposto());

        NotaFiscal treinamentoNF = GeradorNotaFiscal.geraNotaFiscal(faturaTreinamento);
        Assert.assertEquals(NOME_FATURAS[1], treinamentoNF.getNomeCliente());
        Assert.assertTrue(VALOR_TOTAL[1] == treinamentoNF.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.TREINAMENTO, treinamentoNF.getImposto());

        NotaFiscal outroNF = GeradorNotaFiscal.geraNotaFiscal(faturaOutro);
        Assert.assertEquals(NOME_FATURAS[2], outroNF.getNomeCliente());
        Assert.assertTrue(VALOR_TOTAL[2] == outroNF.getValorNotaFiscal());
        Assert.assertEquals(NotaFiscal.Imposto.OUTRO, outroNF.getImposto());
    }

}
