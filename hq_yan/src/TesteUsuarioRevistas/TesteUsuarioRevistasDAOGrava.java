
package TesteUsuarioRevistas;

import Persistencia.Usuario_has_revistasDAO;

public class TesteUsuarioRevistasDAOGrava{

    public static void main(String[] args)throws Exception{
        System.out.println(Usuario_has_revistasDAO.grava(2, 9, "50", "29/11/19"));
     
    }
}
