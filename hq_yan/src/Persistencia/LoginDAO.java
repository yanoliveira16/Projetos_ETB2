
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Login;

public class LoginDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Login> leTodos() throws Exception {
        List<Login> listLogins = new ArrayList<Login>();
        try {
            String sql = "SELECT * FROM LOGIN";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Login login = new Login();
                login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
                listLogins.add(login);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listLogins;
    }

    public static Login leUm(int usuario) throws Exception {
        Login login = new Login();
        try {
            String sql = "SELECT * FROM login WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario);
            rs = st.executeQuery();
            if (rs.next()) {
                login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return login;
    }
    
    public static Login leUm2(int senha) throws Exception {
 Login login = new Login();
 
 try{
 String sql = "SELECT * FROM Login WHERE senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, senha);
 rs = st.executeQuery();
 if (rs.next()) 
  login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return login;
 }

public static Login leUm3(int usuario,int senha) throws Exception {
 Login login = new Login();
 
 try{
 String sql = "SELECT * FROM Login WHERE usuario = ? AND senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, usuario);
 st.setInt(2,senha);
 rs = st.executeQuery();
 if (rs.next()) 
  login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return login;
 }


public static Login leUm4(int usuario,int senha) throws Exception {
 Login login = new Login();
 
 try{
 String sql = "SELECT * FROM Login WHERE usuario = ? OR  senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, usuario);
 st.setInt(2, senha);
 rs = st.executeQuery();
 if (rs.next()) 
 login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return login;
 }

    public static int grava(Login login) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO Login (usuario,senha) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, login.getUsuario());
            st.setInt(2, login.getSenha());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(int usuario,int novoUsuario) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE login SET usuario = ? WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, novoUsuario);
            st.setInt(2, usuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera2(int senha,int novoSenha) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Login SET  senha = ? WHERE senha = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoSenha);
 st.setInt(2, senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(int usuario,int novoUsuarios,int senha,int novoSenha) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE login SET  usuario = ?, senha = ? WHERE usuario = ? AND senha  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoUsuarios);
 st.setInt(2, novoSenha);
 st.setInt(3, usuario);
 st.setInt(4, senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(int usuario,int novoUsuarios,int senha,int novoSenha) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE login SET  usuario = ?, senha = ? WHERE usuario = ? AND senha  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoUsuarios);
 st.setInt(2, novoSenha);
 st.setInt(3, usuario);
 st.setInt(4, senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int usuario) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM Login WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int exclui2(int senha) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Login WHERE senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }


public static int exclui3(int usuario,int senha) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Login WHERE usuario = ? AND senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, usuario);
 st.setInt(2, senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(int usuario,int senha) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Login WHERE usuario = ? OR senha = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, usuario);
 st.setInt(2 ,senha);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

   
}