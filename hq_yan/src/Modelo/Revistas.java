/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Revistas implements Calcula_imposto,Imposto {
    
    private int idRevistas;
    private int edicao;
    private String nome;
    private String ano;
    private String genero;
    private String tipo;
    private String visualizacao;
    private Fornecedor fornecedor;

    
    @Override
    public Double calculaImpostoHQVarejo(){
        return(ImpostoHQVarejo*valorHQVarejo);
    }
    
    @Override
    public Double calculaImpostoHQUnidade(){
        return(ImpostoHQ*valorHQ);
    }
    
    
    public Revistas() {
    }
    
    public Revistas(int idRevistas, int edicao, String nome, String ano, String genero, String tipo, String visualizacao, Fornecedor fornecedor ) {
        this.idRevistas = idRevistas;
        this.edicao = edicao;
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.tipo = tipo;
        this.visualizacao = visualizacao;
        this.fornecedor = fornecedor;
    }
    
    
     @Override
    public String toString() {
        return "\n Revista:" + getIdRevistas() + 
                "\n Edição:" + getEdicao() +
                "\n Nome:" + getNome() + 
                "\n Ano :" + getAno() +
                "\n Gênero :" + getGenero() +
                "\n Tipo :" + getTipo() +
                "\n Visualizações:" + getVisualizacao()+
                "\n  " + getFornecedor()+
                 "\n Valor Imposto HQ Unidade: "+calculaImpostoHQUnidade()+" Valor Imposto HQ Varejo: "+calculaImpostoHQVarejo()+"";
                
                
    }
    
    

    public int getIdRevistas() {
        return idRevistas;
    }

    public void setIdRevistas(int idRevistas) {
        this.idRevistas = idRevistas;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao(String visualizacao) {
        this.visualizacao = visualizacao;
    }


    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
