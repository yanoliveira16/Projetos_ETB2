package testeUsuario;
import Modelo.Usuario;
import Modelo.Login;
import Persistencia.UsuarioDAO;

public class TesteUsuarioDAOGrava {

    public static void main(String[] args)throws Exception{
    Usuario usuario=new Usuario();
        usuario.setIdUsuario(9);
        usuario.setIdade(25);
        usuario.setNome("Wilson");
        usuario.setCpf("42424");
        usuario.setTelefone("449294");
        Login log = new Login();
        log.setUsuario(1);
        usuario.setLogin(log);
        System.out.println(UsuarioDAO.grava(usuario));
    }
    
}