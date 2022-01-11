package TesteRevistas;
import Modelo.Fornecedor;
import Modelo.Revistas;
import Persistencia.RevistasDAO;

public class TesteRevistasDAOAltera2 {

    public static void main(String[] args)throws Exception{
    Revistas revistas=new Revistas();
        revistas.setIdRevistas(9);//set
        revistas.setEdicao(60);//set
        revistas.setNome("Batman");//Where
        revistas.setAno("2018");//set
        revistas.setGenero("Suspense");//set
        revistas.setTipo("HQ");//set
        revistas.setVisualizacao("100");//set
        Fornecedor forn = new Fornecedor();
        forn.setIdFornecedor(33);//set
        revistas.setFornecedor(forn);
        System.out.println(RevistasDAO.altera2(revistas));
    }
    
}