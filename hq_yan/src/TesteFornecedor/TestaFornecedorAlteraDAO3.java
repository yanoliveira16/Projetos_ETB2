package TesteFornecedor;

import Persistencia.FornecedorDAO;

public class TestaFornecedorAlteraDAO3 {

    public static void main(String[] args)throws Exception {
        System.out.println(FornecedorDAO.altera3("Hokage Sofia","3678","505050",32));
        //                         String nome,String cnpj,String contato,int idFornecedor  
    }
    
}

