
package Persistencia;
import Persistencia.*;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;    


    public static List<Usuario> leTodos() throws Exception {
        List<Usuario> listUsuarios = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM usuario";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);;
            rs = st.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                u.setCpf(rs.getString("cpf"));
                u.setTelefone(rs.getString("telefone"));
                u.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
                listUsuarios.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listUsuarios;
    }

    public static List<Usuario> leTodosCad(int idUsuario) throws Exception {
      
            String sql = "SELECT * FROM USUARIO WHERE idUsuario like ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1,idUsuario);
            rs = st.executeQuery();
             List<Usuario> listUsuarios = new ArrayList<Usuario>();
            while (rs.next()) {
                 Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                u.setTelefone(rs.getString("telefone"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
                listUsuarios.add(u);
            }
            st.close();
            rs.close();
            return listUsuarios;
    }
    
    
    
    public static Usuario leUm(int idUsuario) throws Exception {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idUsuario);
            rs = st.executeQuery();
            if (rs.next()) 
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCpf(rs.getString("cpf"));            
                usuario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
    public static Usuario leUm2(String nome) throws Exception {
 Usuario usuario = new Usuario();
 
 try{
 String sql = "SELECT * FROM Usuario WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
                usuario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCpf(rs.getString("cpf"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return usuario;
 }

public static Usuario leUm3(String nome, int idade) throws Exception {
 Usuario usuario = new Usuario();
 
 try{
 String sql = "SELECT * FROM Usuario WHERE nome = ? AND idade = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2,idade);
 rs = st.executeQuery();
 if (rs.next()) 
usuario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCpf(rs.getString("cpf"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return usuario;
 }


public static Usuario leUm4(int Login_usuario,int idUsuario) throws Exception {
 Usuario usuario = new Usuario();
 
 try{
 String sql = "SELECT * FROM Usuario WHERE Login_usuario = ? OR  idUsuario = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, Login_usuario);
 st.setInt(2, idUsuario);
 rs = st.executeQuery();
 if (rs.next()) 
usuario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuario")));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCpf(rs.getString("cpf"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return usuario;
 }

    public static int grava(Usuario usuario) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO usuario (idUsuario,nome,idade,cpf,telefone,Login_usuario) VALUES (?, ?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            st.setString(2, usuario.getNome());
            st.setInt(3,usuario.getIdade());
            st.setString(4, usuario.getCpf());
            st.setString(5, usuario.getTelefone());
            st.setInt(6, usuario.getLogin().getUsuario());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera1(Usuario usuario) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE usuario SET nome = ?,idade = ?,cpf = ?,telefone = ?,Login_usuario=? WHERE idUsuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, usuario.getNome());
            st.setInt(2,usuario.getIdade());
            st.setString(3, usuario.getCpf());
            st.setString(4, usuario.getTelefone());
            st.setInt(5, usuario.getLogin().getUsuario());
            st.setInt(6, usuario.getIdUsuario());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+e);
        }
        return ret;
  
    }
    
    public static int altera2(Usuario usuario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE usuario SET  IdUsuario = ?,idade = ?,cpf = ?,telefone = ?,Login_usuario=? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            st.setInt(2,usuario.getIdade());
            st.setString(3, usuario.getCpf());
            st.setString(4, usuario.getTelefone());
            st.setInt(5, usuario.getLogin().getUsuario());
            st.setString(6, usuario.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Usuario usuario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE usuario SET idade = ?,cpf = ?,telefone = ?,Login_usuario=? WHERE nome = ? AND IdUsuario  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1,usuario.getIdade());
            st.setString(2, usuario.getCpf());
            st.setString(3, usuario.getTelefone());
            st.setInt(4, usuario.getLogin().getUsuario());
            st.setString(5, usuario.getNome());
            st.setInt(6, usuario.getIdUsuario());
            
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Usuario usuario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE usuario SET  IdUsuario = ?,nome = ?,idade = ?,cpf = ? WHERE telefone = ? OR Login_usuario = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            st.setString(2, usuario.getNome());
            st.setInt(3,usuario.getIdade());
            st.setString(4, usuario.getCpf());
            st.setString(5, usuario.getTelefone());
            st.setInt(6, usuario.getLogin().getUsuario());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int idUsuario) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM usuario WHERE idUsuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idUsuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int exclui2(String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM usuario WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }


public static int exclui3(int idade,String telefone ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM usuario WHERE idade = ? AND telefone = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idade);
 st.setString(2, telefone);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(String nome,int idUsuario) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM usuario WHERE nome = ? OR idUsuario = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2 ,idUsuario);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
    
    
    public static void excluiUser(int idUsuario) throws Exception{
            String sql = "DELETE FROM usuario WHERE idUsuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idUsuario);
            st.executeUpdate();
            st.close();
    }

}

    

