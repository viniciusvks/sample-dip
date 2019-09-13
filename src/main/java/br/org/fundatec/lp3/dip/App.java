package br.org.fundatec.lp3.dip;

public class App {
	
	public static void main(String[] args) {
		
		EnviadorDeEmail enviadorDeEmail = new EnviadorDeEmail();
		GerenciadorContabil gerenciadorContabil = new GerenciadorContabil();
		NotaFiscalDao notaFiscalDao = new NotaFiscalDao();
		EnviadorDeSMS enviadorDeSMS = new EnviadorDeSMS();
		
		Contato contato = new Contato("exemplo@email.com", "5551999999999");
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(enviadorDeEmail, notaFiscalDao, gerenciadorContabil, enviadorDeSMS);
		
		Fatura fatura = new Fatura(contato, 100.0);
		
		gerador.geraNF(fatura);
		
	}

}
