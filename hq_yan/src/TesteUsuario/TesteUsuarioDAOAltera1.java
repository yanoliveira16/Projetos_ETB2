
package testeUsuario;

import Modelo.Usuario;
import Modelo.Login;
import Persistencia.UsuarioDAO;


public class TesteUsuarioDAOAltera1 {

    public static void main(String[] args) throws Exception {
       Usuario usuario = new Usuario();
       usuario.setIdUsuario(2);;//where
       usuario.setNome("Hokage Sofia");;//set
       usuario.setIdade(24);;//set
       usuario.setCpf("123");//set
       usuario.setTelefone("123456");//set
       Login login = new Login();
       login.setUsuario(3);;//set
       usuario.setLogin(login);
       
       
        System.out.println(UsuarioDAO.altera1(usuario));
    }
    
}
