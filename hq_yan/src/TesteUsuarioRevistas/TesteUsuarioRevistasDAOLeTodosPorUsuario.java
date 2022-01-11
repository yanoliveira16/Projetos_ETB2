
package TesteUsuarioRevistas;

import Persistencia.Usuario_has_revistasDAO;

public class TesteUsuarioRevistasDAOLeTodosPorUsuario{
    public static void main(String[] args) throws Exception {
        System.out.println(Usuario_has_revistasDAO.leTodosPorUsuario(3));
    }
    
}