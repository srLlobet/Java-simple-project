import Business.FitxerEdicio;
import Business.FitxerProva;
import Persistence.EdicioCSV;
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
        EdicioCSV edicioCSV = new EdicioCSV();
        FitxerProva fitxerProva = new FitxerProva(provaCSV);
        FitxerEdicio fitxerEdicio = new FitxerEdicio(edicioCSV);
        Controller controller = new Controller(menu, fitxerProva, fitxerEdicio);
        controller.iniciProves();

    }
}
