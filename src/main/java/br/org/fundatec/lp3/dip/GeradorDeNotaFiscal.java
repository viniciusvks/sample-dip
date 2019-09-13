package br.org.fundatec.lp3.dip;

public class GeradorDeNotaFiscal {

    public static final double ALIQUOTA = 0.06;
    private EnviadorDeEmail enviadorDeEmail;
    private NotaFiscalDao notaFiscalDao;
    private GerenciadorContabil geranciadorContabil;
    private EnviadorDeSMS enviadorDeSMS;

    public GeradorDeNotaFiscal(EnviadorDeEmail enviadorDeEmail, NotaFiscalDao notaFiscalDao, GerenciadorContabil gerenciadorContabil, EnviadorDeSMS enviadorDeSMS) {
        this.enviadorDeEmail = enviadorDeEmail;
        this.notaFiscalDao = notaFiscalDao;
        this.geranciadorContabil = gerenciadorContabil;
        this.enviadorDeSMS = enviadorDeSMS;
    }

    public NotaFiscal geraNF(Fatura fatura) {

        double valor = fatura.getValor();
        double imposto = impostoSimplesSobre(valor);
        Contato contato = fatura.getContato();

        NotaFiscal nf = new NotaFiscal(valor, imposto);
        nf.setEmailContato(contato.getEmail());
        nf.setTelefoneContato(contato.getTelefone());

        enviadorDeEmail.enviarEmail(nf.getEmailContato());
        geranciadorContabil.contabiliza(nf.getValor(), nf.getImposto());
        enviadorDeSMS.enviarSmsDeConfirmacao(nf.getTelefoneContato(), "Mensagem de confirmacao");
        notaFiscalDao.persiste(nf);

        return nf;

    }


    private double impostoSimplesSobre(double valor) {
        return valor * ALIQUOTA;
    }

}
