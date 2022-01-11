
package TesteFornecedor;

import Modelo.Fornecedor;
import Persistencia.FornecedorDAO;

public class TestaFornecedorGravaDAO {

    public static void main(String[] args)throws Exception {
       Fornecedor fornecedor = new Fornecedor();
         fornecedor.setIdFornecedor(32);
         fornecedor.setCnpj("3679");
         fornecedor.setNome("Dieguin");
         fornecedor.setContato("5050");
         fornecedor.setImposto("50");
         System.out.println(FornecedorDAO.grava(fornecedor));
    }
    
}
