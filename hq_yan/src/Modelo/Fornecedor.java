
package Modelo;

public class Fornecedor {
    private int idFornecedor;
    private String cnpj;
    private String nome;
    private String contato;
    private String imposto;

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String cnpj, String nome, String contato, String imposto) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.nome = nome;
        this.contato = contato;
        this.imposto = imposto;
    }
 
    @Override
    public String toString() {
        return "\n idFornecedores:" + getIdFornecedor() + 
                "\n cnpj:" + getCnpj() +
                "\n nome:" + getNome() + 
                "\n contato:" + getContato() +
                "\n imposto:" + getImposto() ;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the imposto
     */
    public String getImposto() {
        return imposto;
    }

    /**
     * @param imposto the imposto to set
     */
    public void setImposto(String imposto) {
        this.imposto = imposto;
    }
    
}
