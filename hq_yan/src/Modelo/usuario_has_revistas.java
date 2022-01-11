/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class usuario_has_revistas {
    
  private Usuario usuario;
  private Revistas revista;
    private String acesso;  
    private String data;

    public usuario_has_revistas(Usuario usuario, Revistas revista, String acesso, String data) {
        this.usuario = usuario;
        this.revista = revista;
        this.acesso = acesso;
        this.data = data;
    }

    public usuario_has_revistas() {
    }
    
      @Override
    public String toString() {
        return 
                "\n Acesso:" + getAcesso() + 
                "\n Data: " + getData()+
                "\n " + getUsuario() + 
                "\n " + getRevista() ;
                
    }
 

    public Revistas getRevista() {
        return revista;
    }

    public void setRevista(Revistas revista) {
        this.revista = revista;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
