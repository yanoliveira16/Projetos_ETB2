package TesteRevistas;
import Modelo.Fornecedor;
import Modelo.Revistas;
import Persistencia.RevistasDAO;

public class TesteRevistasDAOAltera1 {

    public static void main(String[] args)throws Exception{
    Revistas revistas=new Revistas();
        revistas.setIdRevistas(9);//Where
        revistas.setEdicao(70);//set
        revistas.setNome("Super Homen");//set
        revistas.setAno("2019");//set
        revistas.setGenero("Ação");//set
        revistas.setTipo("HQQ");//set
        revistas.setVisualizacao("200");//set
        Fornecedor forn = new Fornecedor();
        forn.setIdFornecedor(32);//set
        revistas.setFornecedor(forn);
        System.out.println(RevistasDAO.altera1(revistas));
    }
    
}