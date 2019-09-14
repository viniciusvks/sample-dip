package br.org.fundatec.lp3.dip.acaoaposgerarnota;

import br.org.fundatec.lp3.dip.dominio.NotaFiscal;
import br.org.fundatec.lp3.dip.servico.GerenciadorContabil;

public class ContabilizaNF implements AcaoAposGerarNota {

	private GerenciadorContabil gerenciadorContabil;

	public ContabilizaNF() {
		gerenciadorContabil = new GerenciadorContabil();
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		gerenciadorContabil.contabiliza(notaFiscal.getValor(), notaFiscal.getImposto());
	}

}
