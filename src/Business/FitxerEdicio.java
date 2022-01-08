package Business;

import Persistence.EdicioCSV;

import java.util.ArrayList;

public class FitxerEdicio {
    private ArrayList<Edicio> edicions;
    private EdicioCSV edicioCSV;

   public FitxerEdicio(EdicioCSV edicioCSV){
       this.edicions = new ArrayList<Edicio>();
       this.edicions = edicioCSV.llegirDades();
       this.edicioCSV = edicioCSV;
   }

    /**
     * Mètode que afegeix una nova edicio a la llista i al csv.
     * @param anyEdicio Any de l'edicio
     * @param nombreJugadors Nombre de participant de l'edicio
     * @param nombreProves Numero de proves
     * @param llistaProves Nom de les proves totals
     */
   public void afegirEdicio(int anyEdicio, int nombreJugadors, int nombreProves, ArrayList<String> llistaProves){
       edicions.add(new Edicio(anyEdicio, nombreJugadors, nombreProves, llistaProves));
       edicioCSV.addEdicio(anyEdicio, nombreJugadors, nombreProves, llistaProves);
   }

    /**
     * Mètode on mostrem el nom de totes les proves que hi ha en la llista de proves més l'opcio de back
     * @return El número de opcions que mostra el menu, sumem 1 per l'opció back.
     */
   public int mostrarEdicionsB(){
       int i;
       for (i = 0; i < edicions.size(); i++){
           System.out.println("\t" + (i+1) + ") The Trials " + edicions.get(i).getAnyEdicio());
       }
       System.out.println();
       System.out.println("\t"+ (i+1) + ") Back");
       return i+1;
   }

    /**
     * Mètode en mostrem la informacio de l'edició seleccionada per l'usuari
     * @param numEdicio numero de l'edició que ha seleccionat l'usuari
     */
   public void mostrarInformacioEdicio(int numEdicio){
       System.out.println("Year: " + edicions.get(numEdicio - 1).getAnyEdicio());
       System.out.println("Players: " + edicions.get(numEdicio - 1).getNombreJugadors());
       System.out.println("Trials: ");

       for (int j = 0; j < edicions.get(numEdicio - 1).getNombreProves(); j++) {
           System.out.println("\t" + (j+1) + "- " + edicions.get(numEdicio - 1).getLlistaProves().get(j));
       }
   }

    /**
     * Mètode que comprova que l'any seleccionat per l'edició sigui unic, és a dir que no pugui escollir un any ja existent en el csv
     * @param anyEdicio L'any seleccionat per l'usuari
     * @return Booleà que ens indica si l'any que entrem coincideix amb algun ja guardat en el csv
     */
   public boolean anyEdicioExistent(int anyEdicio){
       boolean trobat = false;
       for (int i = 0; i < edicions.size(); i++) {
           if (anyEdicio == edicions.get(i).getAnyEdicio()){
               trobat = true;
           }
       }
       return trobat;
   }

    /**
     * Mètode encarregat de mirar si l'any introduit coincideix amb el seleccionat
     * @param posicio de la edició a la llista
     * @param anySeleccio any de l'edició escollida a eliminar
     * @return si l'any de l'edició coincideix amb el seleccionat per l'usuari
     */
   public boolean buscarAnyEdicioConfirmar(int posicio, int anySeleccio){
       if (edicions.get(posicio - 1).getAnyEdicio() == anySeleccio){
           return true;
       }else {
           return false;
       }
   }

    /**
     * Mètode que duplica l'edicio amb les noves dades seleccionades
     * @param edicioEscollida posicio de la edicio a la llista
     * @param nouAny nou any de l'edició
     * @param nouNumJugadors nou número de jugadors escollits
     */
   public void duplicarEdicio(int edicioEscollida, int nouAny, int nouNumJugadors){
       ArrayList<String> novaLlistaProves = new ArrayList<String>();
       int numeroProves = edicions.get(edicioEscollida - 1).getNombreProves();
       novaLlistaProves = edicions.get(edicioEscollida - 1).getLlistaProves();

       afegirEdicio(nouAny, nouNumJugadors, numeroProves, novaLlistaProves);

   }

    /**
     * Mètode que comprova que els anys de l'edició a eliminar coincideixen i elimina l'edició seleccionada. Reescrivim les dades al csv.
     * @param opcio posicio de l'any dins de la llista/csv
     * @param anyDelete any seleccionat per l'usuari de l'edicio a eliminar
     */
   public void eliminarEdicio(int opcio, int anyDelete){
        if (edicions.get(opcio - 1).getAnyEdicio() == anyDelete){
            //System.out.println(edicions.get(opcio - 1).getAnyEdicio());
            edicions.remove(opcio - 1);
            edicioCSV.reescriureDades();
        }
   }
}
