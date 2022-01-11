package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOAltera4 {

    public static void main(String[] args)throws Exception{
    Patrocinador patrocinador=new Patrocinador();
        patrocinador.setIdPatrocinador(2);//where
        patrocinador.setNome("Hokage Sofia");//set
        patrocinador.setCnpj("234");//set
        Revistas rev = new Revistas();
        rev.setIdRevistas(9);// OR
        patrocinador.setRevistas(rev);
        System.out.println(PatrocinadorDAO.altera4(patrocinador));
    }
    
}