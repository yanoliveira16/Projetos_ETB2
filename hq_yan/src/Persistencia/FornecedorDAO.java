
package Persistencia;

import Persistencia.*;
import Modelo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Fornecedor> leTodos() throws Exception{
List<Fornecedor> listFornecedors = new ArrayList<Fornecedor>();
try {
String sql = "SELECT * FROM Fornecedor";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Fornecedor fornecedor = new Fornecedor();
 fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
 fornecedor.setCnpj(rs.getString("cnpj"));
 fornecedor.setNome(rs.getString("nome"));
 fornecedor.setContato(rs.getString("contato"));
 fornecedor.setImposto(rs.getString("imposto"));  
 listFornecedors.add(fornecedor);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listFornecedors;
 }

public static Fornecedor leUm(int idFornecedor) throws Exception {
 Fornecedor fornecedor = new Fornecedor();
 
 try{
 String sql = "SELECT * FROM Fornecedor WHERE idFornecedor = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idFornecedor);
 rs = st.executeQuery();
 if (rs.next()) 
 fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
 fornecedor.setCnpj(rs.getString("cnpj"));
 fornecedor.setNome(rs.getString("nome"));
 fornecedor.setContato(rs.getString("contato"));
  fornecedor.setImposto(rs.getString("imposto")); 
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return fornecedor;
 }

public static Fornecedor leUm2(String cnpj) throws Exception {
 Fornecedor fornecedor = new Fornecedor();
 try{
 String sql = "SELECT * FROM Fornecedor WHERE cnpj = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cnpj);
 rs = st.executeQuery();
 if (rs.next()) 
 fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
 fornecedor.setCnpj(rs.getString("cnpj"));
 fornecedor.setNome(rs.getString("nome"));
 fornecedor.setContato(rs.getString("contato"));
 fornecedor.setImposto(rs.getString("imposto"));  
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return fornecedor;
 }

public static Fornecedor leUm3(String nome, String contato) throws Exception {
 Fornecedor fornecedor = new Fornecedor();
 
 try{
 String sql = "SELECT * FROM Fornecedor WHERE nome = ? AND contato = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setString(2, contato);
 rs = st.executeQuery();
 if (rs.next()) 
 fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
 fornecedor.setCnpj(rs.getString("cnpj"));
 fornecedor.setNome(rs.getString("nome"));
 fornecedor.setContato(rs.getString("contato")); 
  fornecedor.setImposto(rs.getString("imposto")); 
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return fornecedor;
 }


public static Fornecedor leUm4(int idFornecedor, String cnpj) throws Exception {
 Fornecedor fornecedor = new Fornecedor(); 
 try{
 String sql = "SELECT * FROM Fornecedor WHERE idFornecedor = ? OR cnpj = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idFornecedor);
 st.setString(2, cnpj);
 rs = st.executeQuery();
 if (rs.next()) 
 fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
 fornecedor.setCnpj(rs.getString("cnpj"));
 fornecedor.setNome(rs.getString("nome"));
 fornecedor.setContato(rs.getString("contato"));
 fornecedor.setImposto(rs.getString("imposto"));  
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return fornecedor;
 }




public static int grava(Fornecedor fornecedor) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO Fornecedor (idFornecedor,nome,cnpj,contato,imposto) VALUES (?, ?, ?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, fornecedor.getIdFornecedor());
 st.setString(2, fornecedor.getNome());
 st.setString(3, fornecedor.getCnpj());
 st.setString(4, fornecedor.getContato());
 st.setString(5, fornecedor.getImposto());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }



public static int altera(String nome,int idFornecedor) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Fornecedor SET nome = ? WHERE idFornecedor = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2, idFornecedor);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }


public static int altera2(String cnpj,String nome) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Fornecedor SET cnpj = ? WHERE nome = ?";
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


    
    public static int altera3(String nome,String cnpj,String contato,int idFornecedor) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE Fornecedor SET nome = ?, cnpj = ? WHERE contato = ? AND idFornecedor = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString (1, nome);
            st.setString(2,cnpj);
            st.setString(3,contato);
            st.setInt(4, idFornecedor);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera4(String contato,int idFornecedor,String nome,String cnpj) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE Fornecedor SET contato = ?, idFornecedor = ? WHERE nome = ? OR cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString (1, contato);
            st.setInt(2, idFornecedor);
            st.setString(3,nome);
            st.setString(4, cnpj);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

public static int exclui(int idFornecedor) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Fornecedor WHERE idFornecedor = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idFornecedor);
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
 String sql = "DELETE FROM Fornecedor WHERE nome = ?";
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


public static int exclui3(String contato, String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Fornecedor WHERE contato = ? AND nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, contato);
 st.setString(2 ,nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(int idFornecedor, String cnpj) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Fornecedor WHERE idFornecedor = ? OR cnpj = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idFornecedor);
 st.setString(2, cnpj);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

}
