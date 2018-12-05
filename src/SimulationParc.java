import java.util.Random;

public class SimulationParc {

    static final int maxClients = 10;
    static final int nombreBilletAmettre = 100;
    int billetDispo= 20;
    static final  int billetRandom = 8;

    private Client[] clients = new Client[maxClients];
    private int nbClients = 0;
    private Navette[] navettes = new Navette[2];
    private int nbrNavette = 0;

    Billeterie billeterie = new Billeterie(billetDispo);

    Attraction attraction = new Attraction();

    private  boolean nouveauClient() {

        Random random = new Random();
        int i = 1+ random.nextInt(billetRandom);
        System.out.println(i);


        clients[nbClients] = new Client(i, billeterie, attraction);
        nbClients++;

        return true;

    }

    private void nouvelleNavette(){

        navettes[nbrNavette] = new Navette(attraction);
        nbrNavette++;
    }

    SimulationParc() {

        int i;

        /* Instanciation des clients */

        for(i = 0; i < maxClients; i++) {
            nouveauClient();
        }

        for(i = 0; i< clients.length; i++){
            clients[i].start();
        }

//        System.out.println("clients.length: " + clients.length);
//       System.out.println("nbClients: " + nbClients);

        /* Instanciation du Responsable billeterie */
        ResponsableBilleterie responsableBilleterie = new ResponsableBilleterie(nombreBilletAmettre, billeterie);
        responsableBilleterie.setDaemon(true);
        responsableBilleterie.start();


        for(i= 0; i<2; i++){

            nouvelleNavette();
        }

        for(i= 0;i<2;i++){

            navettes[i].setDaemon(true);
            navettes[i].start();
        }


        /* ... */
    }

    public static void main(String[] args){

        new SimulationParc();

    }

}
