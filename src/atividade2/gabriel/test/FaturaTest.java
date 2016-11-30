package atividade2.gabriel.test;

import atividade2.gabriel.model.Fatura;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FaturaTest {

    private Fatura faturaVazia;
    private Fatura faturaConsultoria;
    private Fatura faturaTreinamento;
    private Fatura faturaOutro;

    private Fatura fatura;

    @Before
    public void setUp() {
        faturaVazia = new Fatura();
        faturaConsultoria = new Fatura("Fatura de uma consultoria qualquer",
                "Endereco do cliente", Fatura.TipoServico.CONSULTORIA, 10f);
        faturaTreinamento = new Fatura("Fatura de uma consultoria qualquer",
                "Endereco do cliente", Fatura.TipoServico.TREINAMENTO, 10f);
        faturaOutro = new Fatura("Fatura de outro servico qualquer",
                "Endereco do cliente", Fatura.TipoServico.OUTRO, 10f);
    }

    @Test
    public void testaConstrutor() {
        Assert.assertNull(faturaVazia.getNomeCliente());
        Assert.assertNull(faturaVazia.getEnderecoCliente());
        Assert.assertNull(faturaVazia.getTipoServico());
        Assert.assertTrue(0.0f == faturaVazia.getValorTotal());

        Assert.assertNotNull(faturaConsultoria.getNomeCliente());
        Assert.assertNotNull(faturaConsultoria.getEnderecoCliente());
        Assert.assertEquals(Fatura.TipoServico.CONSULTORIA, faturaConsultoria.getTipoServico());
        Assert.assertEquals(Fatura.TipoServico.TREINAMENTO, faturaTreinamento.getTipoServico());
        Assert.assertEquals(Fatura.TipoServico.OUTRO, faturaOutro.getTipoServico());

        String nomeFatura = "Nome da fatura";
        String enderecoCliente = "Endereco do cliente";
        float valorTotal = 10f;
        fatura = new Fatura(nomeFatura, enderecoCliente, Fatura.TipoServico.CONSULTORIA, valorTotal);
        Assert.assertEquals(nomeFatura, fatura.getNomeCliente());
        Assert.assertEquals(enderecoCliente, fatura.getEnderecoCliente());
        Assert.assertTrue(valorTotal == fatura.getValorTotal());
    }

    @Test
    public void testaSetNome() {
        String novoNome = "Novo nome da fatura";
        faturaVazia.setNomeCliente(novoNome);
        Assert.assertEquals(novoNome, faturaVazia.getNomeCliente());
    }

    @Test
    public void testaSetNomeVazio() {
        String nomeVazio = "";
        faturaVazia.setNomeCliente(nomeVazio);
        Assert.assertEquals(nomeVazio, faturaVazia.getNomeCliente());
    }

    @Test
    public void testaSetEndereco() {
        String novoEndereco = "Novo endereco do cliente";
        faturaVazia.setEnderecoCliente(novoEndereco);
        Assert.assertEquals(novoEndereco, faturaVazia.getEnderecoCliente());
    }

    @Test
    public void testaSetEnderecoVazio() {
        String enderecoVazio = "";
        faturaVazia.setEnderecoCliente(enderecoVazio);
        Assert.assertEquals(enderecoVazio, faturaVazia.getEnderecoCliente());
    }

    @Test
    public void testaSetTipo() {
        Fatura.TipoServico novoTipo;

        novoTipo = Fatura.TipoServico.CONSULTORIA;
        faturaVazia.setTipoServico(novoTipo);
        Assert.assertEquals(novoTipo, faturaVazia.getTipoServico());

        novoTipo = Fatura.TipoServico.TREINAMENTO;
        faturaVazia.setTipoServico(novoTipo);
        Assert.assertEquals(novoTipo, faturaVazia.getTipoServico());
    }

    @Test
    public void testaSetValorTotal() {
        float valorNulo = 0f;
        faturaVazia.setValorTotal(valorNulo);
        Assert.assertTrue(valorNulo == faturaVazia.getValorTotal());

        float valorNegativo = -1f;
        faturaVazia.setValorTotal(valorNegativo);
        Assert.assertTrue(valorNegativo == faturaVazia.getValorTotal());

        float valorPositivo = +1f;
        faturaVazia.setValorTotal(valorPositivo);
        Assert.assertTrue(valorPositivo == faturaVazia.getValorTotal());

        float valorMinimo = Integer.MIN_VALUE;
        faturaVazia.setValorTotal(valorMinimo);
        Assert.assertTrue(valorMinimo == faturaVazia.getValorTotal());

        float valorMaximo = Integer.MAX_VALUE;
        faturaVazia.setValorTotal(valorMaximo);
        Assert.assertTrue(valorMaximo == faturaVazia.getValorTotal());

        float valorQualquer = Integer.MAX_VALUE;
        faturaVazia.setValorTotal(valorQualquer);
        Assert.assertTrue(valorQualquer == faturaVazia.getValorTotal());
    }

}
