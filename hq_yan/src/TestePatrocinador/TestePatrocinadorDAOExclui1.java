package TestePatrocinador;
import Modelo.Patrocinador;
import Modelo.Revistas;
import Persistencia.PatrocinadorDAO;

public class TestePatrocinadorDAOExclui1 {
    public static void main(String[] args)throws Exception{
        System.out.println(PatrocinadorDAO.exclui(2));

}
}