import Business.FitxerProva;
import Persistence.ProvaCSV;
import Presentation.Controller;
import Presentation.Menu;

/**
 * Autors Joan Llobet i Lluis Gumbau
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ProvaCSV provaCSV = new ProvaCSV();
        FitxerProva fitxerProva = new FitxerProva(provaCSV);
        Controller controller = new Controller(menu, fitxerProva);
        controller.iniciProves();

    }
}
