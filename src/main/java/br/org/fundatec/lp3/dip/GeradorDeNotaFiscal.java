package br.org.fundatec.lp3.dip;

public class GeradorDeNotaFiscal {

    public static final double ALIQUOTA = 0.06;
    private EnviadorDeEmail enviadorDeEmail;
    private NotaFiscalDao notaFiscalDao;
    private GerenciadorContabil sap;
    private EnviadorDeSMS enviadorDeSMS;

    public GeradorDeNotaFiscal(EnviadorDeEmail enviadorDeEmail, NotaFiscalDao notaFiscalDao, GerenciadorContabil sap, EnviadorDeSMS enviadorDeSMS) {
        this.enviadorDeEmail = enviadorDeEmail;
        this.notaFiscalDao = notaFiscalDao;
        this.sap = sap;
        this.enviadorDeSMS = enviadorDeSMS;
    }

    public NotaFiscal gerar(Fatura fatura) {

        double valor = fatura.getValorMensal();
        double imposto = impostoSimplesSobre(valor);

        NotaFiscal nf = new NotaFiscal(valor, imposto);

        enviadorDeEmail.enviarEmail(nf.getEmailContato());
        sap.contabiliza(nf.getValor());
        enviadorDeSMS.enviarSmsDeConfirmacao(nf.getTelefoneContato(), "Mensagem de confirmacao");
        notaFiscalDao.persiste(nf);

        return nf;

    }


    private double impostoSimplesSobre(double valor) {
        return valor * ALIQUOTA;
    }

}
