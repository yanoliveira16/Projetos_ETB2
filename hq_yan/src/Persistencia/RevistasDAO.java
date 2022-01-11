
package Persistencia;
import Modelo.Revistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RevistasDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    

public static List<Revistas> leTodos() throws Exception {
        List<Revistas> listRevistas = new ArrayList<Revistas>();
        try {
            String sql = "SELECT * FROM revistas";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);;
            rs = st.executeQuery();
            while (rs.next()) {
                Revistas r = new Revistas();
                r.setIdRevistas(rs.getInt("idRevistas"));
                r.setEdicao(rs.getInt("edicao"));
                r.setNome(rs.getString("nome"));
                r.setAno(rs.getString("ano"));
                r.setGenero(rs.getString("genero"));
                r.setTipo(rs.getString("tipo"));
                r.setVisualizacao(rs.getString("visualizacao"));
                r.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor")));
                listRevistas.add(r);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listRevistas;
    }

    public static List<Revistas> leTodosCad(int idRevistas) throws Exception {
      
            String sql = "SELECT * FROM REVISTAS WHERE idRevistas like ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1,idRevistas);
            rs = st.executeQuery();
             List<Revistas> listRevistas = new ArrayList<Revistas>();
            while (rs.next()) {
              Revistas r = new Revistas();
                r.setIdRevistas(rs.getInt("idRevistas"));
                r.setEdicao(rs.getInt("edicao"));
                r.setNome(rs.getString("nome"));
                r.setAno(rs.getString("ano"));
                r.setGenero(rs.getString("genero"));
                r.setTipo(rs.getString("tipo"));
                r.setVisualizacao(rs.getString("visualizacao"));
                r.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor")));
                listRevistas.add(r);
            }
            st.close();
            rs.close();
            return listRevistas;
    }
    
    
    
    public static Revistas leUm(int idRevistas) throws Exception {
        Revistas revista = new Revistas();
        try {
            String sql = "SELECT * FROM revistas WHERE idRevistas = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idRevistas);
            rs = st.executeQuery();
            if (rs.next())
                revista.setIdRevistas(rs.getInt("idRevistas"));
                revista.setEdicao(rs.getInt("edicao"));
                revista.setNome(rs.getString("nome"));
                revista.setAno(rs.getString("ano"));
                revista.setGenero(rs.getString("genero"));
                revista.setTipo(rs.getString("tipo"));
                revista.setVisualizacao(rs.getString("visualizacao"));
                revista.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor")));
                
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return revista;
    }
    
    public static Revistas leUm2(String nome) throws Exception {
 Revistas revista = new Revistas();
 
 try{
 String sql = "SELECT * FROM revistas WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
                revista.setIdRevistas(rs.getInt("idRevistas"));
                revista.setEdicao(rs.getInt("edicao"));
                revista.setNome(rs.getString("nome"));
                revista.setAno(rs.getString("ano"));
                revista.setGenero(rs.getString("genero"));
                revista.setTipo(rs.getString("tipo"));
                revista.setVisualizacao(rs.getString("visualizacao"));
                revista.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor")));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return revista;
 }

public static Revistas leUm3(String nome, int edicao) throws Exception {
 Revistas revista = new Revistas();
 
 try{
 String sql = "SELECT * FROM Revistas WHERE nome = ? AND edicao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2,edicao);
 rs = st.executeQuery();
 if (rs.next()) 
                revista.setIdRevistas(rs.getInt("idRevistas"));
                revista.setEdicao(rs.getInt("edicao"));
                revista.setNome(rs.getString("nome"));
                revista.setAno(rs.getString("ano"));
                revista.setGenero(rs.getString("genero"));
                revista.setTipo(rs.getString("tipo"));
                revista.setVisualizacao(rs.getString("visualizacao"));
                revista.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor")));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return revista;
 }


public static Revistas leUm4(int idFornecedor,int idRevistas) throws Exception {
 Revistas revista = new Revistas();
 
 try{
 String sql = "SELECT * FROM Revistas WHERE idFornecedor = ? OR  idRevistas = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idFornecedor);
 st.setInt(2, idRevistas);
 rs = st.executeQuery();
 if (rs.next()) 
                revista.setIdRevistas(rs.getInt("idRevistas"));
                revista.setEdicao(rs.getInt("edicao"));
                revista.setNome(rs.getString("nome"));
                revista.setAno(rs.getString("ano"));
                revista.setGenero(rs.getString("genero"));
                revista.setTipo(rs.getString("tipo"));
                revista.setVisualizacao(rs.getString("visualizacao"));
                revista.setFornecedor(FornecedorDAO.leUm(rs.getInt("IdFornecedor"))); 
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return revista;
 }

    public static int grava(Revistas revista) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO revistas (idRevistas,edicao,nome,ano,genero,tipo,visualizacao,idFornecedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, revista.getIdRevistas());
            st.setInt(2, revista.getEdicao());
            st.setString(3, revista.getNome());
            st.setString(4, revista.getAno());
            st.setString(5,revista.getGenero());
            st.setString(6, revista.getTipo());
            st.setString(7, revista.getVisualizacao());
            st.setInt(8, revista.getFornecedor().getIdFornecedor());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera1(Revistas revista) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE revistas SET  edicao = ?,nome = ?,ano = ?,genero = ?,tipo=?,visualizacao=?,idFornecedor=? WHERE idRevistas=? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, revista.getEdicao());
            st.setString(2, revista.getNome());
            st.setString(3, revista.getAno());
            st.setString(4,revista.getGenero());
            st.setString(5, revista.getTipo());
            st.setString(6, revista.getVisualizacao());
            st.setInt(7, revista.getFornecedor().getIdFornecedor());
            st.setInt(8, revista.getIdRevistas());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+e);
        }
        return ret;
  
    }
    
    public static int altera2(Revistas revista) throws Exception {
 int ret = 0;
 try {
    
 String sql =  "UPDATE revistas SET  idRevistas=?,edicao = ?,ano = ?,genero = ?,tipo=?,visualizacao=?,idFornecedor=? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, revista.getIdRevistas());
            st.setInt(2, revista.getEdicao());
            st.setString(3, revista.getAno());
            st.setString(4,revista.getGenero());
            st.setString(5, revista.getTipo());
            st.setString(6, revista.getVisualizacao());
            st.setInt(7, revista.getFornecedor().getIdFornecedor());
            st.setString(8, revista.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Revistas revista) throws Exception {
 int ret = 0;
 try {

 String sql = "UPDATE revistas SET  edicao = ?,ano = ?,genero = ?,tipo=?,visualizacao=?,idFornecedor=? WHERE nome = ? AND idRevistas=? ";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, revista.getEdicao());
            st.setString(2, revista.getAno());
            st.setString(3,revista.getGenero());
            st.setString(4, revista.getTipo());
            st.setString(5, revista.getVisualizacao());
            st.setInt(6, revista.getFornecedor().getIdFornecedor());
            st.setString(7, revista.getNome());
            st.setInt(8, revista.getIdRevistas());
            
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Revistas revista) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE revistas SET idRevistas=?,nome=?,genero = ?,tipo=?,visualizacao=?,idFornecedor=? WHERE edicao = ? AND ano = ? ";

  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, revista.getIdRevistas());
            st.setString(2, revista.getNome());
            st.setString(3,revista.getGenero());
            st.setString(4, revista.getTipo());
            st.setString(5, revista.getVisualizacao());
            st.setInt(6, revista.getFornecedor().getIdFornecedor());
            st.setInt(7, revista.getEdicao());
            st.setString(8, revista.getAno());
            
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int idRevistas) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM revistas WHERE idRevistas = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idRevistas);
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
 String sql = "DELETE FROM revistas WHERE nome = ?";
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


public static int exclui3(int edicao,String ano ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM revistas WHERE edicao = ? AND ano = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, edicao);
 st.setString(2, ano);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(String nome,int idRevistas) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM revistas WHERE nome = ? OR idRevistas = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2 ,idRevistas);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
    
    
    public static void excluiUser(int idRevistas) throws Exception{
            String sql = "DELETE FROM revistas WHERE idRevistas = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, idRevistas);
            st.executeUpdate();
            st.close();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}