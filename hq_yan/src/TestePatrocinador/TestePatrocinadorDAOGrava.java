package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOGrava {

    public static void main(String[] args)throws Exception{
    Patrocinador patrocinador=new Patrocinador();
        patrocinador.setIdPatrocinador(9);
        patrocinador.setNome("Batman");
        patrocinador.setCnpj("1234");
        Revistas rev = new Revistas();
        rev.setIdRevistas(10);
        patrocinador.setRevistas(rev);
        System.out.println(PatrocinadorDAO.grava(patrocinador));
    }
    
}