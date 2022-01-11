package TesteRevistas;
import Modelo.Fornecedor;
import Modelo.Revistas;
import Persistencia.RevistasDAO;

public class TesteRevistasDAOGrava {

    public static void main(String[] args)throws Exception{
    Revistas revistas=new Revistas();
        revistas.setIdRevistas(9);
        revistas.setEdicao(50);
        revistas.setNome("Batman");
        revistas.setAno("2019");
        revistas.setGenero("Ação");
        revistas.setTipo("HQ");
        revistas.setVisualizacao("50");
        Fornecedor forn = new Fornecedor();
        forn.setIdFornecedor(32);
        revistas.setFornecedor(forn);
        System.out.println(RevistasDAO.grava(revistas));
    }
    
}