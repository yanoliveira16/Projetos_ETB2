package TesteFornecedor;

import Persistencia.FornecedorDAO;

public class TestaFornecedorAlteraDAO4 {

    public static void main(String[] args)throws Exception {
        System.out.println(FornecedorDAO.altera4("555",31,"Hokage Sofia","258"));
        //                    String contato,int idFornecedor,String nome,String cnpj
    }
    
}
