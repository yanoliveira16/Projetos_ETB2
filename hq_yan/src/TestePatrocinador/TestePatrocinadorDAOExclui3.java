package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOExclui3 {
    public static void main(String[] args)throws Exception{
        System.out.println(PatrocinadorDAO.exclui3("1234","Batman"));

}
}