
package testeUsuario;

import Modelo.Usuario;
import Modelo.Login;
import Persistencia.UsuarioDAO;


public class TesteUsuarioDAOAltera4 {

    public static void main(String[] args) throws Exception {
       Usuario usuario = new Usuario();
       usuario.setIdUsuario(0);;//set
       usuario.setNome("Dioka");;//set
       usuario.setIdade(26);;//set
       usuario.setCpf("777");//set
       usuario.setTelefone("2222");//where
       Login login = new Login();
       login.setUsuario(3);;//where
       usuario.setLogin(login);
       
       
        System.out.println(UsuarioDAO.altera4(usuario));
    }
    
}
