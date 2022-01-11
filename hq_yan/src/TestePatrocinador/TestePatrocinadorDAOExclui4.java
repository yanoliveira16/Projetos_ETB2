package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOExclui4 {
    public static void main(String[] args)throws Exception{
        System.out.println(PatrocinadorDAO.exclui4("Batman",9));

}
}