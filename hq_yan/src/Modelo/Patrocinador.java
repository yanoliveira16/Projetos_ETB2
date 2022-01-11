/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Patrocinador extends Pessoa {
    private int idPatrocinador;
    private String cnpj;
    private Revistas revistas;

    public Patrocinador() {
    }


    public Patrocinador(int idPatrocinador, String cnpj, Revistas revistas, String nome, int idade, String telefone) {
        super(nome, idade, telefone);
        this.idPatrocinador = idPatrocinador;
        this.cnpj = cnpj;
        this.revistas = revistas;
    }
    
    

    
     @Override
    public String toString() {
        return "\n =Patrocionador=" + getIdPatrocinador() + 
                "\n Nome:" + getNome() + 
                "\n Cnpj :" + getCnpj() +
                "\n Telefone :" + getTelefone() +
                "\n Idade :" + getIdade() +
                "\n  " + getRevistas();
                
                
    }
    
    
    

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Revistas getRevistas() {
        return revistas;
    }

    public void setRevistas(Revistas revistas) {
        this.revistas = revistas;
    }
    
}
