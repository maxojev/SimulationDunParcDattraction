import java.util.Random;

public class SimulationParc {

    static final int maxClients = 10;
    static final int nombreBilletAmettre = 10;
    static final int billetDispo= 15;

    private Client[] clients = new Client[maxClients];
    private int nbClients = 0;

    Billeterie billeterie = new Billeterie(billetDispo);

    private  boolean nouveauClient() {

        if(nbClients == maxClients) {
            System.out.println("Le nombre maximum de clients est"
                    + " atteint.");
            return false;
        }

        Random random = new Random();
        int i = random.nextInt(billetDispo);

        clients[nbClients] = new Client(i, billeterie);
        nbClients++;

        return true;

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

        System.out.println("clients.length: " + clients.length);
        System.out.println("nbClients: " + nbClients);

        /* Instanciation du Responsable billeterie */
        ResponsableBilleterie responsableBilleterie = new ResponsableBilleterie(nombreBilletAmettre, billeterie);
        responsableBilleterie.setDaemon(true);
        responsableBilleterie.start();




        /* ... */
    }

    public static void main(String[] args){

        new SimulationParc();

    }

}
