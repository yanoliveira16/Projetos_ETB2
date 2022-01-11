package TesteFornecedor;

import Persistencia.FornecedorDAO;

public class TestaFornecedorAlteraDAO {

    public static void main(String[] args)throws Exception {
        System.out.println(FornecedorDAO.altera("Sofia",32));
    }
    
}

