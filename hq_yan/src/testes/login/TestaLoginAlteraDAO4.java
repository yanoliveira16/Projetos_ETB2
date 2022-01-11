package testes.login;

import Persistencia.UsuarioDAO;
import Persistencia.LoginDAO;

public class TestaLoginAlteraDAO4 {
    public static void main(String[] args)throws Exception{
        System.out.println(LoginDAO.altera4(9, 1, 123, 888));
        //int usuario,int novoUsuarios,int senha,int novoSenha
    }
    
}
