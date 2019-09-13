package br.org.fundatec.lp3.dip;

import java.util.ArrayList;
import java.util.List;

import br.org.fundatec.lp3.dip.acaoaposgerarnota.AcaoAposGerarNota;
import br.org.fundatec.lp3.dip.acaoaposgerarnota.ContabilizaNF;
import br.org.fundatec.lp3.dip.acaoaposgerarnota.EnviaEmail;
import br.org.fundatec.lp3.dip.acaoaposgerarnota.EnviaSMS;
import br.org.fundatec.lp3.dip.acaoaposgerarnota.PersisteNF;

public class App {
	
	public static void main(String[] args) {
		
		List<AcaoAposGerarNota> acoes = new ArrayList<>();
		acoes.add(new ContabilizaNF());
		acoes.add(new EnviaEmail());
		acoes.add(new EnviaSMS());
		acoes.add(new PersisteNF());
		
		Contato contato = new Contato("exemplo@email.com", "5551999999999");
		Fatura fatura = new Fatura(contato, 100.0);

		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);
		gerador.geraNF(fatura);
		
	}

}

