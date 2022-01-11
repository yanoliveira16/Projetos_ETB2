
package TesteUsuarioRevistas;

import Persistencia.Usuario_has_revistasDAO;

public class TesteUsuarioRevistasDAOAlteraRevistas{

    public static void main(String[] args)throws Exception{
        System.out.println(Usuario_has_revistasDAO.alteraPorRevistas(13,"70","28/11/19",2,9));
     /**   st.setInt(1, novoRevistas_idRevistas);
            st.setString(2, novoAcesso);
            st.setString(3, novaData);
            st.setInt(4, Usuario_idUsuario);
            st.setInt(5, Revistas_idRevistas);
      * 
            */
    }
}
