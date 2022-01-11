package testes.login;

import Modelo.Login;
import Persistencia.LoginDAO;

public class TestaLoginGravaDAO {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setUsuario(6);
        login.setSenha(258);
        System.out.println(LoginDAO.grava(login));
    }

}
