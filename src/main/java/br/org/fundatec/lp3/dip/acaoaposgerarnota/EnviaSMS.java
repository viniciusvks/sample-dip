package br.org.fundatec.lp3.dip.acaoaposgerarnota;

import br.org.fundatec.lp3.dip.NotaFiscal;
import br.org.fundatec.lp3.dip.servico.EnviadorDeSMS;

public class EnviaSMS implements AcaoAposGerarNota {

	private EnviadorDeSMS enviadorDeSMS;
	
	public EnviaSMS() {
		enviadorDeSMS = new EnviadorDeSMS();
	}
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		
		String telefoneContato = notaFiscal.getTelefoneContato();
		String mensagemDeConfirmacao = "Mensagem de confirmacao";
		enviadorDeSMS.enviarSmsDeConfirmacao(telefoneContato, mensagemDeConfirmacao);
		
	}

}
