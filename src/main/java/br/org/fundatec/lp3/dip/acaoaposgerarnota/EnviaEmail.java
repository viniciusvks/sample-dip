package br.org.fundatec.lp3.dip.acaoaposgerarnota;

import br.org.fundatec.lp3.dip.NotaFiscal;
import br.org.fundatec.lp3.dip.servico.EnviadorDeEmail;

public class EnviaEmail implements AcaoAposGerarNota {
	
	private EnviadorDeEmail enviadorDeEmail;
	
	public EnviaEmail() {
		enviadorDeEmail = new EnviadorDeEmail();
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		enviadorDeEmail.enviarEmail(notaFiscal.getEmailContato());
	}

}
