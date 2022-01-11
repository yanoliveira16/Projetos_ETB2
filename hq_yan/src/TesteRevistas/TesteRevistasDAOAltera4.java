package TesteRevistas;
import Modelo.Fornecedor;
import Modelo.Revistas;
import Persistencia.RevistasDAO;

public class TesteRevistasDAOAltera4 {

    public static void main(String[] args)throws Exception{
    Revistas revistas=new Revistas();
        revistas.setIdRevistas(10);//set
        revistas.setEdicao(60);//WHERE
        revistas.setNome("Homem Aranha");//set
        revistas.setAno("2018");//WHERE
        revistas.setGenero("Ação");//set
        revistas.setTipo("HQ");//set
        revistas.setVisualizacao("200");//set
        Fornecedor forn = new Fornecedor();
        forn.setIdFornecedor(32);//set
        revistas.setFornecedor(forn);
        System.out.println(RevistasDAO.altera4(revistas));
    }
    
}