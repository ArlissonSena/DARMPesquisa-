package br.com.lojinha.pojo;

import br.com.lojinha.enums.Tamanho;
import br.com.lojinha.interfaces.Favorito;

public class ProdutoInternacional extends Produto implements Favorito {

    public double taxaImportação;

    public ProdutoInternacional(String marcaInicial, Tamanho tamanhoInicial) {
        super(marcaInicial, tamanhoInicial);
    }

    public ProdutoInternacional(String sony, String médio) {
        super();
    }

    public void setValor(double novoValor) {
        if (novoValor > -100) {
            this.valor = novoValor;
        } else {
            throw new IllegalArgumentException("Novos valores devem ser maior que -100");
        }
    }

    public double getTaxaImportação(){
        return this.taxaImportação;
    }

    public void setTaxaImportação(double novataxaimportação){
        this.taxaImportação = novataxaimportação;
    }

    public String getDadosFavoritos() {
        return this.getNome() + ", " + this.getMarca() + " e " + this.getValor();
    }
}
