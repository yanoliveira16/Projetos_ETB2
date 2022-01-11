
package TesteUsuarioRevistas;

import Persistencia.Usuario_has_revistasDAO;

public class TesteUsuarioRevistasDAOAlteraUsuario{

    public static void main(String[] args)throws Exception{
        System.out.println(Usuario_has_revistasDAO.alteraPorUsuario(4,"80","29/11/19",3,11));
     /**    st.setInt(1, novoUsuario_idUsuario);
            st.setString(2, novoAcesso);
            st.setString(3, novaData);
            st.setInt(4, Usuario_idUsuario);
            st.setInt(5, Revistas_idRevistas);
      * 
            */
    }
}
