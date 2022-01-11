
package testeUsuario;

import Modelo.Usuario;
import Modelo.Login;
import Persistencia.UsuarioDAO;


public class TesteUsuarioDAOAltera2 {

    public static void main(String[] args) throws Exception {
       Usuario usuario = new Usuario();
       usuario.setIdUsuario(5);;//set
       usuario.setNome("Yan");;//where
       usuario.setIdade(24);;//set
       usuario.setCpf("999");//set
       usuario.setTelefone("99499");//set
       Login login = new Login();
       login.setUsuario(3);;//set
       usuario.setLogin(login);
       
       
        System.out.println(UsuarioDAO.altera2(usuario));
    }
    
}
