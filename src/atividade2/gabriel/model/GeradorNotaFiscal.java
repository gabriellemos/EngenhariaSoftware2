package atividade2.gabriel.model;

import atividade2.gabriel.NotaFiscalDao;
import atividade2.gabriel.SAP;
import atividade2.gabriel.Smtp;

public class GeradorNotaFiscal {

    public static NotaFiscal geraNotaFiscal(Fatura fatura) {
        NotaFiscal NF = new NotaFiscal(fatura);

        new Smtp().envia(NF);
        new SAP().envia(NF);
        new NotaFiscalDao().salva(NF);

        return new NotaFiscal(fatura);
    }

}
