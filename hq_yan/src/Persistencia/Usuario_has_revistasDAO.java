
package Persistencia;
import Modelo.usuario_has_revistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario_has_revistasDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    
     public static int grava(int Usuario_idUsuario,int Revistas_idRevistas,String acesso,String data) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO usuario_has_revistas (Usuario_idUsuario,Revistas_idRevistas,acesso,data) VALUES (?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Usuario_idUsuario);
            st.setInt(2, Revistas_idRevistas);
            st.setString(3, acesso);
            st.setString(4, data);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    
public static List<usuario_has_revistas> leTodosPorUsuario(int idUsuario) throws Exception {
        List<usuario_has_revistas> listUsuario_has_revistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM revistas r INNER JOIN "
                    + "usuario_has_revistas uhr ON r.idRevistas = uhr.Revistas_idRevistas "
                    + "WHERE uhr.Usuario_idUsuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idUsuario);
            rs = st.executeQuery();
            while (rs.next()) {
                usuario_has_revistas uhr = new usuario_has_revistas();
                uhr.setUsuario(UsuarioDAO.leUm(rs.getInt("Usuario_idUsuario")));
                uhr.setRevista(RevistasDAO.leUm(rs.getInt("Revistas_idRevistas")));
                uhr.setAcesso(rs.getString("acesso"));
                uhr.setData(rs.getString("data"));
                listUsuario_has_revistas.add(uhr);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return listUsuario_has_revistas;
    }



public static List<usuario_has_revistas> leTodosPorRevistas(int idRevistas) throws Exception {
        List<usuario_has_revistas> listUsuario_has_revistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuario u INNER JOIN "
                    + "usuario_has_revistas uhr ON u.idUsuario = uhr.Usuario_idUsuario "
                    + "WHERE uhr.Revistas_idRevistas = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idRevistas);
            rs = st.executeQuery();
            while (rs.next()) {
                usuario_has_revistas uhr = new usuario_has_revistas();
                uhr.setUsuario(UsuarioDAO.leUm(rs.getInt("Usuario_idUsuario")));
                uhr.setRevista(RevistasDAO.leUm(rs.getInt("Revistas_idRevistas")));
                uhr.setAcesso(rs.getString("acesso"));
                uhr.setData(rs.getString("data"));
                listUsuario_has_revistas.add(uhr);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return listUsuario_has_revistas;


}









public static int alteraPorUsuarioRevistas( int novoRevistas_idRevistas,int novoUsuario_idUsuario,int Usuario_idUsuario,int Revistas_idRevistas) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE usuario_has_revistas set Usuario_idUsuario = ?, Revistas_idRevistas = ? "
                    + "WHERE Usuario_idUsuario = ? AND Revistas_idRevistas = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, novoUsuario_idUsuario);
            st.setInt(2, novoRevistas_idRevistas);
            st.setInt(3, Usuario_idUsuario);
            st.setInt(4, Revistas_idRevistas);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
              if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }  

        return ret;
    }

public static int alteraPorUsuario(int novoUsuario_idUsuario,String novoAcesso,String novaData,int Usuario_idUsuario,int Revistas_idRevistas) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE usuario_has_revistas set Usuario_idUsuario = ?,acesso=?,data=?"
                    + "WHERE Usuario_idUsuario =? AND Revistas_idRevistas=?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, novoUsuario_idUsuario);
            st.setString(2, novoAcesso);
            st.setString(3, novaData);
            st.setInt(4, Usuario_idUsuario);
            st.setInt(5, Revistas_idRevistas);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
        
       
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
         return ret;
}
        public static int alteraPorRevistas(int novoRevistas_idRevistas,String novoAcesso,String novaData,int Usuario_idUsuario,int Revistas_idRevistas) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE usuario_has_revistas set Revistas_idRevistas = ?,acesso=?,data=?"
                    + "WHERE Usuario_idUsuario =? AND Revistas_idRevistas=?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
           st.setInt(1, novoRevistas_idRevistas);
            st.setString(2, novoAcesso);
            st.setString(3, novaData);
            st.setInt(4, Usuario_idUsuario);
            st.setInt(5, Revistas_idRevistas);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
        
       
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
         return ret;
}
        
    
//    public static int alteraPorJuridica(String novoProduto, int novaQuantidade, String cnpj, String codBarra) throws Exception {
//        int ret = 0;
//        try {
//            String sql = "UPDATE juridicaproduto set produto_codbarra = ?, quantidade = ? "
//                    + "WHERE juridica_cnpj = ? and produto_codBarra = ?";
//            connection = GerenteDeConexao.getConnection();
//            st = connection.prepareStatement(sql);
//            st.setString(1, novoProduto);
//            st.setInt(2, novaQuantidade);
//            st.setString(3, cnpj);
//            st.setString(4, codBarra);
//            ret = st.executeUpdate();
//            st.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return ret;
//    }

    public static int excluiPorUsuarioRevistas(int Revistas_idRevistas,int Usuario_idUsuario) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM usuario_has_revistas WHERE Revistas_idRevistas = ? and Usuario_idUsuario = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Revistas_idRevistas);
            st.setInt(2, Usuario_idUsuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }


public static int excluiPorUsuario(int Usuario_idUsuario) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM usuario_has_revistas WHERE Usuario_idUsuario = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Usuario_idUsuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }

public static int excluiPorRevistas(int Revistas_idRevistas) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM usuario_has_revistas WHERE Revistas_idRevistas = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Revistas_idRevistas);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }
















}

    