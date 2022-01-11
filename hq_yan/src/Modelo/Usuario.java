/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Usuario extends Pessoa{
    private int idUsuario;
    private String cpf;
    private Login login;


    public Usuario(int idUsuario, String cpf, Login login, String nome, int idade, String telefone) {
        super(nome, idade, telefone);
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.login = login;
    }




    public Usuario() {
    }
    
    
      @Override
    public String toString() {
        return "\n =Usuário=" + getIdUsuario() + 
                "\n Idade:" + getIdade() +
                "\n Nome:" + getNome() + 
                "\n CPF: " + getCpf() +
                "\n Telefone:" + getTelefone() +
                "\n  " + getLogin();
                
                
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
}
