package br.org.fundatec.lp3.dip.acaoaposgerarnota;

import br.org.fundatec.lp3.dip.dominio.NotaFiscal;
import br.org.fundatec.lp3.dip.servico.NotaFiscalDao;

public class PersisteNF implements AcaoAposGerarNota {

	private NotaFiscalDao notaFiscalDao;

	public PersisteNF() {
		notaFiscalDao = new NotaFiscalDao();
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		notaFiscalDao.persiste(notaFiscal);
	}

}
