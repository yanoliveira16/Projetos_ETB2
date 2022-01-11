package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOAltera3 {

    public static void main(String[] args)throws Exception{
    Patrocinador patrocinador=new Patrocinador();
        patrocinador.setIdPatrocinador(2);//where
        patrocinador.setNome("Sofia");//where
        patrocinador.setCnpj("1234");//set
        Revistas rev = new Revistas();
        rev.setIdRevistas(9);//set
        patrocinador.setRevistas(rev);
        System.out.println(PatrocinadorDAO.altera3(patrocinador));
    }
    
}