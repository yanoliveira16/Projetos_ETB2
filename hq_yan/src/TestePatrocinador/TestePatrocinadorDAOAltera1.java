package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOAltera1 {

    public static void main(String[] args)throws Exception{
    Patrocinador patrocinador=new Patrocinador();
        patrocinador.setIdPatrocinador(9);//where
        patrocinador.setNome("Robin");//set
        patrocinador.setCnpj("147");//set
        Revistas rev = new Revistas();
        rev.setIdRevistas(9);//set
        patrocinador.setRevistas(rev);
        System.out.println(PatrocinadorDAO.altera1(patrocinador));
    }
    
}