
package testeUsuario;

import Modelo.Usuario;
import Modelo.Login;
import Persistencia.UsuarioDAO;


public class TesteUsuarioDAOAltera3 {

    public static void main(String[] args) throws Exception {
       Usuario usuario = new Usuario();
       usuario.setIdUsuario(4);;//where
       usuario.setNome("Davi");;//where
       usuario.setIdade(25);;//set
       usuario.setCpf("888");//set
       usuario.setTelefone("8888");//set
       Login login = new Login();
       login.setUsuario(1);;//set
       usuario.setLogin(login);
       
       
        System.out.println(UsuarioDAO.altera3(usuario));
    }
    
}
