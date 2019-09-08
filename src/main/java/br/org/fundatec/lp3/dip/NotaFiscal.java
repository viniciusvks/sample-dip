package br.org.fundatec.lp3.dip;

public class NotaFiscal {

    private double valor;

    public NotaFiscal(double valor, double imposto) {
        this.valor = valor;
        System.out.println(String.format("nova Nota Fiscal com valor %d, imposto %d", valor, imposto));
    }

    public String getEmailContato() {
        return "";
    }

    public double getValor() {
        return valor;
    }

    public String getTelefoneContato() {

        return "55984297927";

    }
}
