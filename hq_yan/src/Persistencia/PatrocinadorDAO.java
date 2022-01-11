
package Persistencia;
import Persistencia.*;
import Modelo.Patrocinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatrocinadorDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;    


    public static List<Patrocinador> leTodos() throws Exception {
        List<Patrocinador> listPatrocinador = new ArrayList<>();
        try {
            String sql = "SELECT * FROM patrocinador";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);;
            rs = st.executeQuery();
            while (rs.next()) {
                Patrocinador p = new Patrocinador();
                p.setIdPatrocinador(rs.getInt("idPatrocinador"));
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
                listPatrocinador.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listPatrocinador;
    }

    public static List<Patrocinador> leTodosCad(int idPatrocinador) throws Exception {
      
            String sql = "SELECT * FROM PATROCINADOR WHERE idPatrocinador like ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1,idPatrocinador);
            rs = st.executeQuery();
             List<Patrocinador> listPatrocinador = new ArrayList<Patrocinador>();
            while (rs.next()) {
                Patrocinador p = new Patrocinador();
                p.setIdPatrocinador(rs.getInt("idPatrocinador"));
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
                listPatrocinador.add(p);
            }
            st.close();
            rs.close();
            return listPatrocinador;
    }
    
    
    
    public static Patrocinador leUm(int idPatrocinador) throws Exception {
        Patrocinador patrocinador = new Patrocinador();
        try {
            String sql = "SELECT * FROM patrocinador WHERE idPatrocinador = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idPatrocinador);
            rs = st.executeQuery();
            if (rs.next()) 
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
                patrocinador.setNome(rs.getString("nome"));
                patrocinador.setCnpj(rs.getString("cnpj"));
                patrocinador.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return patrocinador;
    }
    
    public static Patrocinador leUm2(String nome) throws Exception {
 Patrocinador patrocinador = new Patrocinador();
 
 try{
 String sql = "SELECT * FROM Patrocinador WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
                patrocinador.setNome(rs.getString("nome"));
                patrocinador.setCnpj(rs.getString("cnpj"));
                patrocinador.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return patrocinador;
 }

public static Patrocinador leUm3(String nome, String cnpj) throws Exception {
 Patrocinador patrocinador = new Patrocinador();
 
 try{
 String sql = "SELECT * FROM Patrocinador WHERE nome = ? AND cnpj = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setString(2,cnpj);
 rs = st.executeQuery();
 if (rs.next()) 
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
                patrocinador.setNome(rs.getString("nome"));
                patrocinador.setCnpj(rs.getString("cnpj"));
                patrocinador.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return patrocinador;
 }


public static Patrocinador leUm4(int idRevistas,int idPatrocinador) throws Exception {
 Patrocinador patrocinador = new Patrocinador();
 
 try{
 String sql = "SELECT * FROM Patrocinador WHERE idRevistas = ? OR  idPatrocinador = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idRevistas);
 st.setInt(2, idPatrocinador);
 rs = st.executeQuery();
 if (rs.next()) 
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
                patrocinador.setNome(rs.getString("nome"));
                patrocinador.setCnpj(rs.getString("cnpj"));
                patrocinador.setRevistas(RevistasDAO.leUm(rs.getInt("idRevistas")));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return patrocinador;
 }

    public static int grava(Patrocinador patrocinador) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO patrocinador (idPatrocinador,nome,cnpj,idRevistas) VALUES (?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, patrocinador.getIdPatrocinador());
            st.setString(2, patrocinador.getNome());
            st.setString(3, patrocinador.getCnpj());
            st.setInt(4, patrocinador.getRevistas().getIdRevistas());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera1(Patrocinador patrocinador) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE patrocinador SET cnpj= ?, nome = ?,idRevistas=? WHERE idPatrocinador = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, patrocinador.getCnpj());
            st.setString(2, patrocinador.getNome());
            st.setInt(3, patrocinador.getRevistas().getIdRevistas());
            st.setInt(4, patrocinador.getIdPatrocinador());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+e);
        }
        return ret;
  
    }
    
    public static int altera2(Patrocinador patrocinador) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE patrocinador SET idPatrocinador=?, cnpj=?,idRevistas=? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, patrocinador.getIdPatrocinador());
            st.setString(2, patrocinador.getCnpj());
            st.setInt(3, patrocinador.getRevistas().getIdRevistas());
            st.setString(4, patrocinador.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Patrocinador patrocinador) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE patrocinador SET cnpj= ?,idRevistas=? WHERE idPatrocinador = ? AND nome= ? ";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, patrocinador.getCnpj());
            st.setInt(2, patrocinador.getRevistas().getIdRevistas());
            st.setInt(3, patrocinador.getIdPatrocinador());
            st.setString(4, patrocinador.getNome());
            
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Patrocinador patrocinador) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE patrocinador SET  nome=?, cnpj= ? WHERE idPatrocinador = ? OR idRevistas = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, patrocinador.getNome());
            st.setString(2, patrocinador.getCnpj());
            st.setInt(3, patrocinador.getIdPatrocinador());
            st.setInt(4, patrocinador.getRevistas().getIdRevistas());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int idPatrocinador) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM patrocinador WHERE idPatrocinador = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idPatrocinador);
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
 String sql = "DELETE FROM patrocinador WHERE nome = ?";
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


public static int exclui3(String cnpj,String nome ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM patrocinador WHERE cnpj = ? AND nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cnpj);
 st.setString(2, nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(String nome,int idPatrocinador) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM patrocinador WHERE nome = ? OR idPatrocinador = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2 ,idPatrocinador);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
    
    
    public static void excluiUser(int idPatrocinador) throws Exception{
            String sql = "DELETE FROM patrocinador WHERE idPatrocinador = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idPatrocinador);
            st.executeUpdate();
            st.close();
    }

}

    

