package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOAltera2 {

    public static void main(String[] args)throws Exception{
    Patrocinador patrocinador=new Patrocinador();
        patrocinador.setIdPatrocinador(2);//set
        patrocinador.setNome("Sofia");//where
        patrocinador.setCnpj("4589");//set
        Revistas rev = new Revistas();
        rev.setIdRevistas(10);//set
        patrocinador.setRevistas(rev);
        System.out.println(PatrocinadorDAO.altera2(patrocinador));
    }
    
}