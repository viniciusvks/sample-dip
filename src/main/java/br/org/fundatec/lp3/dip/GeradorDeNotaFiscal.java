package br.org.fundatec.lp3.dip;

import java.util.List;

import br.org.fundatec.lp3.dip.acaoaposgerarnota.AcaoAposGerarNota;
import br.org.fundatec.lp3.dip.dominio.Contato;
import br.org.fundatec.lp3.dip.dominio.Fatura;
import br.org.fundatec.lp3.dip.dominio.NotaFiscal;

public class GeradorDeNotaFiscal {

    public static final double ALIQUOTA = 0.06;
    private List<AcaoAposGerarNota> acoes;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
    	this.acoes = acoes;
    }

    public NotaFiscal geraNF(Fatura fatura) {

        double valor = fatura.getValor();
        double imposto = impostoSimplesSobre(valor);
        Contato contato = fatura.getContato();

        NotaFiscal notaFiscal = new NotaFiscal(valor, imposto);
        notaFiscal.setEmailContato(contato.getEmail());
        notaFiscal.setTelefoneContato(contato.getTelefone());

        for(AcaoAposGerarNota acao : acoes) {
        	acao.executa(notaFiscal);
        }

        return notaFiscal;

    }

    private double impostoSimplesSobre(double valor) {
        return valor * ALIQUOTA;
    }

}
