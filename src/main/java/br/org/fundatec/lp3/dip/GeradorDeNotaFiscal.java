package br.org.fundatec.lp3.dip;

import java.util.List;

import br.org.fundatec.lp3.dip.acaoaposgerarnota.AcaoAposGerarNota;

public class GeradorDeNotaFiscal {

    public static final double ALIQUOTA = 0.06;
    private List<AcaoAposGerarNota> acoes;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
    	this.acoes = acoes;
    }

    public NotaFiscal gerar(Fatura fatura) {

        double valor = fatura.getValorMensal();
        double imposto = impostoSimplesSobre(valor);

        NotaFiscal notaFiscal = new NotaFiscal(valor, imposto);
        
        for(AcaoAposGerarNota acao : acoes) {
        	acao.executa(notaFiscal);
        }
        
        return notaFiscal;

    }

    private double impostoSimplesSobre(double valor) {
        return valor * ALIQUOTA;
    }

}
